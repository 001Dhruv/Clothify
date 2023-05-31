package com.example.clothify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class Home_Activity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    View nav_header;
    TextView email;
    TextView username;

    //Flag for not adding the home fragment to the stack

    Boolean flag=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navbar);
        toolbar = findViewById(R.id.toolbar);
        System.out.println(toolbar);
        setSupportActionBar(toolbar);
        HomeActivityInstance.setHomeActivity(this);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new fragment_home_activity());
        nav_header = navigationView.getHeaderView(0);
        email = (TextView) nav_header.findViewById(R.id.navbar_header_email);
        username = (TextView) nav_header.findViewById(R.id.navbar_header_username);
        SharedPreferences s2 = getSharedPreferences("S1", MODE_PRIVATE);
        username.setText(s2.getString("USER_NAME", ""));
        email.setText(s2.getString("EMAIL", ""));
//        System.out.printf(s2.getString("EMAIL",""));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navbar_yourorders) {
                    loadFragment(new fragment_your_orders());
                    set_title(id);
                } else if (id == R.id.navbar_yourwishlist) {
                    loadFragment(new fragment_your_wishlist());
                    set_title(id);

                } else if (id == R.id.action_cart) {
                    loadFragment(new fragment_your_cart());
                    set_title(id);
                } else if (id == R.id.navbar_home) {
                    loadFragment(new fragment_home_activity());
                    set_title(id);
                } else if (id == R.id.action_logout) {
                    SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor edt = pref.edit();
                    edt.putBoolean("loginflag", false);
                    edt.apply();
                    SharedPreferences sharedPreferences = getSharedPreferences("S1", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("USER_NAME");
                    editor.remove("EMAIL");
                    editor.commit();
                    Intent nxt = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(nxt);
                    finishAffinity();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        if(flag) {
            //solves problem of onBackPressed for Fragment
            //Add the fragment to Stack
            flag=false;
            getSupportActionBar().setTitle("Clothify");
            fm.beginTransaction().replace(R.id.container, fragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
        }

    }
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
            set_title(getVisibleFragment().getId());
        }
        else{
            super.onBackPressed();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.toolbar_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.navbar_home) {
            loadFragment(new fragment_home_activity());
            set_title(id);
        } else if (id == R.id.toolbar_notification) {
            loadFragment(new fragment_notification());
            set_title(id);
        } else if (id==R.id.action_cart) {
            loadFragment(new fragment_your_cart());
            set_title(id);
        }
        return super.onOptionsItemSelected(item);
    }
//    public void set_title(Fragment visible_fragment){
//        int id= visible_fragment.getId();
//        if(id==new fragment_your_cart().getId()){
//            getSupportActionBar().setTitle("Your Cart");
//        }
//        else if(id==new fragment_your_wishlist().getId()){
//            getSupportActionBar().setTitle("Your Wishlist");
//        }
//        else if(id==new fragment_your_orders().getId()){
//            getSupportActionBar().setTitle("Your Orders");
//        }
//        else if(id==new fragment_notification().getId()){
//            getSupportActionBar().setTitle("Notifications");
//        }
//        else if(id==new fragment_home_activity().getId()){
//            getSupportActionBar().setTitle("Clothify");
//        }
//    }
    public void set_title(int id){
        if(id==R.id.action_cart){
            getSupportActionBar().setTitle("Your Cart");
        }
        else if(id==R.id.navbar_yourwishlist){
            getSupportActionBar().setTitle("Your Wishlist");
        }
        else if(id==R.id.navbar_yourorders){
            getSupportActionBar().setTitle("Your Orders");
        }
        else if(id==R.id.toolbar_notification){
            getSupportActionBar().setTitle("Notifications");
        }
        else if(id==R.id.navbar_home){
            getSupportActionBar().setTitle("Clothify");
        } else if (id==1) {
            getSupportActionBar().setTitle("Description");
        }
    }
    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null){
            for(Fragment fragment : fragments){
                if(fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }
}
