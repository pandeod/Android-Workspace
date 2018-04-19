package com.lightning.exp1_098;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Exam on 08-03-2018.
 */

public class viewPagerAdapter extends FragmentStatePagerAdapter {
    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
            return new Fragment1();
        }
        else

        return new Fragment2();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
