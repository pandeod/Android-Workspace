package com.lightning.exp1_098;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView im=(ImageView)findViewById(R.id.menutitle);
        im.setVisibility(View.GONE);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        ImageView im=(ImageView)findViewById(R.id.menutitle);
        TextView tx=(TextView) findViewById(R.id.textView);
        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                //Toast.makeText(this,"Touch down",Toast.LENGTH_SHORT).show();
                im.setVisibility(View.VISIBLE);
                tx.setVisibility(View.GONE);
                break;
            case MotionEvent.ACTION_UP:
                //Toast.makeText(this,".........Touch UP.............",Toast.LENGTH_SHORT).show();
                tx.setVisibility(View.VISIBLE);
                im.setVisibility(View.GONE);
                break;
        }
        return super.onTouchEvent(event);
    }
}

