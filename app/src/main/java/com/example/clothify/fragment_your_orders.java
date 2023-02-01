package com.example.clothify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class fragment_your_orders extends Fragment {
    ArrayList<home_fragment_model> arr_your_orders=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_your_orders, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_your_orders_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ////DUMMY DATA



        arr_your_orders.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","Arriving Monday by 9PM"));
        arr_your_orders.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","Delivered 12th oct, 2020"));
        arr_your_orders.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","Delivered 11th oct, 2020"));
        arr_your_orders.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","Delivered 9th oct, 2020"));
        arr_your_orders.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","Delivered 4th oct, 2020"));
        arr_your_orders.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","Delivered 2th oct, 2020"));


        //////END OF DUMMY DATA

        home_fragment_recycler_adapter adapter=new home_fragment_recycler_adapter(getContext(),arr_your_orders,R.layout.cart_fragment_raw);
        recyclerView.setAdapter(adapter);
        return view;
    }
}