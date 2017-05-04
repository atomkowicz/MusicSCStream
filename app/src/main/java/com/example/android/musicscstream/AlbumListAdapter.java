package com.example.android.musicscstream;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumListAdapter extends ArrayAdapter<Album> {

    public AlbumListAdapter(Activity context, ArrayList<Album> albumArrayList) {
        super(context, 0, albumArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_list_item, parent, false);

            Album album = getItem(position);

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_album_image);


            imageView.setImageResource(album.getImageId());
            if (album.hasImage()) {
                imageView.setVisibility(imageView.VISIBLE);
            } else {
                imageView.setVisibility(imageView.GONE);
            }

            TextView singerNameTextView = (TextView) listItemView.findViewById(R.id.list_item_album_name);
            singerNameTextView.setText(album.getAlbumName());


        }

        return listItemView;
    }
}
