package com.example.miwok_language;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father " , "lutti", R.drawable.family_father , R.raw.family_father));
        words.add(new Word("mother" , "otiiko", R.drawable.family_mother , R.raw.family_mother));
        words.add(new Word("son", "tolooksu", R.drawable.family_son , R.raw.family_son));
        words.add(new Word("daughter","oyyiss", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother","massoka", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother","temmokka", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister","kenkeau", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister" , "kawinta", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother" , "wo'e", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather","na'achha", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=  words.get(position);
                mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this , word.getAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
}