package com.example.onkarpande.practice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeImage(View view)
    {   String message="I am full now";
        ImageView cookie =(ImageView) findViewById(R.id.Cookie);
        TextView state = (TextView) findViewById(R.id.statement);
        state.setText(message);
        cookie.setImageResource(R.drawable.after_cookie);
    }
}
