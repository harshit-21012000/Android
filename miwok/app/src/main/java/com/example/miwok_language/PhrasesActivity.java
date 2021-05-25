package com.example.miwok_language;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);


       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going?" , "lutti" ,R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?" , "otiiko" ,R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is", "tolooksu",R.raw.phrase_my_name_is));
        words.add(new Word("hoe are you feeling","oyyiss",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("i am feeling good","massoka",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","temmokka",R.raw.phrase_are_you_coming));
        words.add(new Word("yes, i am coming","kenkeau",R.raw.phrase_yes_im_coming));
        words.add(new Word("what is your age" , "kawinta",R.raw.phrase_come_here));
        words.add(new Word("I am ____ years old" , "wo'e",R.raw.phrase_im_coming));
        words.add(new Word("This is for practice","na'achha",R.raw.phrase_lets_go));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=  words.get(position);
                 mediaPlayer = MediaPlayer.create(PhrasesActivity.this , word.getAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
}