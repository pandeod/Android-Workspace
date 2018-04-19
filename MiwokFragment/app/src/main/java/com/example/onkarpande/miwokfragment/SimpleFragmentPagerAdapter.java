package com.example.onkarpande.miwokfragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Onkar Pande on 2/16/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext=context;
    }

    @Override
    public Fragment getItem(int position) {

//        if(position==0)
//        {
//            return new numbers();
//        }
//        else
        {
            return new family();
        }
    }

    @Override
    public int getCount() {
        return 1;
    }
}
