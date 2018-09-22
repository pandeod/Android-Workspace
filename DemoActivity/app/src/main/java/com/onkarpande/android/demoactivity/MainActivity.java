package com.onkarpande.android.demoactivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText ed;
    TextView tx;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate called", Toast.LENGTH_LONG).show();

        ed=findViewById(R.id.edit);
        bt=findViewById(R.id.save);
        tx=findViewById(R.id.show);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx.setText(ed.getText().toString());
            }
        });

        Button start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(),MyService.class));
            }
        });

        Button stop=findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(),MyService.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResumed called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart called", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Toast.makeText(getApplicationContext(), "Instance saved", Toast.LENGTH_SHORT).show();
//        outState.putString("value",tx.getText().toString());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Toast.makeText(getApplicationContext(), "Instance Restored", Toast.LENGTH_SHORT).show();
//        tx.setText(savedInstanceState.getString("value"));
//    }

    public void onclick(View v)
    {
//        Intent intent=new Intent(this,NextScreen.class);
//        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, NextScreen.class), 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker("Ticker.....")
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle("Notification title")
                .setContentText("Notification Content")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

    }
}
