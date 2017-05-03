package com.example.android.musicscstream;

import java.util.ArrayList;

/**
 * Created by Aga on 5/3/2017.
 */

public class Song {

    private String songName;
    private int imageId = IMAGE_NOT_AVAILABLE;
    private static final int IMAGE_NOT_AVAILABLE = -1;

    public String getArtistName() {
        return songName;
    }

    public void setArtistName(String pArtistName) {
        songName = pArtistName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int pImageId) {
        imageId = pImageId;
    }


    public Song(String artistName, int artistImageId) {
        this.songName = artistName;
        this.imageId = artistImageId;

    }

    public boolean hasImage() {
        return imageId != IMAGE_NOT_AVAILABLE;
    }
}
