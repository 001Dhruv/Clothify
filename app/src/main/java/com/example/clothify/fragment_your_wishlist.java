package com.example.clothify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_your_wishlist extends Fragment {
    ArrayList<home_fragment_model> arr_wishlist_items=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_your_wishlist, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_your_wishlist_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ////DUMMY DATA
//
//
//
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
//        arr_wishlist_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));


        //////END OF DUMMY DATA

        home_fragment_recycler_adapter adapter=new home_fragment_recycler_adapter(getContext(),arr_wishlist_items,R.layout.cart_fragment_raw);
        recyclerView.setAdapter(adapter);
        return view;
    }
}