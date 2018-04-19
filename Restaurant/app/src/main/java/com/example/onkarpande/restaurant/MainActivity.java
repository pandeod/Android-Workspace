package com.example.onkarpande.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView todayspecial=(TextView) findViewById(R.id.todayspecial);
        TextView menu=(TextView) findViewById(R.id.menu);
        TextView delightoffers=(TextView) findViewById(R.id.delightoffers);
        TextView letsorder=(TextView) findViewById(R.id.letsorder);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,menu.class);
                startActivity(i);
            }
        });
        todayspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,todayspecial.class);
                startActivity(i);
            }
        });
        delightoffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,delightoffers.class);
                startActivity(i);
            }
        });
        letsorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,letsoder.class);
                startActivity(i);
            }
        });
    }
}
