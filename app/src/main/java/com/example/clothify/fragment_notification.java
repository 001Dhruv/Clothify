package com.example.clothify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class fragment_notification extends Fragment {
    ArrayList<home_fragment_model> arr_notification=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_notification, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_notification_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ////DUMMY DATA



        arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));
        arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));
        arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));arr_notification.add(new home_fragment_model(R.drawable.login_top,"MORE THAN 40% DISCOUNT","Hoodies and Jackets for men as well as women." +
                "with 7 days replacement policy","Free😁"));

        //////END OF DUMMY DATA

        home_fragment_recycler_adapter adapter=new home_fragment_recycler_adapter(getContext(),arr_notification,R.layout.cart_fragment_raw);
        recyclerView.setAdapter(adapter);
        return view;
    }
}