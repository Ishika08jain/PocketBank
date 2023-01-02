package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.gcm.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.net.PasswordAuthentication;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;

public class LoginPage extends AppCompatActivity {
   EditText login_username, login_password;
   TextView signupRedirectText;
   Button login_button;
   FirebaseDatabase database;
   DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        login_button= findViewById(R.id.login_button);
        login_username = findViewById(R.id.login_username);
        login_password= findViewById(R.id.login_password);
        signupRedirectText= findViewById(R.id.signupRedirectText);







        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateusername() || !validatepassword()){

                }else{
                    checkuser();


                }
            }


        });
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, NewuserActivity.class);
                startActivity(intent);
            }
        });



    }
    public Boolean validateusername() {
        String val = login_username.getText().toString();
        if (val.isEmpty()) {
            login_username.setError("Username cannot be empty");
            return false;
        } else {
            login_username.setError(null);
            return true;
        }
    }
        public Boolean validatepassword(){

        String val = login_password.getText().toString();
        if(val.isEmpty()){
            login_password.setError("Username cannot be empty");
            return false;
        }
        else{
            login_password.setError(null);
            return true;
        }

    }
    public void checkuser(){
        String Userusername = login_username.getText().toString().trim();
        String Userpassword = login_password.getText().toString().trim();

         myRef = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = myRef.orderByChild("username").equalTo(Userusername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    login_username.setError(null);
                    String passwordFromDB  = snapshot.child(Userusername).child("password").getValue(String.class);
                        if(!Objects.equals(passwordFromDB, Userpassword)) {
                            login_username.setError(null);
                            Intent intent = new Intent(LoginPage.this, Payments.class);
                            startActivity(intent);
                        }

//                            String email=snapshot.child(Userusername).child("emailId").getValue(String.class);
//                            String name=snapshot.child(Userusername).child("fullName").getValue(String.class);
//                            String phone=snapshot.child(Userusername).child("phoneNumber").getValue(String.class);
//                            String uid=snapshot.child(Userusername).child("userid").getValue(String.class);
//
//                            Intent intent1=new Intent(getApplicationContext(),ProfilePage.class);
//                            intent1.putExtra("name",name);
//                            intent1.putExtra("emailID",email);
//                            intent1.putExtra("Phone no.",phone);
//                            intent1.putExtra("Userid",uid);
//                            startActivity(intent1);
//                            finish();


                        else{
                            login_password.setError("Invalid credentials");
                            login_password.requestFocus();
                        }
                }else{
                    login_username.setError("User does not exist");
                    login_username.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }







}



//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkDataEntered();
//            }
//
//            private void checkDataEntered() {
//                String N = editTextTextEmailAddress.getText().toString();
//                if (N.isEmpty()) {
//                    Toast t = Toast.makeText(LoginPage.this, "You must enter name to apply for loan!", Toast.LENGTH_LONG);
//                    t.show();
//
//                }
//                String Q = editTextTextPassword.getText().toString();
//                if (Q.isEmpty()) {
//                    editTextTextPassword.setError("quotation for loan  is required!");
//                }
//
//            }
//
//        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String username = editTextTextEmailAddress.getText().toString();
//                String password = editTextTextPassword.getText().toString();
//
//                if (username.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(LoginPage.this, "Username and password can't be empty", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                if(snapshot.hasChild(username)){
//                                    String getpassword = snapshot.child(username).child("Password").getValue(String.class);
//                                    if(getpassword.equals(password)){
//                                        Toast.makeText(LoginPage.this, "Successfully logged in", Toast.LENGTH_LONG).show();
//                                        startActivity(new Intent(LoginPage.this, Payments.class));
//
//                                    }
//                                    else{
//                                        Toast.makeText(LoginPage.this, "Wrong username", Toast.LENGTH_LONG).show();
//                                    }
//                                }
//                                else{
//
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });
//                }
//
//
//            }
//        });






