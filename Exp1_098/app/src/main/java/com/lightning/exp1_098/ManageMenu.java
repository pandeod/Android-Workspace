package com.lightning.exp1_098;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ManageMenu extends Activity {

    TextView op;
    TextView total;
    DatabaseHandler db;
    String log;
    EditText ed1;
    EditText ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_menu);

        db = new DatabaseHandler(this);

        ed1=findViewById(R.id.insertName);
        ed2=findViewById(R.id.insertPrice);
        op=findViewById(R.id.output);
        total=findViewById(R.id.total);
        Button insert=findViewById(R.id.insert);
        Button update=findViewById(R.id.update);
        Button delete=findViewById(R.id.delete);

        showOutput();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed1s=ed1.getText().toString();
                String ed2s=ed2.getText().toString();
                db.addMenu(new MenuItem(ed1s, ed2s));
                showOutput();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed1s=ed1.getText().toString();
                String ed2s=ed2.getText().toString();
                if(db.updateMenu(new MenuItem(ed1s, ed2s))!=0)
                 showOutput();
                else
                    Toast.makeText(getApplicationContext(),"Not updated",Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed1s=ed1.getText().toString();
                String ed2s=ed2.getText().toString();
                db.deleteMenu(new MenuItem(ed1s, ed2s));
                showOutput();
            }
        });

    }

    public void showOutput()
    {
        List<MenuItem> menuItems = db.getAllContacts();
        log="\n";
        for (MenuItem cn : menuItems) {
            log +="\t\t\t\t" + cn.getName() + "\t\t\t\t\tRs." +cn.getPrice()+"\n";
        }
        op.setText(log);
        total.setText("Total Menu Items : "+db.getMenuCount());
    }

}