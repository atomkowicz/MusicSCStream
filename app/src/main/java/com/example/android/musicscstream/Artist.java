package com.example.android.musicscstream;

/**
 * Created by Aga on 5/3/2017.
 */

public class Artist {
    private String artistName;
    private int artistImageId = IMAGE_NOT_AVAILABLE;
    private static final int IMAGE_NOT_AVAILABLE = -1;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String pArtistName) {
        artistName = pArtistName;
    }

    public int getArtistImageId() {
        return artistImageId;
    }

    public void setArtistImageId(int pArtistImageId) {
        artistImageId = pArtistImageId;
    }


    public Artist(String artistName, int artistImageId) {
        this.artistName = artistName;
        this.artistImageId = artistImageId;
    }

    public boolean hasImage() {
        return artistImageId != IMAGE_NOT_AVAILABLE;
    }
}
