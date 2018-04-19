package com.example.onkarpande.miwokfragment;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class numbers extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.list, container, false);

        final ArrayList<word>words = new ArrayList<>();

        words.add(new word("One","lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new word("Two","otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new word("Three","tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new word("Four","oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new word("Five","massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new word("Six","temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new word("Seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new word("Eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new word("Nine","wo’e",R.drawable.number_nine,R.raw.number_nine));

        WordAdapter wordAdapt = new WordAdapter(getActivity(),words,R.color.num);

        ListView listView = view.findViewById(R.id.list);

        if(listView!=null) {
            listView.setAdapter(wordAdapt);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word w= words.get(i);
                MediaPlayer m=MediaPlayer.create(getContext(),w.getAudioId());
                m.start();
            }
        });

        return view;
    }
}
