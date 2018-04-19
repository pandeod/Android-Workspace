package com.example.onkarpande.myapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static int count=0;
    static int price=5;
    public static String body,emailText,w,c;
    public static String e;
    boolean a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(count);
        dis(calculatePrice(count));
        w=getString(R.string.no);
        c=getString(R.string.no);
    }

    public void unitIncre(View view)
    {
        count++;
        if(count<0)
            count=0;
            display(count);
        dis(calculatePrice(count));

    }
    public void unitDecre(View view)
    {
        count--;
        if(count<0)
            count=0;
        display(count);
        dis(calculatePrice(count));
    }

    public void check(View view)
    {
        CheckBox topping1 =(CheckBox) findViewById(R.id.checkbox1);
        CheckBox topping2 =(CheckBox) findViewById(R.id.checkbox2);

        a=topping1.isChecked();
        b=topping2.isChecked();

        if(a)
        {
            w=getString(R.string.yes);
            price=7;
            if(b)
            {  c=getString(R.string.yes);
                price=10; }
        }
        else if(b)
        {
            c=getString(R.string.yes);
            price=8;
        }
        else
            price=5;

        dis(calculatePrice(count));
    }

    private int calculatePrice(int count)
    {
       return count*price;
    }

    private String orderSummary()
    {
        return "\n"+getString(R.string.q)+":"+count+"\n"+getString(R.string.t)+": $"+calculatePrice(count);
    }

    private void body_text()
    {
        TextView priceTV =(TextView) findViewById(R.id.totalAmount);
        TextView costumerName=(TextView) findViewById(R.id.cName);
        CheckBox topping1 =(CheckBox) findViewById(R.id.checkbox1);
        CheckBox topping2 =(CheckBox) findViewById(R.id.checkbox2);

        body= getString(R.string.n)+": "+costumerName.getText().toString()+"\n"+getString(R.string.w_add)+": "+w+"\n"+getString(R.string.c_add)+":"+c+ orderSummary()+"\n"+getString(R.string.thanks)+"!";
        priceTV.setText(body);

     //   emailText=R.string.dear+costumerName.getText().toString()+" ,\n"+getString(R.string.your_order)+" \n\n"+"<html><table border='1'><tr><th>"+R.string.ele+"</th><th>"+R.string.y_n+"</th></tr><tr><td>"
     //             +R.string.w_add+"</td><td>"+w+"</td></tr><tr><td>"+R.string.c_add+"</td><td>"+c+"</td></tr></table></html>"+"\n\n"+ orderSummary()+"\n"+getString(R.string.thanks)+"!";

    }
    public void declare(View view)
    {
        body_text();
    }
    public void mail(View view)
    {
        TextView eC=(TextView) findViewById(R.id.eC);
        TextView costumerName=(TextView) findViewById(R.id.cName);

        e =eC.getText().toString();
        String subject=getString(R.string.your_order);
        String thanks=getString(R.string.thanks);
        String dear=getString(R.string.dear);
        String ele=getString(R.string.ele);
        String y_n=getString(R.string.y_n);
        String w_add=getString(R.string.w_add);
        String c_add=getString(R.string.c_add);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{e});
        intent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(new StringBuilder()
                .append("<p>"+dear+" "+costumerName.getText().toString()+"</p>")
                .append("<br><p>"+subject+"</p>")
                .append("<p>"+ele+"&nbsp;"+y_n+"</p><p>"+w_add+"&nbsp;"+w+"</p><p>"+c_add+"&nbsp;"+c+"</p>")
                .append("<br><p>"+orderSummary()+"</p>"+thanks+"!")
                .toString()));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private void dis(int num)
    {
        TextView priceTV =(TextView) findViewById(R.id.totalAmount);
        priceTV.setText("$"+num);
    }
    private void display(int number)
    {
        TextView quantityTV =(TextView) findViewById(R.id.unit);
        quantityTV.setText(""+ number);
    }
}
