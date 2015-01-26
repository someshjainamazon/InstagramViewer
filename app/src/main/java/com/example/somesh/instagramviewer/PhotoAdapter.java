package com.example.somesh.instagramviewer;

import android.content.Context;
import android.graphics.Color;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

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
        ImageView ivProfile = (ImageView)convertView.findViewById(R.id.ivProfile);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tvTime);
        TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
        TextView tvComment = (TextView) convertView.findViewById(R.id.tvCommentVal);

        tvUserName.setText(photo.getUsername());
        tvTime.setText(photo.getTimeElapsed());
        tvComment.setText(photo.getComment().getCommenter()+" says - "+photo.getComment().getCommentText());

        /*if(photo.getLikesCount()>=1000) tvLikes.setText((photo.getLikesCount())/1000+"k likes");
        else tvLikes.setText(photo.getLikesCount()+" likes");*/

        tvLikes.setText((NumberFormat.getNumberInstance(Locale.US).format(photo.getLikesCount()))+" likes");
        tvCaption.setText(photo.getCaption());
        //ivPhoto.getLayoutParams().height=photo.getPhotoHeight();
        ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.getPhotoUrl()).into(ivPhoto);

        Transformation transformation = new RoundedTransformationBuilder().borderColor(Color.MAGENTA).borderWidthDp(1).cornerRadiusDp(20).oval(false).build();

        //ivProfile.setImageResource(0);
        Picasso.with(getContext()).load(photo.getProfilePictureUrl()).fit().transform(transformation).into(ivProfile);

        return convertView;
    }
}
