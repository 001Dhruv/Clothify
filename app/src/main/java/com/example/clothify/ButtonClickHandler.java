package com.example.clothify;


import static android.content.Context.MODE_PRIVATE;

import android.content.*;
import android.preference.PreferenceManager;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;


public class ButtonClickHandler {
    public static void addToCart(String query,Context context){
        String url="http://172.20.10.4:8080/clothify_android_db/AddToCart";
        SharedPreferences sharedPreferences = context.getSharedPreferences("S1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("EMAIL", "");
        String query_req=query+"&user_id="+email;
        class AddToCart extends Insert {
            protected void onPostExecute(String data) {
                if (data.equals("Success")) {
                    System.out.println("Success");
                    Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
                    homeActivity.loadFragment(new fragment_your_cart());
                    homeActivity.set_title(R.id.action_cart);
                    Toast.makeText(context, "Product added to cart", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                    System.out.println(data);

                }
            }
        }
            Insert ins =new AddToCart();
            ins.execute(url+query_req);
    }

    public static void desc(int p_id,Context context){
        Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
        homeActivity.loadFragment(new fragment_product_page());
        homeActivity.set_title(1);
    }
}
