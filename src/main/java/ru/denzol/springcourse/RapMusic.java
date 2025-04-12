package ru.denzol.springcourse;

import java.util.Arrays;
import java.util.List;

public class RapMusic implements Music {
    List<String> songs = Arrays.asList("Lost yourself", "In da club", "False alarm");

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
