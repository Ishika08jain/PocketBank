package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
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
    Button button2;
    TextView linkTextView;
    EditText editTextTextEmailAddress, editTextTextPassword;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button2 = findViewById(R.id.button2);
        linkTextView = findViewById(R.id.textView);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateusername() | !validatepassword()){

                }else{
                    checkuser();


                }
            }


        });
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, NewuserActivity.class);
                startActivity(intent);
            }
        });



    }
    public Boolean validateusername() {
        String val = editTextTextEmailAddress.getText().toString();
        if (val.isEmpty()) {
            editTextTextEmailAddress.setError("Username cannot be empty");
            return false;
        } else {
            editTextTextEmailAddress.setError(null);
            return true;
        }
    }
        public Boolean validatepassword(){

        String val = editTextTextPassword.getText().toString();
        if(val.isEmpty()){
            editTextTextPassword.setError("Username cannot be empty");
            return false;
        }
        else{
            editTextTextPassword.setError(null);
            return true;
        }

    }
    public void checkuser(){
        String Userusername = editTextTextEmailAddress.getText().toString().trim();
        String Userpassword = editTextTextPassword.getText().toString().trim();

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = myRef.orderByChild("userid").equalTo(Userusername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    editTextTextEmailAddress.setError(null);
                    String passwordFromDB  = snapshot.child(Userusername).child("Password").getValue(String.class);
                        if(!Objects.equals(passwordFromDB, Userpassword)){
                            editTextTextEmailAddress.setError(null);
                            Intent intent= new Intent(LoginPage.this, Payments.class);
                            startActivity(intent);

                            String email=snapshot.child(Userusername).child("emailId").getValue(String.class);
                            String name=snapshot.child(Userusername).child("fullName").getValue(String.class);
                            String phone=snapshot.child(Userusername).child("phoneNumber").getValue(String.class);
                            String uid=snapshot.child(Userusername).child("userid").getValue(String.class);

                            Intent intent1=new Intent(getApplicationContext(),ProfilePage.class);
                            intent1.putExtra("name",name);
                            intent1.putExtra("emailID",email);
                            intent1.putExtra("Phone no.",phone);
                            intent1.putExtra("Userid",uid);
                            startActivity(intent1);
                            finish();
                        }
                        else{
                            editTextTextPassword.setError("Invalid credentials");
                            editTextTextPassword.requestFocus();
                        }
                }else{
                    editTextTextEmailAddress.setError("User does not exist");
                    editTextTextEmailAddress.requestFocus();
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






