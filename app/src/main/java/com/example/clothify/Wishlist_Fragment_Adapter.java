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

public class Wishlist_Fragment_Adapter extends RecyclerView.Adapter<Wishlist_Fragment_Adapter.ViewHolder>{
    Context context;
    ArrayList<home_fragment_model> arrlist;
    int raw_id;
    Wishlist_Fragment_Adapter(Context context, ArrayList<home_fragment_model> arrlist, int raw_id){
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
        System.out.println("Wishlist ViewHolder created");
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
        System.out.println("Wishlist TextView binded...");
        holder.btn_remove_wishlist.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                ButtonClickHandler.removeFromWishlist("?p_id="+arrlist.get(position).p_id, context);
            }
        });
        holder.btn_desc_wishlist.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                ButtonClickHandler.desc(arrlist.get(position).p_id,context);
            }
        });
        System.out.println("Wishlist Binding complete..");
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
        Button btn_desc_wishlist;
        Button btn_remove_wishlist;

        public ViewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.product_name);
            desc=view.findViewById(R.id.product_desc);
            price=view.findViewById(R.id.product_price);
            img=view.findViewById(R.id.product_img);
            type=view.findViewById(R.id.product_type);
            gender=view.findViewById(R.id.product_gender);
            btn_desc_wishlist=view.findViewById(R.id.btn_desc_wishlist);
            btn_remove_wishlist=view.findViewById(R.id.btn_remove_wishlist);
        }
    }
}
