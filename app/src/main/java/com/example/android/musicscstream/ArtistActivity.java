package com.example.android.musicscstream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.artist_toolbar);
        myToolbar.setTitleTextColor(android.graphics.Color.WHITE);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Artist artist = (Artist) intent.getSerializableExtra("artist");

        String artistName = artist.getArtistName();

        TextView nameTextView = (TextView) findViewById(R.id.artist_name);
        nameTextView.setText(artistName);

        int artistAllAlbums = artist.getAlbums().size();

        TextView artistAllAlbumsTextView = (TextView) findViewById(R.id.artist_albums_all);
        artistAllAlbumsTextView.setText(artistAllAlbums + " Albums");

        int artistAllSongs = artist.getSongs().size();

        TextView artistAllSongsTextView = (TextView) findViewById(R.id.artist_songs_all);
        artistAllSongsTextView.setText(artistAllSongs + " songs");

        LinearLayout album1 = (LinearLayout) findViewById(R.id.artist_album_1);
        LinearLayout album2 = (LinearLayout) findViewById(R.id.artist_album_2);
        LinearLayout album3 = (LinearLayout) findViewById(R.id.artist_album_3);

        final ArrayList<Album> albums = artist.getAlbums();

        album1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArtistActivity.this, AlbumActivity.class);
                intent.putExtra("album", albums.get(1));
                startActivity(intent);

            }
        });

        album2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArtistActivity.this, AlbumActivity.class);
                intent.putExtra("album", albums.get(2));
                startActivity(intent);

            }
        });

        album3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArtistActivity.this, AlbumActivity.class);
                intent.putExtra("album", albums.get(3));
                startActivity(intent);

            }
        });
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
