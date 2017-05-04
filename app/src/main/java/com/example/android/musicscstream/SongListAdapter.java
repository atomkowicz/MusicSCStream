package com.example.android.musicscstream;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SongListAdapter extends ArrayAdapter<Song> {

    public SongListAdapter(Activity context, ArrayList<Song> songArrayList) {
        super(context, 0, songArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);

            Song song = getItem(position);

            TextView singerNameTextView = (TextView) listItemView.findViewById(R.id.list_item_song_name);
            singerNameTextView.setText(song.getSongName());


        }

        return listItemView;
    }
}
