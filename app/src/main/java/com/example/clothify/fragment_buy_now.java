package com.example.clothify;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class fragment_buy_now extends Fragment {
    ArrayList<bill_fragment_model> arr_bill_items;
    Button btn_go_to_home;

    fragment_buy_now(ArrayList<bill_fragment_model> arr_bill_items) {
        this.arr_bill_items = arr_bill_items;
    }

    private String url = "http://172.20.10.4:8080/clothify_android_db/FetchData";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_now, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_bill);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        bill_fragment_adapter adapter = new bill_fragment_adapter(getContext(), arr_bill_items, R.layout.buy_now_fragment_raw);
        recyclerView.setAdapter(adapter);
        btn_go_to_home=view.findViewById(R.id.btn_go_to_home);
        btn_go_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
                homeActivity.loadFragment(new fragment_home_activity());
                homeActivity.set_title(R.id.navbar_home);
            }
        });
        return view;
    }
}