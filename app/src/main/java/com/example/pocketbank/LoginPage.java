package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginPage extends AppCompatActivity {
    Button button2;
    TextView linkTextView;
    EditText editTextTextEmailAddress, editTextTextPassword;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button2 = findViewById(R.id.button2);
        linkTextView = findViewById(R.id.textView);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(!ValidateUsername() | !ValidatePassword()) {

                    }else{
                        checkUser();
                    }

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PaymentsPage.class);
                startActivity(intent);
            }
        });

        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),NewuserActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean ValidateUsername() {
        String val = editTextTextEmailAddress.getText().toString();
        if (val.isEmpty()) {
            editTextTextEmailAddress.setError("USERNAME CANNOT BE EMPTY!");
            return false;
        } else {
            editTextTextEmailAddress.setError(null);
            return true;
        }
    }

    public boolean ValidatePassword() {
        String val = editTextTextPassword.getText().toString();
        if (val.isEmpty()) {
            editTextTextPassword.setError("USERNAME CANNOT BE EMPTY!");
            return false;
        } else {
            editTextTextPassword.setError(null);
            return true;
        }
    }
        public void checkUser(){
            String username = editTextTextEmailAddress.getText().toString().trim();
            String password = editTextTextPassword.getText().toString().trim();

            DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
            Query checkUserDatabase  = reference.orderByChild("Username").equalTo(username);

            checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        editTextTextEmailAddress.setError(null);
                        String passwordfromDB = snapshot.child(username).child("password").getValue(String.class);
                        if(!Objects.equals(passwordfromDB, editTextTextPassword)) {
                            editTextTextEmailAddress.setError(null);
                            Intent intent = new Intent(LoginPage.this, PaymentsPage.class);
                            startActivity(intent);
                        } else {
                            editTextTextPassword.setError("Invalid credentials");
                            editTextTextPassword.requestFocus();
                        }
                    }else {
                        editTextTextEmailAddress.setError("Invalid username");
                        editTextTextEmailAddress.requestFocus();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }


    }





