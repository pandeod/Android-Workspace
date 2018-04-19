package com.lightning.exp1_098;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static android.content.Intent.ACTION_VIEW;

/**
 * Created by Exam on 08-03-2018.
 */

public class Fragment1 extends android.support.v4.app.Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Todays Special");
        // TODO Auto-generated method stub
        ViewGroup rootView =(ViewGroup) inflater.inflate(R.layout.fragment1,container, false);

        ImageView im=rootView.findViewById(R.id.imageFood);

        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.zomato.com/ncr/patiala-shahi-soups-vikaspuri-new-delhi"));
                startActivity(i);
                return true;
            }
        });
        return rootView;
    }

}
