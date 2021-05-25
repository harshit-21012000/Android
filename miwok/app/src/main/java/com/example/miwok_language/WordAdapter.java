package com.example.miwok_language;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;


public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Activity context , ArrayList<Word> words){
        super(context , 0, words);
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
//

        View lisItemView =  convertView;

        if (lisItemView == null){
            lisItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item , parent , false);}

            Word currentWord = getItem(position);

            TextView miwokTextView = (TextView) lisItemView.findViewById(R.id.miwok_text_view);

            miwokTextView.setText(currentWord.getMiwokTranslation());

            TextView defaultTextView = (TextView) lisItemView.findViewById(R.id.default_text_view);

            defaultTextView.setText(currentWord.getDefaultTranslation());

            ImageView imageImageView = (ImageView) lisItemView.findViewById(R.id.icon_image);

            if (currentWord.hasImage()) {
                    imageImageView.setImageResource(currentWord.getImage_resource_id());
                    imageImageView.setVisibility(View.VISIBLE);
            }
            else {
                imageImageView.setVisibility(View.GONE);
            }
            return  lisItemView;


    }

}
