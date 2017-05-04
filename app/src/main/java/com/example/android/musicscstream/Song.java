package com.example.android.musicscstream;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Aga on 5/3/2017.
 */

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
