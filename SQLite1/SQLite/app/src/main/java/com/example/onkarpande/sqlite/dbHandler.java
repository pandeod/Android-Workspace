package com.example.onkarpande.sqlite;

/**
 * Created by Onkar Pande on 10/25/2017.
 */

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.Toast;

public class dbHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDB.db";
    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_ID = "Roll";
    public static final String COLUMN_NAME = "Name";

    public dbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_STUDENTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE " + TABLE_STUDENTS);
        onCreate(db);
    }

    public int addStudent(Students student)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, student.get_roll());
        values.put(COLUMN_NAME, student.get_studentname());
        SQLiteDatabase db = getWritableDatabase();
        int in = (int)db.insert(TABLE_STUDENTS, null, values);
        db.close();
        return in;
     }


    public String databaseToString(int i)
    {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query="";

        switch(i)
        {
            case 1 : query = "SELECT * FROM " + TABLE_STUDENTS + " WHERE 1";
                     break;
            case 2 : query = "SELECT * FROM "+ TABLE_STUDENTS + " ORDER BY "+ COLUMN_NAME +" ASC";
        }

        Cursor recordSet = db.rawQuery(query, null);

        recordSet.moveToFirst();

        while (!recordSet.isAfterLast()) {
            if (recordSet.getString(recordSet.getColumnIndex("Name")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("Name")) +"    "+ recordSet.getString(recordSet.getColumnIndex("Roll"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

     public int delete(Students student)
    {

        String query = "DELETE FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_ID +" = '" + student.get_roll() +"'";
        SQLiteDatabase db = getWritableDatabase();

        int flag = db.delete(TABLE_STUDENTS,COLUMN_ID +"= ? and "+COLUMN_NAME +"=?" , new String []{Integer.toString(student.get_roll()),student.get_studentname()});

        //db.execSQL(query);
        db.close();
        return flag;
    }
    public int deleteByID(Students student)
    {

        SQLiteDatabase db = getWritableDatabase();

        int flag = db.delete(TABLE_STUDENTS,COLUMN_ID +"= ?", new String []{Integer.toString(student.get_roll())});

        //db.execSQL(query);
        db.close();
        return flag;
    }
    public int deleteByName(Students student)
    {

        SQLiteDatabase db = getWritableDatabase();

        int flag = db.delete(TABLE_STUDENTS, COLUMN_NAME +"=?" , new String []{student.get_studentname()});

        db.close();
        return flag;
    }
}