package com.example.clothify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class bill_fragment_adapter extends RecyclerView.Adapter<bill_fragment_adapter.ViewHolder>{
    Context context;
    ArrayList<bill_fragment_model> arrlist;
    int raw_id;
    bill_fragment_adapter(Context context, ArrayList<bill_fragment_model> arrlist, int raw_id){
        this.context=context;
        this.arrlist=arrlist;
        this.raw_id=raw_id;
        System.out.println("Adapter Constructor called...");

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(raw_id,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        System.out.println("ViewHolder created");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(arrlist.get(position).type+" for "+arrlist.get(position).gender);
        holder.price.setText(arrlist.get(position).price);
        holder.qty.setText(arrlist.get(position).qty);
        holder.sr_no.setText(arrlist.get(position).sr_no);

        System.out.println("TextView binded...");
    }

    @Override
    public int getItemCount() {
        return arrlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView sr_no;
        TextView qty;

        public ViewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.bill_p_name);
            price=view.findViewById(R.id.bill_p_price);
            sr_no=view.findViewById(R.id.bill_sr_no);
            qty=view.findViewById(R.id.bill_p_qty);

        }
    }
}
