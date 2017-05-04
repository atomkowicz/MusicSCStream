package com.example.android.musicscstream;

import java.io.Serializable;
import java.util.ArrayList;

public class Song implements Serializable {

    private String songName;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        songName = songName;
    }

    public Song(String songName) {
        this.songName = songName;
    }
}
