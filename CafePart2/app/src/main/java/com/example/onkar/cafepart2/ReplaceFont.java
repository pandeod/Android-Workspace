package com.example.onkar.cafepart2;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

public class ReplaceFont {

    public static void replaceDefaultFont(Context context,String nameOfFontBeingReplaced,String nameOfFontAssets)
    {
        Typeface customFontTypeFace=Typeface.createFromAsset(context.getAssets(),nameOfFontAssets);
        replaceFont(nameOfFontBeingReplaced,customFontTypeFace);
    }

    private static void replaceFont(String nameOfFontBeingReplaced, Typeface customFontTypeFace) {
        try{
            Field myField=Typeface.class.getDeclaredField(nameOfFontBeingReplaced);
            myField.setAccessible(true);
            myField.set(null,customFontTypeFace);
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

}
