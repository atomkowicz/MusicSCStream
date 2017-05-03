package com.example.android.musicscstream;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ArtistListAdapter extends ArrayAdapter<Artist> {

    public ArtistListAdapter(Activity context, ArrayList<Artist> artistArrayList) {
        super(context, 0, artistArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_list_item, parent, false);

            Artist artist = getItem(position);

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_artist_image);


            imageView.setImageResource(artist.getImageId());
            if (artist.hasImage()) {
                imageView.setVisibility(imageView.VISIBLE);
            } else {
                imageView.setVisibility(imageView.GONE);
            }

            TextView singerNameTextView = (TextView) listItemView.findViewById(R.id.list_item_artist_name);
            singerNameTextView.setText(artist.getArtistName());


        }

        return listItemView;
    }
}
