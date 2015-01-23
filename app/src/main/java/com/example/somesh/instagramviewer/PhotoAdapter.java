package com.example.somesh.instagramviewer;

import android.content.Context;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by somesh on 1/22/15.
 */
public class PhotoAdapter extends ArrayAdapter<Photo> {

    public PhotoAdapter(Context context, ArrayList<Photo> photos){
        super(context, R.layout.item_photo, photos);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Photo photo = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        TextView tvCaption = (TextView)convertView.findViewById(R.id.tvPhoto);
        ImageView ivPhoto = (ImageView)convertView.findViewById(R.id.ivPhoto);
        TextView tvUserName = (TextView)convertView.findViewById(R.id.tvUser);

        tvUserName.setText(photo.getUsername());

        tvCaption.setText(photo.getCaption());
        ivPhoto.getLayoutParams().height=photo.getPhotoHeight();
        ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.getPhotoUrl()).into(ivPhoto);

        return convertView;
    }
}
