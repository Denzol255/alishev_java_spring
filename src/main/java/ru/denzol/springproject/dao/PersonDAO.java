package ru.denzol.springproject.dao;

import jakarta.validation.Valid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.denzol.springproject.models.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id);
    }

    public Optional<Person> getByEmail(String email) {
        try {
            Person person = jdbcTemplate.queryForObject("SELECT * FROM person WHERE email=?", new BeanPropertyRowMapper<>(Person.class), email);
            return Optional.ofNullable(person);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, age, email, address, transport) VALUES(?,?,?,?,?)", person.getName(), person.getAge(), person.getEmail(), person.getAddress());
    }

    public void update(int id, @Valid Person person) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, address=? WHERE id=?", person.getName(), person.getAge(), person.getAddress(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }

    public List<Person> createPeople() {
        List<Person> people = new ArrayList<>(10000);
        for (int i = 0; i < 1000; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("name" + i);
            person.setEmail("email" + i);
            person.setAge(i);
            person.setAddress("address");
            people.add(person);
        }
        return people;
    }

    public void batchInsert() {
        List<Person> people = createPeople();
        long before = System.currentTimeMillis();
        jdbcTemplate.batchUpdate("INSERT INTO person(name, age, email, address) VALUES(?,?,?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, people.get(i).getName());
                ps.setInt(2, people.get(i).getAge());
                ps.setString(3, people.get(i).getEmail());
                ps.setString(3, people.get(i).getAddress());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });
        long after = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (after - before));
    }
}
