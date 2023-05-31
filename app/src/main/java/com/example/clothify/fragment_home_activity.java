package com.example.clothify;

import android.content.Intent;
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

public class fragment_home_activity extends Fragment {

    ArrayList<home_fragment_model> arr_home_items=new ArrayList<>();
    private String url="http://172.20.10.4:8080/clothify_android_db/HomePageData";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_activity, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_home_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ////ADDING DATA TO ARRAYLIST
        class ShowData extends Insert{
            protected void onPostExecute(String data) {
                try{
                    JSONArray ja=new JSONArray(data);
                    JSONObject jo=null;
                    System.out.println("Data received");
                    for(int i=0;i<ja.length();i++){
                        jo=ja.getJSONObject(i);
                        String price=Double.toString(jo.getDouble("p_price"));
                        arr_home_items.add(new home_fragment_model(jo.getString("p_img"),jo.getString("p_name"),jo.getString("P_description"),price,jo.getString("p_type"),jo.getString("p_gender"),jo.getInt("p_id")));
                    }
                    System.out.println("JSON Array created successfully...");
                    home_fragment_recycler_adapter adapter = new home_fragment_recycler_adapter(getContext(), arr_home_items, R.layout.home_fragment_raw);
                    recyclerView.setAdapter(adapter);

                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                    Toast.makeText(getContext(), "Something went wrong... ", Toast.LENGTH_SHORT).show();

                }
            }

        }
        Insert ins=new ShowData();
        ins.execute(url);

        //////END OF DUMMY DATA
        return view;

    }
}