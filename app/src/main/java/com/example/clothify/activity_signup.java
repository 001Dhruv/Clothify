package com.example.clothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button btn_signup=findViewById(R.id.btn_signup);
        TextView txt_login=findViewById(R.id.txt_login);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add in database
                Intent nxt=new Intent(getApplicationContext(),Home_Activity.class);
            }
        });txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add in database
                Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
            }
        });
    }
}