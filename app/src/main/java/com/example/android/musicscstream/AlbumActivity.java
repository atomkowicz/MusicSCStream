package com.example.android.musicscstream;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.album_toolbar);
        myToolbar.setTitleTextColor(android.graphics.Color.WHITE);
        myToolbar.setTitle("Album");
        setSupportActionBar(myToolbar);
    }
}
