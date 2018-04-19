package com.example.onkarpande.sqlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText insertName;
    EditText rollNo;
    TextView  recordsTextView;
    dbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertName = (EditText) findViewById(R.id.insertName);
        rollNo = (EditText) findViewById(R.id.insertRoll);

        recordsTextView = (TextView) findViewById(R.id.output);

        dbHandler = new dbHandler(this, null, null, 1);
    }

    public void printDatabase(View view){
        String dbString = dbHandler.databaseToString(1);
        recordsTextView.setText(dbString);
        insertName.setText("");
        rollNo.setText("");
    }

    public void sort(View view){
        String dbString = dbHandler.databaseToString(2);
        recordsTextView.setText(dbString);
        insertName.setText("");
        rollNo.setText("");
    }

    public void addButtonClicked(View view){

        String name=insertName.getText().toString();
        String roll=rollNo.getText().toString();
        Students student;
        if(!name.matches("") && !roll.matches(""))
        {
            student = new Students(name, Integer.valueOf(roll));
            if(dbHandler.addStudent(student)!=-1)
            {

                Toast t = Toast.makeText(getApplicationContext(), "Inserted Successfully" ,Toast.LENGTH_SHORT);
                t.show();

            }
        }
        else
        {
            //recordsTextView = (TextView) findViewById(R.id.output);
           //recordsTextView.setText("Enter some value !!!");
            Toast t = Toast.makeText(getApplicationContext(), "Enter Values" ,Toast.LENGTH_SHORT);
            t.show();
        }
    }
     public void deleteById(View view)
     {
         String roll =rollNo.getText().toString();
         String name = "";
         Students student;
         student = new Students(name, Integer.valueOf(roll));
         if(dbHandler.deleteByID(student)==1)
         {
             Toast t = Toast.makeText(getApplicationContext(),"Deleted Successfully" , Toast.LENGTH_SHORT);
             t.show();

         }
         else
         {
             Toast t = Toast.makeText(getApplicationContext(),"Failed Delete" , Toast.LENGTH_SHORT);
             t.show();
         }
     }

    public void deleteByName(View view)
    {
        String roll = "-1";
        String name = insertName.getText().toString();
        Students student;
        student = new Students(name, Integer.valueOf(roll));
        if(dbHandler.deleteByName(student)==1)
        {
            Toast t = Toast.makeText(getApplicationContext(),"Deleted Successfully" , Toast.LENGTH_SHORT);
            t.show();
        }
        else
        {
            Toast t = Toast.makeText(getApplicationContext(),"Failed Delete" , Toast.LENGTH_SHORT);
            t.show();

        }
    }

     public void deleteValues(View view)
    {

        String name=insertName.getText().toString();
        String roll=rollNo.getText().toString();
        Students student;
        if(!name.matches("") && !roll.matches(""))
        {
            student = new Students(name, Integer.valueOf(roll));
            if(dbHandler.delete(student)==1)
            {
                Toast t = Toast.makeText(getApplicationContext(),"Deleted Successfully" , Toast.LENGTH_SHORT);
                t.show();
            }
            else
            {
                Toast t = Toast.makeText(getApplicationContext(),"Failed Delete" , Toast.LENGTH_SHORT);
                t.show();

            }
        }
        else if(name.matches("") && !roll.matches(""))
        {
            deleteById(view);
        }
        else if(roll.matches("") && !name.matches(""))
        {
            deleteByName(view);
        }
        else
        {
            Toast t = Toast.makeText(getApplicationContext(),"Enter Values" , Toast.LENGTH_SHORT);
            t.show();
        }
    }
    /*public void sort(View view)
    {

    }*/

}
