package com.example.android.musicscstream;

import java.util.ArrayList;

public class Artist {

    private String artistName;
    private int imageId = IMAGE_NOT_AVAILABLE;
    private static final int IMAGE_NOT_AVAILABLE = -1;

    private ArrayList<Album> albums = new ArrayList<Album>();

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String pArtistName) {
        artistName = pArtistName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int pImageId) {
        imageId = pImageId;
    }


    public Artist(String artistName, int artistImageId) {
        this.artistName = artistName;
        this.imageId = artistImageId;

        for (int i = 0; i < 10; i++) {
            albums.add(new Album("Album " + i, R.drawable.album1));
        }

    }

    public boolean hasImage() {
        return imageId != IMAGE_NOT_AVAILABLE;
    }
}
