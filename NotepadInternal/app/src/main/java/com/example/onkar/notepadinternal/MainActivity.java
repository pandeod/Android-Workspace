package com.example.onkar.notepadinternal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);
        }



        final EditText ed1=findViewById(R.id.file_title);
        final EditText ed2=findViewById(R.id.file_text);
        final TextView td=findViewById(R.id.readMsg);

        td.setVisibility(View.GONE);

        Button btn1=findViewById(R.id.save);
        Button btn2=findViewById(R.id.read);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=ed1.getText().toString()+".txt";
                String text=ed2.getText().toString();
                if(title!=null)
                {
                    String fullpath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Notepad_App";
                    File file=new File(fullpath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    file=new File(fullpath,title);
                    try {
                        FileOutputStream fileOutputStream=new FileOutputStream(file);
                        fileOutputStream.write(text.getBytes());
                        fileOutputStream.close();
                        Toast.makeText(getApplicationContext(),title+" saved",Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"File Not Found",Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),title+" not saved ! ERROR",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please give Title..",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String msg;
                    String title=ed1.getText().toString()+".txt";
                    String fullpath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Notepad_App";
                    File file=new File(fullpath,title);

                    FileInputStream fileInputStream=new FileInputStream(file);
                    InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer=new StringBuffer();

                    while((msg=bufferedReader.readLine())!=null)
                    {
                        stringBuffer.append(msg+"\n");
                    }

                    td.setText(stringBuffer.toString());
                    td.setVisibility(View.VISIBLE);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case 1000:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "permission NOT granted", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
}
