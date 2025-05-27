package ru.denzol.springproject.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.denzol.springproject.dao.PersonDAO;
import ru.denzol.springproject.models.Person;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> found = personDAO.getByEmail(person.getEmail());
        if (found.isPresent() && found.get().getId() != person.getId()) {
            errors.rejectValue("email", "", "Email is already in use");
        }
    }
}
