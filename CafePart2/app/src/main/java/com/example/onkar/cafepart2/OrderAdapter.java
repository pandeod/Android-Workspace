package com.example.onkar.cafepart2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private List<OrderItem> orderItems=new ArrayList<>();
    private Context context;

    public OrderAdapter() {
    }

    public OrderAdapter(List<OrderItem> orderItems, Context context) {
        this.orderItems = orderItems;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderAdapter.ViewHolder holder, final int position) {
        final OrderItem orderItem=orderItems.get(position);

        holder.tableNo.setText(orderItem.getTableNo());
        holder.orderItm.setText(orderItem.getOrder());
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundWorker backgroundWorker=new BackgroundWorker(context);
                backgroundWorker.execute("deleteOrder",orderItem.getId());
                holder.given.setBackgroundColor(context.getResources().getColor(R.color.green));
            }
        });
        holder.preprocess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.given.setBackgroundColor(context.getResources().getColor(R.color.yellow));
            }
        });
        holder.cancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.given.setBackgroundColor(context.getResources().getColor(R.color.red));
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tableNo;
        TextView orderItm;
        ImageButton remove;
        ImageButton preprocess;
        ImageButton cancelled;
        View given;
        public ViewHolder(View itemView) {
            super(itemView);
            tableNo=itemView.findViewById(R.id.table_no);
            orderItm=itemView.findViewById(R.id.order_items);
            remove=itemView.findViewById(R.id.remove_btn);
            preprocess=itemView.findViewById(R.id.processing_btn);
            cancelled=itemView.findViewById(R.id.cancel_btn);
            given=itemView;
        }
    }
}
