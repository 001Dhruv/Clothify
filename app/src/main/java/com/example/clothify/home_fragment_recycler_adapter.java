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
        String imageUrl = arrlist.get(position).img;
        Picasso.get().load(imageUrl).into(holder.img);
        holder.name.setText(arrlist.get(position).name);
        holder.desc.setText(arrlist.get(position).desc);
        holder.price.setText(arrlist.get(position).price);
        holder.type.setText(arrlist.get(position).type);
        holder.gender.setText(arrlist.get(position).gender);
        System.out.println("TextView binded...");
        holder.btn_add_to_cart.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                ButtonClickHandler.addToCart("?p_id="+arrlist.get(position).p_id, context);
            }
        });
        holder.btn_desc.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                ButtonClickHandler.desc(arrlist.get(position).p_id,context);
            }
        });
        System.out.println("Binding complete..");
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
        TextView type;
        TextView gender;
        Button btn_desc;
        Button btn_add_to_cart;

        public ViewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.product_name);
            desc=view.findViewById(R.id.product_desc);
            price=view.findViewById(R.id.product_price);
            img=view.findViewById(R.id.product_img);
            type=view.findViewById(R.id.product_type);
            gender=view.findViewById(R.id.product_gender);
            btn_add_to_cart=view.findViewById(R.id.btn_add_to_cart);
            btn_desc=view.findViewById(R.id.btn_desc);
        }
    }
}
