package com.example.onkarpande.recycleviewsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static java.security.AccessController.getContext;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

 private List<ItemList> itemLists;
 private Context context;
 private int positionView=0;


    public MyAdapter(List<ItemList> itemList, Context context) {
        this.itemLists = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       ItemList itemList=itemLists.get(position);
       holder.uName.setText(itemList.getuName());
       holder.uID=itemList.getId();
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView uName;
        public String uID;

        public ViewHolder(View itemView) {
            super(itemView);
            uName=itemView.findViewById(R.id.u_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(view.getContext(),DetailCard.class);
                    intent.putExtra("id",uID);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
