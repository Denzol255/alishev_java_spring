package ru.denzol.springcourse;

import java.util.Arrays;
import java.util.List;

public class ClassicalMusic implements Music {
    List<String> songs = Arrays.asList("Classic song 1", "Classic song 2", "Classic song 3");

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
