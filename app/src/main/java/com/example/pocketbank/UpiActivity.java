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
    Button  button9;
    ToggleButton onoff;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);
        onoff = findViewById(R.id.onoff);

        button9 = findViewById(R.id.button9);




        onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "UPI IS ENABLED", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),UpionActivity.class);
                startActivity(intent);
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Payments.class);
                startActivity(intent);
            }
        });
    }
}
