package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.content.Intent;

import android.os.Bundle;

public class UpiActivity extends AppCompatActivity {
    Button b1,b2,done;
    ToggleButton t;
    EditText otp,newp,oldp,Newp;



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);
        t = findViewById(R.id.switch2);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        done=findViewById(R.id.button5);
        otp=findViewById(R.id.otp);
        newp=findViewById(R.id.Newpin);
        oldp=findViewById(R.id.oldPin);
        Newp=findViewById(R.id.NewestPin);


        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                } else {
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp.setVisibility(View.VISIBLE);
                oldp.setVisibility(View.VISIBLE);
                newp.setVisibility(View.VISIBLE);
                done.setVisibility(View.VISIBLE);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp.setVisibility(View.VISIBLE);
                Newp.setVisibility(View.VISIBLE);
                done.setVisibility(View.VISIBLE);


            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),PaymentsPage.class);
                startActivity(intent);
            }
        });


    }
}