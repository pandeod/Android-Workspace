package com.example.onkarpande.samplefirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  FirebaseDatabase mFirebaseDatabase;
    private  DatabaseReference mRef;
    private  DatabaseReference mRef1;
    List<Subject> subLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseDatabase =FirebaseDatabase.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        mRef1=mFirebaseDatabase.getReference().child("menu").child("week1").child("Monday");
        subLists=new ArrayList<>();

        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
       mRef1.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               subLists.clear();
               for(DataSnapshot demo:dataSnapshot.getChildren())
               {
                   Subject sub=demo.getValue(Subject.class);
                   subLists.add(sub);
                   display();
               }
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });
    }

    public void display()
    {
        int length=subLists.size();
        String total="";
        for(int i=0;i<length;i++)
        {
            Subject s=subLists.get(i);
            total+="Breakfast "+s.getBreakfast()+"\n Lunch"+s.getLunch()+"\nSnacks "+s.getSnacks()+"\n Dinner "+s.getDinner();
        }

        TextView txt=findViewById(R.id.text);
        txt.setText(total);
    }
}
