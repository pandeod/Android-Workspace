package com.example.onkarpande.translatemarathi;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

       final ArrayList<word> words=new ArrayList<word>();

        words.add(new word("father","әpә",getResources().getDrawable(R.drawable.family_father),R.raw.family_father));
        words.add(new word("mother","әṭa",getResources().getDrawable(R.drawable.family_mother),R.raw.family_mother));
        words.add(new word("son","angsi",getResources().getDrawable(R.drawable.family_son),R.raw.family_son));
        words.add(new word("daughter","tune",getResources().getDrawable(R.drawable.family_daughter),R.raw.family_daughter));
        words.add(new word("older brother","taachi",getResources().getDrawable(R.drawable.family_older_brother),R.raw.family_older_brother));
        words.add(new word("younger brother","chalitti",getResources().getDrawable(R.drawable.family_younger_brother),R.raw.family_younger_brother));
        words.add(new word("older sister","teṭe",getResources().getDrawable(R.drawable.family_older_sister),R.raw.family_older_sister));
        words.add(new word("younger sister","kolliti",getResources().getDrawable(R.drawable.family_younger_sister),R.raw.family_younger_sister));
        words.add(new word("grandmother","ama",getResources().getDrawable(R.drawable.family_grandmother),R.raw.family_grandmother));
        words.add(new word("grandfather","paapa",getResources().getDrawable(R.drawable.family_grandfather),R.raw.family_grandfather));


        WordAdapter wordAdpt = new WordAdapter(this ,words,R.color.family);

        ListView listView = (ListView) findViewById(R.id.familylist);

        listView.setAdapter(wordAdpt);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word w = words.get(i);
                MediaPlayer m = MediaPlayer.create(FamilyActivity.this,w.getSound());
                m.start();
            }
        });
    }
}
