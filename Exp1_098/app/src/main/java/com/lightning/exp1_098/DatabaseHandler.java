package com.lightning.exp1_098;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MenuItem.db";
    private static final String TABLE_MENU = "menu";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MENU_TABLE = "CREATE TABLE " + TABLE_MENU + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT NOT NULL UNIQUE,"
                + KEY_PRICE + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_MENU_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        // Create tables again
        onCreate(db);
    }

    // code to add the new menuItem
    public void addMenu(MenuItem menuItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, menuItem.getName()); // MenuItem Name
        values.put(KEY_PRICE, menuItem.getPrice()); // MenuItem Price

        // Inserting Row
        long result=db.insert(TABLE_MENU, null, values);

        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get all contacts in a list view
    public List<MenuItem> getAllContacts() {
        List<MenuItem> menuItemList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MENU;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MenuItem menuItem = new MenuItem();
                menuItem.setName(cursor.getString(1));
                menuItem.setPrice(cursor.getString(2));
                // Adding menuItem to list
                menuItemList.add(menuItem);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return contact list
        return menuItemList;
    }

    // code to update the single menuItem
    public int updateMenu(MenuItem menuItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRICE, menuItem.getPrice());

        // updating row
        return db.update(TABLE_MENU, values, KEY_NAME + " = ?",
                new String[] { String.valueOf(menuItem.getName()) });
    }

    // Deleting single menuItem
    public void deleteMenu(MenuItem menuItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MENU, KEY_NAME + " = ?",
                new String[] { String.valueOf(menuItem.getName()) });
        db.close();
    }

    // Getting menu Count
    public int getMenuCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MENU;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        // return count
        return cursor.getCount();
    }

}