package com.example.clothify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText edt_email,edt_password;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    //ArrayList<UserModel> arrayList ;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email = findViewById(R.id.edt_email_login);
        edt_password = findViewById(R.id.edt_password_login);

        Button btnLogin = findViewById(R.id.btn_login);
        TextView txtSignup = findViewById(R.id.txt_signup);

        firebaseDatabase = FirebaseDatabase.getInstance("https://clothify-4666a-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference("AuthUsers"); //users is table name

        firebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate user

                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loging You in...");
                progressDialog.show();

                String userEmail = edt_email.getText().toString();
                String userPassword = edt_password.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        System.out.println("Email : "+userEmail);
                        System.out.println("Password : "+userPassword);
                        if(task.isSuccessful()){
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            String uid = firebaseAuth.getUid();

                            databaseReference.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                    UserModel userModel = snapshot.getValue(UserModel.class);
                                    String fname = userModel.getFirstName();
                                    String lname = userModel.getLastName();

                                    SharedPreferences s1 = getSharedPreferences("S1",MODE_PRIVATE);
                                    SharedPreferences.Editor editor = s1.edit();
                                    editor.putString("FIRSTNAME",fname);
                                    editor.putString("LASTNAME",lname);
                                    editor.commit();

                                    Intent i = new Intent(LoginActivity.this,Home_Activity.class);
                                    startActivity(i);




                                    finish();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error ) {

                                }
                            });
                        }else{
                            Toast.makeText(LoginActivity.this, "Invalid Credentials!!!", Toast.LENGTH_SHORT).show();
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                        }
                    }
                });



                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor edt=pref.edit();
                edt.putBoolean("loginflag",true);
                edt.apply();
//                Intent nxt=new Intent(getApplicationContext(),Home_Activity.class);
//                startActivity(nxt);
            }
        });
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(getApplicationContext(),activity_signup.class);
                startActivity(nxt);
            }
        });
    }
}