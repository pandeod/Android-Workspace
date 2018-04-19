package com.lightning.exp1_098;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Exam on 08-03-2018.
 */

public class Fragment2 extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Settings");
        // TODO Auto-generated method stub
        ViewGroup rootView =(ViewGroup) inflater.inflate(R.layout.fragment2,container, false);
        return rootView;

    }
}
