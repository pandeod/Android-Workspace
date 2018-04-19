package com.example.onkarpande.miwokfragment;

/**
 * Created by Onkar Pande on 2/16/2018.
 */

public class word {

    private String mText;
    private String eText;
    private int imageId= NO_IMAGE_PROVIDED;
    private int audioId;

    private static final int NO_IMAGE_PROVIDED=-1;

    public word(String mText,String eText,int imageId,int audioId)
    {
         this.eText=eText;
         this.mText=mText;
         this.audioId=audioId;
         this.imageId=imageId;
    }

    public word(String mText,String eText,int audioId)
    {
        this.eText=eText;
        this.mText=mText;
        this.audioId=audioId;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String geteText() {
        return eText;
    }

    public void seteText(String eText) {
        this.eText = eText;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public boolean hasImage()
    {
        return imageId !=NO_IMAGE_PROVIDED;
    }
}
