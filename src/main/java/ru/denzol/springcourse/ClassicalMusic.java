package ru.denzol.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    List<String> songs = Arrays.asList("Classic song 1", "Classic song 2", "Classic song 3");

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
