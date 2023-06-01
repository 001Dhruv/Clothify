package com.example.clothify;


import static android.content.Context.MODE_PRIVATE;

import android.content.*;
import android.preference.PreferenceManager;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ButtonClickHandler {
    public static void addToCart(String query,Context context){
        String url="http://172.20.10.4:8080/clothify_android_db/AddRequestHandler";
        SharedPreferences sharedPreferences = context.getSharedPreferences("S1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("EMAIL", "");
        String query_req=query+"&user_id="+email+"&type=cart";
        class AddToCart extends Insert {
            protected void onPostExecute(String data) {
                if (data.equals("Success")) {
                    System.out.println("Success");
                    Toast.makeText(context, "Product added to cart", Toast.LENGTH_SHORT).show();
                    Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
                    homeActivity.loadFragment(new fragment_your_cart());
                    homeActivity.set_title(R.id.action_cart);
                } else {
                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                    System.out.println(data);

                }
            }
        }
            Insert ins =new AddToCart();
            ins.execute(url+query_req);
    }
    public static void removeFromCart(String query,Context context){
        String url="http://172.20.10.4:8080/clothify_android_db/RemoveRequestHandler";
        SharedPreferences sharedPreferences = context.getSharedPreferences("S1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("EMAIL", "");
        String query_req=query+"&user_id="+email+"&type=cart";
        class RemoveFromCart extends Insert {
            protected void onPostExecute(String data) {
                if (data.equals("Success")) {
                    System.out.println("Success");
                    Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
                    homeActivity.loadFragment(new fragment_your_cart());
                    homeActivity.set_title(R.id.action_cart);
                    Toast.makeText(context, "Product Removed From cart", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                    System.out.println(data);

                }
            }
        }
        Insert ins =new RemoveFromCart();
        ins.execute(url+query_req);
    }
    public static void addToWishList(String query,Context context){
        String url="http://172.20.10.4:8080/clothify_android_db/AddRequestHandler";
        SharedPreferences sharedPreferences = context.getSharedPreferences("S1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("EMAIL", "");
        String query_req=query+"&user_id="+email+"&type=wishlist";
        class AddToWishlist extends Insert {
            protected void onPostExecute(String data) {
                if (data.equals("Success")) {
                    System.out.println("Success");
                    Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
                    homeActivity.loadFragment(new fragment_your_wishlist());
                    homeActivity.set_title(R.id.navbar_yourwishlist);
                    Toast.makeText(context, "Product added to Wishlist", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                    System.out.println(data);

                }
            }
        }
        Insert ins =new AddToWishlist();
        ins.execute(url+query_req);
    }
    public static void removeFromWishlist(String query,Context context){
        String url="http://172.20.10.4:8080/clothify_android_db/RemoveRequestHandler";
        SharedPreferences sharedPreferences = context.getSharedPreferences("S1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("EMAIL", "");
        String query_req=query+"&user_id="+email+"&type=wishlist";
        class RemoveFromWishlist extends Insert {
            protected void onPostExecute(String data) {
                if (data.equals("Success")) {
                    System.out.println("Success");
                    Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
                    homeActivity.loadFragment(new fragment_your_wishlist());
                    homeActivity.set_title(R.id.navbar_yourwishlist);
                    Toast.makeText(context, "Product Removed From Wishlist", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                    System.out.println(data);

                }
            }
        }
        Insert ins =new RemoveFromWishlist();
        ins.execute(url+query_req);
    }
    public static void desc(int p_id,Context context){
        Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
        P_idHolder.setP_id(p_id);
        homeActivity.loadFragment(new fragment_product_page());
        homeActivity.set_title(1);
    }
    public static void buyNow(Context context, ArrayList<bill_fragment_model> arr_cart_items){
        String url="http://172.20.10.4:8080/clothify_android_db/BuyNowHandler";
        SharedPreferences sharedPreferences = context.getSharedPreferences("S1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("EMAIL", "");
        String query_req="?user_id="+email;
        class BuyNow extends Insert {
            protected void onPostExecute(String data) {
                if (data.equals("Success")) {
                    System.out.println("Success");
                    Home_Activity homeActivity = HomeActivityInstance.getHomeActivity();
                    homeActivity.loadFragment(new fragment_buy_now(arr_cart_items));
                    homeActivity.set_title(2);
                    Toast.makeText(context, "Bill Generated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                    System.out.println(data);
                }
            }
        }
        Insert ins =new BuyNow();
        ins.execute(url+query_req);
    }
}
