package com.lightning.exp1_098;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class todayspecial extends FragmentActivity {

    public static final int NUM_PAGES = 2;

    private ViewPager viewPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todayspecial);

        ViewPager viewPager =findViewById(R.id.pager);
        mPagerAdapter=new viewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);
    }
}
