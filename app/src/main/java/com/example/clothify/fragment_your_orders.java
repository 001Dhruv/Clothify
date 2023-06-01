package com.example.clothify;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class fragment_your_orders extends Fragment {
    ArrayList<home_fragment_model> arr_your_orders=new ArrayList<>();
    private String url="http://172.20.10.4:8080/clothify_android_db/FetchData";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_your_orders, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_your_orders_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        class ShowData extends Insert{
            protected void onPostExecute(String data) {
                try {
                    JSONArray ja = new JSONArray(data);
                    if (ja.length() == 0) {
                        Toast.makeText(getContext(), "Nothing to see here", Toast.LENGTH_SHORT).show();
                    } else {
                        JSONObject jo = null;
                        System.out.println("Data received");
                        for (int i = 0; i < ja.length(); i++) {
                            jo = ja.getJSONObject(i);
                            String price = "₹" + Double.toString(jo.getDouble("p_price"));
                            arr_your_orders.add(new home_fragment_model(jo.getString("p_img"), jo.getString("p_name"), jo.getString("P_description"), price, jo.getString("p_type"), jo.getString("p_gender"), jo.getInt("p_id")));
                        }
                        System.out.println("JSON Array created successfully...");
                        Orders_Fragment_Adapter adapter = new Orders_Fragment_Adapter(getContext(), arr_your_orders, R.layout.orders_fragment_raw);
                        recyclerView.setAdapter(adapter);

                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("data:" + data);
                    Toast.makeText(getContext(), "Something went wrong... " + e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        }

        Insert ins=new ShowData();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("S1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("EMAIL", "");
        String query_req="?user_id="+email+"&type=orders";
        System.out.println(query_req);
        ins.execute(url+query_req);
        return view;
    }
}