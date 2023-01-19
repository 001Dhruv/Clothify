package com.example.clothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn_logout=findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor edt=pref.edit();
                edt.putBoolean("loginflag",false);
                edt.apply();
                Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(nxt);
                finishAffinity();
            }
        });
    }
}