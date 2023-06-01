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
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class fragment_your_cart extends Fragment {
    ArrayList<home_fragment_model> arr_cart_items=new ArrayList<>();
    ArrayList<bill_fragment_model> arr_bill_items=new ArrayList<>();
    private String url="http://172.20.10.4:8080/clothify_android_db/FetchData";
    Button btn_buy_now;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_your_cart, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_your_cart_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        btn_buy_now=view.findViewById(R.id.btn_buy_now);
        class ShowData extends Insert{
            double total=0;
            protected void onPostExecute(String data) {
                try {
                    JSONArray ja = new JSONArray(data);
                    if (ja.length() == 0) {
                        Toast.makeText(getContext(), "Your Cart is Empty", Toast.LENGTH_SHORT).show();
                    } else {
                        JSONObject jo = null;
                        System.out.println("Data received");
                        for (int i = 0; i < ja.length(); i++) {
                            jo = ja.getJSONObject(i);
                            String price = "₹" + Double.toString(jo.getDouble("p_price"));
                            total+=jo.getDouble("p_price");
                            arr_cart_items.add(new home_fragment_model(jo.getString("p_img"), jo.getString("p_name"), jo.getString("P_description"), price, jo.getString("p_type"), jo.getString("p_gender"), jo.getInt("p_id")));
                            arr_bill_items.add(new bill_fragment_model(jo.getString("p_img"), jo.getString("p_name"), jo.getString("P_description"), price, jo.getString("p_type"), jo.getString("p_gender"), jo.getInt("p_id"),Integer.toString(i+1),Integer.toString(1)));

                        }
                        arr_bill_items.add(new bill_fragment_model("-", "-","-","₹" + Double.toString(total),"Total ","",0,"-","-"));

                        System.out.println("JSON Array created successfully...");
                        Cart_Fragment_Adapter adapter = new Cart_Fragment_Adapter(getContext(), arr_cart_items, R.layout.cart_fragment_raw);
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
        String query_req="?user_id="+email+"&type=cart";
        System.out.println(query_req);
        ins.execute(url+query_req);
        btn_buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickHandler.buyNow(getContext(),arr_bill_items);
            }
        });
        return view;
    }
}