package com.example.onkarpande.translatemarathi;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Onkar Pande on 10/14/2017.
 */

public class WordAdapter extends ArrayAdapter<word> {

    public int c;
    public WordAdapter(Context context, ArrayList<word> words ,int color) {
        super(context,0,words);
        c=color;
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.word_list, parent, false);
        }

        final word currentWord = getItem(position);

        TextView mView =(TextView) listItemView.findViewById(R.id.word_list1);
        mView.setText(currentWord.getMarathi());
        int color= ContextCompat.getColor(getContext(),c);
        mView.setBackgroundColor(color);

        TextView eView =(TextView) listItemView.findViewById(R.id.word_list2);
        eView.setText(currentWord.getEnglish());
        eView.setBackgroundColor(color);

        ImageView play =(ImageView) listItemView.findViewById(R.id.word_playButton);
        play.setBackgroundColor(color);

        if(currentWord.draw!=null) {
            ImageView iView = (ImageView) listItemView.findViewById(R.id.word_img);
            iView.setImageDrawable(currentWord.getImage());
            iView.setVisibility(View.VISIBLE);
            iView.setBackgroundColor(color);
        }
        else
        {
            ImageView iView = (ImageView) listItemView.findViewById(R.id.word_img);
            iView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
