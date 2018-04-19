package com.example.onkarpande.translatemarathi;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<word> words=new ArrayList<word>();

        words.add(new word("red","weṭeṭṭi",getResources().getDrawable(R.drawable.color_red),R.raw.color_red));
        words.add(new word("green","chokokki",getResources().getDrawable(R.drawable.color_green),R.raw.color_green));
        words.add(new word("brown","ṭakaakki",getResources().getDrawable(R.drawable.color_brown),R.raw.color_brown));
        words.add(new word("gray","ṭopoppi",getResources().getDrawable(R.drawable.color_gray),R.raw.color_gray));
        words.add(new word("black","kululli",getResources().getDrawable(R.drawable.color_black),R.raw.color_black));
        words.add(new word("white","kelelli",getResources().getDrawable(R.drawable.color_white),R.raw.color_white));
        words.add(new word("dusty yellow","ṭopiisә",getResources().getDrawable(R.drawable.color_dusty_yellow),R.raw.color_dusty_yellow));
        words.add(new word("mustard yellow","chiwiiṭә",getResources().getDrawable(R.drawable.color_mustard_yellow),R.raw.color_mustard_yellow));


        WordAdapter wordAdpt = new WordAdapter(this ,words,R.color.clr);

        ListView listView = (ListView) findViewById(R.id.colorslist);

        listView.setAdapter(wordAdpt);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word w = words.get(i);
                MediaPlayer m = MediaPlayer.create(ColorsActivity.this,w.getSound());
                m.start();
            }
        });
    }
}
