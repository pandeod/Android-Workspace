package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<word> words=new ArrayList<word>();

        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_1)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_2)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_3)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_4)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_5)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_6)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_1)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_2)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_3)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_4)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_5)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_6)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_1)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_2)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_3)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_4)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_5)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_6)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_1)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_2)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_3)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_4)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_5)));
        words.add(new word("Member","lutti",getResources().getDrawable(R.drawable.family_6)));



        WordAdapter adpt = new WordAdapter(this,words,R.color.family);
        ListView listView = (ListView) findViewById(R.id.familylist);

        listView.setAdapter(adpt);
    }
}
