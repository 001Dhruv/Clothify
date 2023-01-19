package com.example.clothify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_signup extends AppCompatActivity {

    EditText fn;
    EditText ln;
    EditText email;
    EditText password;
    EditText phone;

    Button btn;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fn = findViewById(R.id.edt_fn_signup);
        ln = findViewById(R.id.edt_ln_signup);
        email = findViewById(R.id.edt_email_signup);
        password = findViewById(R.id.edt_email_signup);
        phone = findViewById(R.id.edt_phone_signup);

        btn = findViewById(R.id.btn_signup);

        firebaseDatabase = FirebaseDatabase.getInstance("https://clothify-4666a-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("Users"); //users is table name

        TextView txt_login=findViewById(R.id.txt_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFn = fn.getText().toString();
                String strLn = ln.getText().toString();
                String strEmail = email.getText().toString();
                String strPhone = phone.getText().toString();
                String strPassword = password.getText().toString();

                String userId = databaseReference.push().getKey();  //unique key from DB

                UserModel user = new UserModel();
                user.setEmail(strEmail);
                user.setFirstName(strFn);
                user.setLastName(strLn);
                user.setUserPassword(strPassword);
                user.setUserContactNumber(strPhone);
                user.setUserId(userId);

                databaseReference.child(userId).setValue(user);

                fn.setText("");
                ln.setText("");
                email.setText("");
                password.setText("");
                phone.setText("");


            }
        });





        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add in database
                Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(nxt);
            }
        });
    }
}