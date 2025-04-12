package ru.denzol.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RapMusic implements Music {
    List<String> songs = Arrays.asList("Lost yourself", "In da club", "False alarm");

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
