package com.example.clothify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class activity_signup extends AppCompatActivity {

    EditText fn;
    EditText ln;
    EditText email;
    EditText password;
    EditText phone;
    EditText address;
    android.widget.Button btn;
    TextView txt_login;


    ProgressDialog progressDialog;
    private String url="http://172.20.10.4:8080/clothify_android_db/addUser";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fn = findViewById(R.id.edt_fn_signup);
        ln = findViewById(R.id.edt_ln_signup);
        email = findViewById(R.id.edt_email_signup);
        password = findViewById(R.id.edt_password_signup);
        phone = findViewById(R.id.edt_phone_signup);
        address=findViewById(R.id.edt_address_signup);

        btn = findViewById(R.id.btn_signup);

        txt_login=findViewById(R.id.txt_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFn = fn.getText().toString();
                String strLn = ln.getText().toString();
                String user_name=strFn+" "+strLn;
                String strEmail = email.getText().toString();
                String strPhone = phone.getText().toString();
                String strPassword = password.getText().toString();
                String straddress=address.getText().toString();
                String query="?user_id="+strEmail+"&user_name="+user_name+"&password="+strPassword+"&address="+straddress+"&contact="+strPhone;
                progressDialog = new ProgressDialog(activity_signup.this);
                progressDialog.setMessage("In Progress");
                progressDialog.show();

                System.out.println("Email : "+strEmail);
                System.out.println("PASSWORD : "+strPassword);
                class SignUP extends Insert{
                    protected void onPostExecute(String s) {
                        if(s.equals("User added successfully...")){
                                if(progressDialog.isShowing()){
                                    progressDialog.dismiss();
                                }
                                fn.setText("");
                                ln.setText("");
                                email.setText("");
                                password.setText("");
                                phone.setText("");
                                address.setText("");

                                SharedPreferences s1 = getSharedPreferences("S1",MODE_PRIVATE);
                                SharedPreferences.Editor editor = s1.edit();
                                editor.putString("USER_NAME",strFn+" "+strLn);
                                editor.putString("EMAIL",strEmail);
                                editor.commit();
                                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                                SharedPreferences.Editor edt=pref.edit();
                                edt.putBoolean("loginflag",true);
                                edt.apply();
                                Intent i = new Intent(activity_signup.this,Home_Activity.class);
                                startActivity(i);
                                Toast.makeText(activity_signup.this, s, Toast.LENGTH_SHORT).show();
                            }else{
                                if(progressDialog.isShowing()){
                                    progressDialog.dismiss();
                                }

                                Toast.makeText(activity_signup.this, "Error "+s, Toast.LENGTH_SHORT).show();
                            }
                        }

                }
                Insert ins=new SignUP();
                ins.execute(url+query);

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








//Fire Base Code



//package com.example.clothify;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class activity_signup extends AppCompatActivity {
//
//    EditText fn;
//    EditText ln;
//    EditText email;
//    EditText password;
//    EditText phone;
//    EditText address;
//    android.widget.Button btn;
//
//    FirebaseDatabase firebaseDatabase;
//
//    DatabaseReference databaseReference;
//
//    FirebaseAuth firebaseAuth;
//    ProgressDialog progressDialog;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        getSupportActionBar().hide();
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//        fn = findViewById(R.id.edt_fn_signup);
//        ln = findViewById(R.id.edt_ln_signup);
//        email = findViewById(R.id.edt_email_signup);
//        password = findViewById(R.id.edt_password_signup);
//        phone = findViewById(R.id.edt_phone_signup);
//        firebaseAuth = FirebaseAuth.getInstance();
//
//        btn = findViewById(R.id.btn_signup);
//
//        firebaseDatabase = FirebaseDatabase.getInstance("https://clothify-4666a-default-rtdb.firebaseio.com/");
//        databaseReference = firebaseDatabase.getReference("AuthUsers"); //users is table name
//
//        TextView txt_login=findViewById(R.id.txt_login);
//
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                String strFn = fn.getText().toString();
//                String strLn = ln.getText().toString();
//                String strEmail = email.getText().toString();
//                String strPhone = phone.getText().toString();
//                String strPassword = password.getText().toString();
//
//                progressDialog = new ProgressDialog(activity_signup.this);
//                progressDialog.setMessage("In Progress");
//                progressDialog.show();
//
//                System.out.println("Email : "+strEmail);
//                System.out.println("PASSWORD : "+strPassword);
//                firebaseAuth.createUserWithEmailAndPassword(strEmail,strPassword).addOnCompleteListener(activity_signup.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if(task.isSuccessful()){
//                            if(progressDialog.isShowing()){
//                                progressDialog.dismiss();
//                            }
//                            String userId = firebaseAuth.getUid();
//                            UserModel user = new UserModel();
//                            user.setUserId(userId);
//                            user.setEmail(strEmail);
//                            user.setFirstName(strFn);
//                            user.setLastName(strLn);
//                            user.setPassword(strPassword);
//                            user.setUserContactNumber(strPhone);
//
//                            databaseReference.child(userId).setValue(user);
//
//                            fn.setText("");
//                            ln.setText("");
//                            email.setText("");
//                            password.setText("");
//                            phone.setText("");
//
//                            SharedPreferences s1 = getSharedPreferences("S1",MODE_PRIVATE);
//                            SharedPreferences.Editor editor = s1.edit();
//                            editor.putString("FIRSTNAME",strFn);
//                            editor.putString("LASTNAME",strLn);
//                            editor.putString("EMAIL",strEmail);
//                            editor.commit();
//
//
//                            Intent i = new Intent(activity_signup.this,Home_Activity.class);
//                            startActivity(i);
//
//                        }else{
//                            if(progressDialog.isShowing()){
//                                progressDialog.dismiss();
//                            }
//
//
//                            Toast.makeText(activity_signup.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//                Toast.makeText(activity_signup.this, "User added Successfully!!!", Toast.LENGTH_SHORT).show();
//
//
//
//
//
//
//
//
//            }
//        });
//
//
//
//
//
//        txt_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Add in database
//                Intent nxt=new Intent(getApplicationContext(),LoginActivity.class);
//                startActivity(nxt);
//            }
//        });
//    }
//}