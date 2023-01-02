package com.example.pocketbank;

import static android.content.ContentValues.TAG;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ProfilePage extends AppCompatActivity {
     TextView textView41,textView42,textView43,textView44,textView45,textView46;
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        textView41 = findViewById(R.id.textView41);
        textView42 = findViewById(R.id.textView42);
        textView43 = findViewById(R.id.textView43);
        textView44 = findViewById(R.id.textView44);
        textView45 = findViewById(R.id.textView45);
        textView46 = findViewById(R.id.textView46);



        database = FirebaseDatabase.getInstance();
        myRef= database.getReference("users");


         gettingdata();

    }

    private void gettingdata() {
        Intent intent1 = getIntent();
        String user_username = intent1.getStringExtra("Userid");
        String user_email = intent1.getStringExtra("emailID");
        String user_fullname = intent1.getStringExtra("name");
        String user_phoneno = intent1.getStringExtra("Phone no.");


        textView41.setText(user_fullname);
        textView42.setText(user_username);
        textView43.setText(user_fullname);
        textView44.setText(user_email);
        textView45.setText(user_phoneno);
        textView46.setText(user_username);

    }


    }
