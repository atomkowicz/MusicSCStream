package com.example.android.musicscstream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.song_toolbar);
        myToolbar.setTitleTextColor(android.graphics.Color.WHITE);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra("song");

        String songName = song.getSongName();

        TextView nameTextView = (TextView) findViewById(R.id.song_name);
        nameTextView.setText(songName);

        /// TODO: add media player using SoundCloud API
        // Android framework:
        // MediaPlayer Class
        // lLibraries to use:
        // 'com.google.code.gson:gson:2.8.0'
        // 'com.squareup.retrofit2:retrofit:2.1.0'
        // 'com.squareup.retrofit2:converter-gson:2.1.0'
        // 'com.squareup.picasso:picasso:2.5.2'

        // tutorial:
        // https://www.sitepoint.com/develop-music-streaming-android-app/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

