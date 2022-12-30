package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class ProfilePage extends AppCompatActivity {
     TextView textView41,textView42,textView43,textView44,textView45,textView46;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        textView41=findViewById(R.id.textView41);
        textView42=findViewById(R.id.textView42);
        textView43=findViewById(R.id.textView43);
        textView44=findViewById(R.id.textView44);
        textView45=findViewById(R.id.textView45);
        textView46=findViewById(R.id.textView46);

        
         gettingdata();

    }

    private void gettingdata() {
        Intent intent1=getIntent() ;
        String user_username=intent1.getStringExtra("Userid");
        String user_email=intent1.getStringExtra("emailID");
        String user_fullname=intent1.getStringExtra("name");
        String user_phoneno=intent1.getStringExtra("Phone no.");

        textView41.setText(user_fullname);
        textView42.setText(user_username);
        textView43.setText(user_fullname);
        textView44.setText(user_email);
        textView45.setText(user_phoneno);
        textView46.setText(user_username);



    }
}