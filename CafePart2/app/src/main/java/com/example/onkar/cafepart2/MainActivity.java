package com.example.onkar.cafepart2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<OrderItem> orderItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderItems=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            OrderItem od=new OrderItem("Table No "+i,"asd ad \n ada \n ada \n adad",1);
            orderItems.add(od);
        }

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter=new OrderAdapter(orderItems,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
