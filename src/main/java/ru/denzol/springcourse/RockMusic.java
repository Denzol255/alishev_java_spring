package ru.denzol.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music {
    List<String> songs = Arrays.asList("I am rock", "Teenagers", "Undead");

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
