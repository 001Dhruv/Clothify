package com.example.clothify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class fragment_product_page extends Fragment {
    private String url="http://172.20.10.4:8080/clothify_android_db/HomePageData";
    TextView p_name;
    TextView p_desc;
    TextView p_type;
    TextView p_gender;
    TextView p_price;
    Button btn_add_to_cart;
    Button btn_add_to_wishlist;
    ImageView p_img;
    String p_id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_page, container, false);
        p_name = view.findViewById(R.id.p_name);
        p_desc = view.findViewById(R.id.p_desc);
        p_type = view.findViewById(R.id.p_type);
        p_gender = view.findViewById(R.id.p_gender);
        p_price = view.findViewById(R.id.p_price);
        btn_add_to_cart = view.findViewById(R.id.btn_add_to_cart);
        btn_add_to_wishlist = view.findViewById(R.id.btn_add_to_wishlist);
        p_img=view.findViewById(R.id.product_page_img);

        class ShowDesc extends Insert {
            protected void onPostExecute(String data) {
                try {
                    JSONArray ja = new JSONArray(data);
                    if (ja.length() > 0) {
                        JSONObject jo = ja.getJSONObject(0);
                        System.out.println("Data received successfully...");
                        p_name.setText(jo.getString("p_name"));
                        p_desc.setText(jo.getString("P_description"));
                        p_type.setText("Type: " + jo.getString("p_type"));
                        p_gender.setText("Made for: " + jo.getString("p_gender"));
                        p_price.setText("₹" + jo.getString("p_price"));
                        String imageUrl = jo.getString("p_img");
                        Picasso.get().load(imageUrl).into(p_img);
                        p_id=Integer.toString(jo.getInt("p_id"));
                    } else {
                        System.out.println("Empty response received from the server");
                        Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();

                }
            }

        }
        Insert ins = new ShowDesc();
        String query = "?p_id="+Integer.toString(P_idHolder.getP_id());
        ins.execute(url + query);
        btn_add_to_cart.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                ButtonClickHandler.addToCart("?p_id="+p_id, getContext());
            }
        }); btn_add_to_wishlist.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                ButtonClickHandler.addToWishList("?p_id="+p_id, getContext());
            }
        });
        //////END OF DUMMY DATA
        return view;
    }
}