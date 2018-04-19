package com.example.onkarpande.translatemarathi;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

       final ArrayList<word> words=new ArrayList<word>();

        words.add(new word("One","lutti",getResources().getDrawable(R.drawable.number_one),R.raw.number_one));
        words.add(new word("Two","otiiko",getResources().getDrawable(R.drawable.number_two),R.raw.number_two));
        words.add(new word("Three","tolookosu",getResources().getDrawable(R.drawable.number_three),R.raw.number_three));
        words.add(new word("Four","oyyisa",getResources().getDrawable(R.drawable.number_four),R.raw.number_four));
        words.add(new word("Five","massokka",getResources().getDrawable(R.drawable.number_five),R.raw.number_five));
        words.add(new word("Six","temmokka",getResources().getDrawable(R.drawable.number_six),R.raw.number_six));
        words.add(new word("Seven","kenekaku",getResources().getDrawable(R.drawable.number_seven),R.raw.number_seven));
        words.add(new word("Eight","kawinta",getResources().getDrawable(R.drawable.number_eight),R.raw.number_eight));
        words.add(new word("Nine","wo’e",getResources().getDrawable(R.drawable.number_nine),R.raw.number_nine));



        WordAdapter wordAdpt = new WordAdapter(this ,words,R.color.num);

        ListView listView = (ListView) findViewById(R.id.numberslist);

        listView.setAdapter(wordAdpt);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             word w = words.get(i);
                MediaPlayer m = MediaPlayer.create(NumbersActivity.this,w.getSound());
                    m.start();
            }
        });
    }
}


