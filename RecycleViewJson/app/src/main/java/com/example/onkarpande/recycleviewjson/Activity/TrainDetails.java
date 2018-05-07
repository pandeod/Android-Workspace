package com.example.onkarpande.recycleviewjson.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.onkarpande.recycleviewjson.R;

public class TrainDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_details);

        String trainNo=getIntent().getExtras().getString("TrainNo");

        TextView td=findViewById(R.id.textDetails);
        td.setText(trainNo);
    }
}
