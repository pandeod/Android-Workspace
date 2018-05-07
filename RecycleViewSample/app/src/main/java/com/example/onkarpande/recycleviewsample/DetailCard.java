package com.example.onkarpande.recycleviewsample;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailCard extends AppCompatActivity {

    String contact_name = "";
    String contact_no = "";
    String contact_mail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);

        TextView c_no = findViewById(R.id.contact_no);
        TextView c_name = findViewById(R.id.contact_name);
        TextView c_email = findViewById(R.id.contact_email);

        Intent result = getIntent();

        String contact_id = result.getExtras().getString("id");

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{contact_id}, null);

        while (cursor.moveToNext()) {
            contact_name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            Cursor phoneCursor = contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{contact_id}, null);

            while (phoneCursor.moveToNext()) {
                contact_no = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)) + "\n";
            }

        }

        c_name.setText(contact_name);
        c_no.setText(contact_no);
    }
}
