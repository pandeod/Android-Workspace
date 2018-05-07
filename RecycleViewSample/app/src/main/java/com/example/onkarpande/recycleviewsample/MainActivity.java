package com.example.onkarpande.recycleviewsample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    DatabaseHelper myDb;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ItemList> itemLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myDb=new DatabaseHelper(this);
//         boolean a=myDb.insertData("1234","CSTM TO BDR");
//        boolean b= myDb.insertData("1654","CSTM TO BDR");
//
//        final String result=myDb.getAllData();
//
//        Button bt=findViewById(R.id.button);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextView hello=findViewById(R.id.hello);
//                if(result=="")
//                {
//                    Toast.makeText(getApplicationContext(),"moving",Toast.LENGTH_SHORT).show();
//                }
//                hello.setText(result);
//            }
//        });

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor= contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,ContactsContract.Contacts.DISPLAY_NAME+" ASC ");


        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemLists=new ArrayList<>();

        while(cursor.moveToNext())
        {
            String id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            String ifHasPhone=cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.HAS_PHONE_NUMBER));
            //Toast.makeText(this,ifHasPhone,Toast.LENGTH_SHORT).show();
            if(ifHasPhone.equalsIgnoreCase("1"))
            {
                ItemList itemList=new ItemList(id,name);
                itemLists.add(itemList);
            }
        }

        adapter=new MyAdapter(itemLists,this);
        recyclerView.setAdapter(adapter);
    }
}
