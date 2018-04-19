package com.example.onkarpande.basketballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static int scA=0,scB=0;

    public void disA(int scA)
    {
        TextView pointsA = (TextView) findViewById(R.id.teamApt);
        pointsA.setText(""+scA);
    }
    public void disB(int scB)
    {
        TextView pointsB = (TextView) findViewById(R.id.teamBpt);
        pointsB.setText(""+scB);
    }

    public void Apt3(View view)
    {
        scA=scA+3;
        disA(scA);
    }
    public void Apt2(View view)
    {
        scA=scA+2;
        disA(scA);
    }
    public void Apt1(View view)
    {
        scA=scA+1;
        disA(scA);
    }
    public void Bpt3(View view)
    {
        scB=scB+3;
        disB(scB);
    }
    public void Bpt2(View view)
    {
        scB=scB+2;
        disB(scB);
    }
    public void Bpt1(View view)
    {
        scB=scB+1;
        disB(scB);
    }
    public void reset(View view)
    {
        scA=0;
        scB=0;
        disA(scA);
        disB(scB);
    }


}
