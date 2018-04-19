package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<word> words=new ArrayList<word>();

        words.add(new word("One","lutti"));
        words.add(new word("Two","lutti"));
        words.add(new word("Three","lutti"));
        words.add(new word("Four","lutti"));
        words.add(new word("Five","lutti"));
        words.add(new word("Six","lutti"));
        words.add(new word("Seven","lutti"));
        words.add(new word("Eight","lutti"));
        words.add(new word("Nine","lutti"));
        words.add(new word("One","lutti"));



        WordAdapter adpt = new WordAdapter(this,words,R.color.phrase);
        ListView listView = (ListView) findViewById(R.id.phrlist);

        listView.setAdapter(adpt);
    }
}
