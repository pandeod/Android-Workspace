package com.example.android.miwok;

import android.graphics.drawable.Drawable;
import android.provider.MediaStore;

/**
 * Created by Onkar Pande on 9/16/2017.
 */

public class word {

    private  String mText;
    private String eText;
    public Drawable draw;

    public word(String m, String e, Drawable d)
    {
        mText=m;
        eText=e;
        draw=d;
    }
    public word(String m,String e)
    {
        mText=m;
        eText=e;
    }
    public String getMiwok()
    {
        return this.mText;
    }
    public String getEnglish() {return this.eText;}
    public Drawable getImage(){ return this.draw;}
}
