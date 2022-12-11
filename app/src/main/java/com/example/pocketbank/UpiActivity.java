package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class UpiActivity extends AppCompatActivity {
    Button button3,button4,button5;
    Switch switch2;
    EditText otp,NewPin,oldPin,NewestPin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);
        switch2= findViewById(R.id.switch2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        otp=findViewById(R.id.otp);
        NewPin=findViewById(R.id.NewPin);
        oldPin=findViewById(R.id.oldPin);
        NewestPin=findViewById(R.id.NewestPin);


//        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                button3.setEnabled(true);
//                button4.setEnabled(true);
//            } else {
//                button3.setEnabled(false);
//                button4.setEnabled(false);
//            }
//        });
//        button3.setOnClickListener(view -> {
//            otp.setVisibility(View.VISIBLE);
//            oldPin.setVisibility(View.VISIBLE);
//            NewPin.setVisibility(View.VISIBLE);
//            button5.setVisibility(View.VISIBLE);
//
//        });
//        button4.setOnClickListener(view -> {
//            otp.setVisibility(View.VISIBLE);
//            NewPin.setVisibility(View.VISIBLE);
//            button5.setVisibility(View.VISIBLE);
//
//
//        });
//        button5.setOnClickListener(view -> {
//            Intent intent= new Intent(getApplicationContext(),PaymentsPage.class);
//            startActivity(intent);
//        });
//

    }
}