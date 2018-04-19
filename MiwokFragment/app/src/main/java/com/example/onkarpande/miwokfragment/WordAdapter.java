package com.example.onkarpande.miwokfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Onkar Pande on 2/16/2018.
 */

public class WordAdapter extends ArrayAdapter<word> {

    private int colorId;
    public WordAdapter(@NonNull Context context, ArrayList<word>Word, int color) {
        super(context,0, color);
        this.colorId=color;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent)
    {
       View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.word_list, parent, false);
        }

        word currentWord =getItem(position);

        TextView mTextView = listItemView.findViewById(R.id.m_word);
        TextView eTextView = listItemView.findViewById(R.id.e_word);

        mTextView.setText(currentWord.getmText());
        eTextView.setText(currentWord.geteText());

        ImageView img = listItemView.findViewById(R.id.word_img);

        if(currentWord.hasImage())
        {
            img.setImageResource(currentWord.getImageId());
            img.setVisibility(View.VISIBLE);
        }
        else
        {
            img.setVisibility(View.GONE);
        }

        View listContainer = listItemView.findViewById(R.id.list_container);
        int backgroundColor = ContextCompat.getColor(getContext(),colorId);
        listContainer.setBackgroundColor(backgroundColor);
        return listItemView;
    }

}
