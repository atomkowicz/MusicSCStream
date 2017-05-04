package com.example.android.musicscstream;


import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {

    private String albumName;
    private int imageId = IMAGE_NOT_AVAILABLE;
    private static final int IMAGE_NOT_AVAILABLE = -1;

    private ArrayList<Song> songs = new ArrayList<Song>();

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    // Generate songs for current albums
    public Album(String albumName, int artistImageId) {
        this.albumName = albumName;
        this.imageId = artistImageId;

        for (int i = 0; i < 8; i++) {
            songs.add(new Song("Track " + i));
        }
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean hasImage() {
        return imageId != IMAGE_NOT_AVAILABLE;
    }
}
