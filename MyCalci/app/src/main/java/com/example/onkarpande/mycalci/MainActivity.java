package com.example.onkarpande.mycalci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static String exp=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

   public void display(View view)
    {
        TextView expression =(TextView) findViewById(R.id.ans);
        expression.setText(exp);
    }
    public void num_0(View view)
    {
      exp=exp+"0";
        display(view);
    }
    public void num_1(View view)
    {
        exp=exp+"1";
        display(view);
    }
    public void num_2(View view)
    {
        exp=exp+"2";
        display(view);
    }
    public void num_3(View view)
    {
        exp=exp+"3";
        display(view);
    }
    public void num_4(View view)
    {
        exp=exp+"4";
        display(view);
    }
    public void num_5(View view)
    {
        exp=exp+"5";
        display(view);
    }
    public void num_6(View view)
    {
        exp=exp+"6";
        display(view);
    }
    public void num_7(View view)
    {
        exp=exp+"7";
        display(view);
    }
    public void num_8(View view)
    {
        exp=exp+"8";
        display(view);
    }
    public void num_9(View view)
    {
        exp=exp+"9";
        display(view);
    }
    public void op_add(View view)
    {
        exp=exp+"+";
        display(view);
    }
    public void op_sub(View view)
    {
        exp=exp+"-";
        display(view);
    }
    public void op_mul(View view)
    {
        exp=exp+"X";
        display(view);
    }
    public void op_div(View view)
    {
        exp=exp+"/";
        display(view);
    }
    public void op_del(View view)
    {
        exp="0";
        display(view);
    }
    public void op_point(View view)
    {
        exp=exp+".";
        display(view);
    }
    public void equal(View view)
    {
        exp="0";
       display(view);

    }


    public void clear(View view)
    {
        exp="0";
        display(view);
    }
}
