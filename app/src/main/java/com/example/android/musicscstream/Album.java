package com.example.android.musicscstream;


public class Album {

    private String albumName;
    private int imageId = IMAGE_NOT_AVAILABLE;
    private static final int IMAGE_NOT_AVAILABLE = -1;

    public String getArtistName() {
        return albumName;
    }

    public void setArtistName(String pArtistName) {
        albumName = pArtistName;
    }

    public int getArtistImageId() {
        return imageId;
    }

    public void setArtistImageId(int pArtistImageId) {
        imageId = pArtistImageId;
    }


    public Album(String artistName, int artistImageId) {
        this.albumName = artistName;
        this.imageId = artistImageId;
    }

    public boolean hasImage() {
        return imageId != IMAGE_NOT_AVAILABLE;
    }
}
