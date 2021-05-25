package com.example.miwok_language;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);



        final  ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one " , "lutti" , R.drawable.number_one , R.raw.number_one));
        words.add(new Word("two" , "otiiko", R.drawable.number_two , R.raw.number_two));
        words.add(new Word("three", "tolooksu", R.drawable.number_three , R.raw.number_three));
        words.add(new Word("four","oyyiss", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five","massoka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("sex","temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven","kenkeau", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight" , "kawinta", R.drawable.number_eight , R.raw.number_eight));
        words.add(new Word("nine" , "wo'e", R.drawable.number_nine , R.raw.number_nine));
        words.add(new Word("ten","na'achha", R.drawable.number_ten , R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               Word word=  words.get(position);
//                 mediaPlayer = MediaPlayer.create(NumbersActivity.this , word.getAudioResourceId());
//                mediaPlayer.start();
//            }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });


    }
}