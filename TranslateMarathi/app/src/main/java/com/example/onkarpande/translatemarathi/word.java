package com.example.onkarpande.translatemarathi;

import android.graphics.drawable.Drawable;
import android.provider.MediaStore;

/**
 * Created by Onkar Pande on 10/14/2017.
 */

public class word {
    private  String mText;
    private String eText;
    public Drawable draw;
    public int aFile;

    public word(String m, String e, Drawable d , int a)
    {
        mText=m;
        eText=e;
        draw=d;
        aFile=a;
    }
    public word(String m,String e,int a)
    {
        mText=m;
        eText=e;
        aFile=a;
    }
    public String getMarathi()
    {
        return this.mText;
    }
    public String getEnglish() {return this.eText;}
    public Drawable getImage(){ return this.draw;}
    public int getSound(){ return this.aFile; }
}
