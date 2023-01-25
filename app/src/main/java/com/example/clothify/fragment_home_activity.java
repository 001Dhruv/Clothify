package com.example.clothify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_home_activity extends Fragment {

    ArrayList<home_fragment_model> arr_home_items=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_activity, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_home_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ////DUMMY DATA



        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));
        arr_home_items.add(new home_fragment_model(R.drawable.login_top,"HOODIE MENS","Yello with white straps best quality","1$"));


        //////END OF DUMMY DATA

        home_fragment_recycler_adapter adapter=new home_fragment_recycler_adapter(getContext(),arr_home_items);
        recyclerView.setAdapter(adapter);
        return view;

    }
}