package com.example.clothify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.clothify.databinding.ActivityHomeBinding;

public class Home_Activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    TextView navbar_username;
    TextView navbar_email;

    TextView action_logout;
private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHome.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        SharedPreferences s2 = getSharedPreferences("S1",MODE_PRIVATE);

        action_logout=findViewById(R.id.action_logout);
        navbar_email=findViewById(R.id.navbar_email);
        navbar_username=findViewById(R.id.navbar_username);

        navbar_username.setText(s2.getString("FIRSTNAME","")+" "+s2.getString("LASTNAME",""));
        navbar_email.setText(s2.getString("EMAIL",""));
        action_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor edt=pref.edit();
                edt.putBoolean("loginflag",false);
                edt.apply();
                SharedPreferences sharedPreferences = getSharedPreferences("S1",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("FIRSTNAME");
                editor.remove("LASTNAME");
                editor.remove("EMAIL");
                editor.commit();
                Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(nxt);
                finishAffinity();
            }
        });
        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
//    TODO:
//    FUNCTINALITY OF ACTION BAR
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_search){
//            TODO:
//                code for searching for the result
            return false;
        }
        else if(id==R.id.action_notification){
//            TODO
//                code for passing user to the notification activity
            return false;
        }
        else if(id==R.id.action_cart){
//            TODO
//                Navigate the user to cart
            return false;
        }
        return false;
    }
//    TODO:
//    FUNCTION FOR FUNCTIONALLITY OF NAVBAR
    public boolean onNavigationItemSelected(MenuItem item){
        int id= item.getItemId();
        if(id==R.id.navbar_yourorders){

        }
        else if(id==R.id.navbar_yourwishlist){

        }
        else if(id==R.id.action_cart){

        }
        return true;
    }
}