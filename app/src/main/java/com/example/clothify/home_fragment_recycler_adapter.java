package com.example.clothify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

public class home_fragment_recycler_adapter extends RecyclerView.Adapter<home_fragment_recycler_adapter.ViewHolder>{
    Context context;
    ArrayList<home_fragment_model> arrlist;
    int raw_id;
    home_fragment_recycler_adapter(Context context, ArrayList<home_fragment_model> arrlist,int raw_id){
        this.context=context;
        this.arrlist=arrlist;
        this.raw_id=raw_id;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(raw_id,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(arrlist.get(position).img);
        holder.name.setText(arrlist.get(position).name);
        holder.desc.setText(arrlist.get(position).desc);
        holder.price.setText(arrlist.get(position).price);
    }

    @Override
    public int getItemCount() {
        return arrlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView desc;
        TextView price;
        ImageView img;

        public ViewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.product_name);
            desc=view.findViewById(R.id.product_desc);
            price=view.findViewById(R.id.product_price);
            img=view.findViewById(R.id.product_img);
        }
    }
}
