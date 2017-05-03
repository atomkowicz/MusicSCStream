package com.example.android.musicscstream;


import java.util.ArrayList;

public class Album {

    private String albumName;
    private int imageId = IMAGE_NOT_AVAILABLE;
    private static final int IMAGE_NOT_AVAILABLE = -1;

    private ArrayList<Song> songs = new ArrayList<Song>();


    public String getArtistName() {
        return albumName;
    }

    public void setArtistName(String pArtistName) {
        albumName = pArtistName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int pImageId) {
        imageId = pImageId;
    }


    public Album(String artistName, int artistImageId) {
        this.albumName = artistName;
        this.imageId = artistImageId;


        for (int i = 0; i < 8; i++) {
            songs.add(new Song("Track " + i, R.drawable.album1));
        }
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }


    public boolean hasImage() {
        return imageId != IMAGE_NOT_AVAILABLE;
    }
}
