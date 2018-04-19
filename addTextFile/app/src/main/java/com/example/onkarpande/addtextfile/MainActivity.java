package com.example.onkarpande.addtextfile;

import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.print.PrinterInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = getResources().openRawResource(R.raw.text);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String entireFile = "";
        try {
            while((line = br.readLine()) != null)
            { // <--------- place readLine() inside loop
                entireFile += (line + "\n"); // <---------- add each line to entireFile
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        TextView m = (TextView) findViewById(R.id.m);

        m.setText(entireFile); // <------- assign entireFile to TextView

    }
}
