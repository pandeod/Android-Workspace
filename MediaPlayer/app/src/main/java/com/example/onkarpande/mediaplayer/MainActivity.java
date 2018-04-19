package com.example.onkarpande.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView b1=(TextView) findViewById(R.id.b1);
        final MediaPlayer song = MediaPlayer.create(this,R.raw.raabata);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(song.isPlaying())
                    song.pause();
                else
                    song.start();
            }
        });

        TextView b2=(TextView) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.pause();
            }
        });

    }
}
