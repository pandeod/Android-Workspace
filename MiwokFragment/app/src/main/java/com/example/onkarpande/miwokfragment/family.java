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

public class family extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list, container, false);

        final ArrayList<word> words = new ArrayList<>();

        words.add(new word("father","әpә",R.drawable.family_father,R.raw.family_father));
        words.add(new word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        words.add(new word("son","angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter wordAdapt = new WordAdapter(getActivity(),words,R.color.family);

        ListView listView = view.findViewById(R.id.list);

        listView.setAdapter(wordAdapt);

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
