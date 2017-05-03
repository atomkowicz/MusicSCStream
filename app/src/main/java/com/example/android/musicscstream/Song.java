package com.example.android.musicscstream;

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

    public int getArtistImageId() {
        return imageId;
    }

    public void setArtistImageId(int pArtistImageId) {
        imageId = pArtistImageId;
    }


    public Song(String artistName, int artistImageId) {
        this.songName = artistName;
        this.imageId = artistImageId;
    }

    public boolean hasImage() {
        return imageId != IMAGE_NOT_AVAILABLE;
    }
}
