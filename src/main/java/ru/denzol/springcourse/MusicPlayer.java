package ru.denzol.springcourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();
    private int volume;
    private String name;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicPlayer() {

    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        String songs = this.getMusicList().stream().map(Music::getSong).collect(Collectors.joining(", "));
        System.out.printf("%s %s playing: %s%n", this.getClass().getSimpleName(), this.getName(), songs);
        System.out.printf("Volume %d%n", this.getVolume());
    }
}
