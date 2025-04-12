package ru.denzol.springcourse;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    List<Music> musics;
    @Value("${musicPlayer.name}")
    String name;
    @Value("${musicPlayer.volume}")
    int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public MusicPlayer(List<Music> musics) {
        this.musics = musics;
    }

    public void playMusic() {
        Random random = new Random();
        int musicTypeNumber = random.nextInt(MusicType.values().length);
        Music music = musics.get(musicTypeNumber);
        int songNumber = random.nextInt(music.getSongs().size());

        System.out.println("Playing music type with number " + musicTypeNumber + " and song number " + songNumber + " - " + musics.get(musicTypeNumber).getSongs().get(songNumber));
    }
}
