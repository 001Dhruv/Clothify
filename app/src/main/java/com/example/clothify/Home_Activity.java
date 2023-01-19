package com.example.clothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {

    TextView fn;
    TextView ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn_logout=findViewById(R.id.btn_logout);
        fn = findViewById(R.id.txt_fn);
        ln = findViewById(R.id.txt_ln);

        SharedPreferences s2 = getSharedPreferences("S1",MODE_PRIVATE);
        fn.setText(s2.getString("FIRSTNAME",""));
        ln.setText(s2.getString("LASTNAME",""));
        btn_logout.setOnClickListener(new View.OnClickListener() {
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
                editor.commit();
                Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(nxt);
                finishAffinity();
            }
        });
    }
}