package com.example.miwok_language;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red " , "weṭeṭṭi" ,R.drawable.color_red ,R.raw.color_red));
        words.add(new Word("green" ,"chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray","oyyiss",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black","massoka",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white","temmokka",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("dusty yellow","kenkeau",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow" , "kawinta",R.drawable.color_mustard_yellow ,R.raw.color_mustard_yellow));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=  words.get(position);
                 mediaPlayer = MediaPlayer.create(ColorActivity.this , word.getAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
}