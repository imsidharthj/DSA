import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class MusicPlayer{
    private String songName;
    private String artist;
    private boolean isPlaying;

    public MusicPlayer(String songName, String artist){
        this.songName = songName;
        this.artist = artist;
        this.isPlaying = false;
    }

    public String getSongName() { return songName; } // Getter for balance

    public String getArtist() { return artist; }

    public boolean getIsPlaying() { return isPlaying; }

    public void playSong(){
        isPlaying = true;
        System.out.println("Now playing: " + songName + " by " + artist);
    }
    public void pauseSong(){
        isPlaying = false;
        System.out.println("Song paused.");
    }
    public void stopSong(){
        isPlaying = false;
        System.out.println("Song stopped.");
    }
}

public class Main {
    public static void main(String[] args) {
        MusicPlayer music = new MusicPlayer("Shape of you", "ED Sheeran");
        music.playSong();
        music.pauseSong();
        music.playSong();
        music.stopSong();
    }
}