package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Switch;
import android.widget.ToggleButton;

public class UpiActivity extends AppCompatActivity {
    Button button7, button8, button9;
    EditText editTextNumber3,editTextNumber4;
    ToggleButton onoff;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);
        onoff = findViewById(R.id.onoff);
        button8 = findViewById(R.id.button8);
        button7 = findViewById(R.id.button7);
        button9 = findViewById(R.id.button9);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextNumber4 = findViewById(R.id.editTextNumber4);
        button7.setVisibility(View.INVISIBLE);
        button8.setVisibility(View.INVISIBLE);
        button9.setVisibility(View.INVISIBLE);
        editTextNumber4.setVisibility(View.INVISIBLE);
        editTextNumber3.setVisibility(View.INVISIBLE);


       onoff.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                   button7.setVisibility(View.VISIBLE);
                   button8.setVisibility(View.VISIBLE);
                   button9.setVisibility(View.VISIBLE);
                   editTextNumber3.setVisibility(View.VISIBLE);
                   editTextNumber4.setVisibility(View.VISIBLE);

           }
       });
//        } else {
//            button7.setVisibility(View.VISIBLE);
//            button8.setVisibility(View.VISIBLE);
//            button9.setVisibility(View.VISIBLE);
//            editTextNumber3.setVisibility(View.VISIBLE);
//            editTextNumber4.setVisibility(View.VISIBLE);
//
//        }


            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "UPI IS ENABLED", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Payments.class);
                    startActivity(intent);
                }
            });
        }
    }