package com.lightning.exp1_098;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class letsoder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letsoder);

        EditText ed1=(EditText)findViewById(R.id.ed1);
        ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                   EditText ed=(EditText)v;
                    String uName=ed.getText().toString();
                    if(uName.trim().equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Name can not be empty",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        EditText ed2=(EditText)findViewById(R.id.ed2);
        ed2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    EditText ed=(EditText)v;
                    String uMobile=ed.getText().toString();
                    if(uMobile.trim().equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Mobile No. can not be empty",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        EditText ed7=(EditText)findViewById(R.id.ed7);
        ed7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    EditText ed=(EditText)v;
                    String uPin=ed.getText().toString();
                    if(uPin.trim().equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Pin Code can not be empty",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
