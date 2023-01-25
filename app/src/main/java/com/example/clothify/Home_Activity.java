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

public class Home_Activity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    View nav_header;
    TextView email;
    TextView username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navbar);
        toolbar = findViewById(R.id.toolbar);
        System.out.println(toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle("Clothify");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new fragment_home_activity());
        nav_header=navigationView.getHeaderView(0);
        email=(TextView)nav_header.findViewById(R.id.navbar_header_email);
        username=(TextView)nav_header.findViewById(R.id.navbar_header_username);
        SharedPreferences s2 = getSharedPreferences("S1",MODE_PRIVATE);
        username.setText(s2.getString("FIRSTNAME","")+" "+s2.getString("LASTNAME",""));


        email.setText(s2.getString("EMAIL",""));
//        System.out.printf(s2.getString("EMAIL",""));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navbar_yourorders) {
                    loadFragment(new fragment_your_orders());
                } else if (id == R.id.navbar_yourwishlist) {
                    loadFragment(new fragment_your_wishlist());

                } else if (id == R.id.action_cart) {
                    loadFragment(new fragment_your_cart());
                } else if (id==R.id.navbar_home) {
                    loadFragment(new fragment_home_activity());
                }
                else if(id==R.id.action_logout){
                    SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                    SharedPreferences.Editor edt=pref.edit();
                    edt.putBoolean("loginflag",false);
                    edt.apply();
                    SharedPreferences sharedPreferences = getSharedPreferences("S1",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("FIRSTNAME");
                    editor.remove("LASTNAME");
                    editor.commit();
                    Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(nxt);
                    finishAffinity();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.commit();
    }
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (getFragmentManager().getBackStackEntryCount() != 0) {
            getFragmentManager().popBackStack();
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

        } else if (id == R.id.toolbar_notification) {
            loadFragment(new fragment_notification());
        } else if (id==R.id.action_cart) {
            loadFragment(new fragment_your_cart());
        }

        return super.onOptionsItemSelected(item);
    }
}

//        Button btn_logout=findViewById(R.id.btn_logout);
//        fn = findViewById(R.id.txt_fn);
//        ln = findViewById(R.id.txt_ln);

//        SharedPreferences s2 = getSharedPreferences("S1",MODE_PRIVATE);
//        fn.setText(s2.getString("FIRSTNAME",""));
//        ln.setText(s2.getString("LASTNAME",""));
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
//                SharedPreferences.Editor edt=pref.edit();
//                edt.putBoolean("loginflag",false);
//                edt.apply();
//                SharedPreferences sharedPreferences = getSharedPreferences("S1",MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.remove("FIRSTNAME");
//                editor.remove("LASTNAME");
//                editor.commit();
//                Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
//                startActivity(nxt);
//                finishAffinity();
//            }
//        });
