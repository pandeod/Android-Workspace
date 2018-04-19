package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Onkar Pande on 9/16/2017.
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
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.word_list, parent, false);
        }
        final word currentWord = getItem(position);

        TextView mView =(TextView) listItemView.findViewById(R.id.num_list1);
        mView.setText(currentWord.getMiwok());
        int color= ContextCompat.getColor(getContext(),c);
        mView.setBackgroundColor(color);

        TextView eView =(TextView) listItemView.findViewById(R.id.num_list2);
        eView.setText(currentWord.getEnglish());
        eView.setBackgroundColor(color);

        if(currentWord.draw!=null) {
            ImageView iView = (ImageView) listItemView.findViewById(R.id.img);
            iView.setImageDrawable(currentWord.getImage());
            iView.setVisibility(View.VISIBLE);
            iView.setBackgroundColor(color);
        }
        else
        {
            ImageView iView = (ImageView) listItemView.findViewById(R.id.img);
            iView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
