package ru.denzol.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    ClassicalMusic classicalMusic;
    RockMusic rockMusic;
    RapMusic rapMusic;
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

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic, RapMusic rapMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.rapMusic = rapMusic;
    }

    public void playMusic(MusicType musicType) {
        Random random = new Random();
        int songNumber = random.nextInt(3);
        if (musicType.equals(MusicType.ROCK)) {
            System.out.println("Playing: " + rockMusic.getSongs().get(songNumber));
        }
        if (musicType.equals(MusicType.RAP)) {
            System.out.println("Playing: " + rapMusic.getSongs().get(songNumber));
        }
        if (musicType.equals(MusicType.CLASSICAL)) {
            System.out.println("Playing: " + classicalMusic.getSongs().get(songNumber));
        }
    }
}
