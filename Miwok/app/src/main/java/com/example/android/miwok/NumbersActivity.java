package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<word> words=new ArrayList<word>();

        words.add(new word("One","lutti",getResources().getDrawable(R.drawable.num0031)));
        words.add(new word("Two","lutti",getResources().getDrawable(R.drawable.num0032)));
        words.add(new word("Three","lutti",getResources().getDrawable(R.drawable.num0033)));
        words.add(new word("Four","lutti",getResources().getDrawable(R.drawable.num0034)));
        words.add(new word("Five","lutti",getResources().getDrawable(R.drawable.num0035)));
        words.add(new word("Six","lutti",getResources().getDrawable(R.drawable.num0036)));
        words.add(new word("Seven","lutti",getResources().getDrawable(R.drawable.num0037)));
        words.add(new word("Eight","lutti",getResources().getDrawable(R.drawable.num0038)));
        words.add(new word("Nine","lutti",getResources().getDrawable(R.drawable.num0039)));



        WordAdapter adpt = new WordAdapter(this ,words,R.color.num);

        ListView listView = (ListView) findViewById(R.id.numlist);

        listView.setAdapter(adpt);

    }
}
