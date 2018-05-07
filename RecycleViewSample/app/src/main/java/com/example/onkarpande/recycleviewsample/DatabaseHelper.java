package com.example.onkarpande.recycleviewsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="MyDB.db";
    public static final String TABLE_NAME="railinfo";
    public static final String COL_1="TrainNo";
    public static final String COL_2="TrainName";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String createTable="create table "+TABLE_NAME+" ( TrainNo INTEGER PRIMARY KEY ,TrainName TEXT )";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTable="drop table if exists "+TABLE_NAME ;
       sqLiteDatabase.execSQL(dropTable);
       onCreate(sqLiteDatabase);
    }

    public boolean insertData(String trainNo , String trainName)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,trainNo);
        contentValues.put(COL_2,trainName);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result!=-1)
           return true;
        else
           return  false;
    }

    public String getAllData()
    {
        String result="";
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+" ;",null);
        res.moveToFirst();
        while (!res.isAfterLast())
        {
         result+=res.getString(res.getColumnIndex(COL_1))+"\n"+res.getString(res.getColumnIndex(COL_2))+"\n";
         res.moveToNext();
        }
        sqLiteDatabase.close();
        return result;
    }
}
