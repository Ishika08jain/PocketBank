package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpionActivity extends AppCompatActivity {
     Button button7,button8,button15;
     EditText edit1,edit2,edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upion);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button15=findViewById(R.id.button15);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        edit3=findViewById(R.id.edit3);

        edit1.setVisibility(View.INVISIBLE);
        edit2.setVisibility(View.INVISIBLE);
        edit3.setVisibility(View.INVISIBLE);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setVisibility(View.VISIBLE);
                edit3.setVisibility(View.VISIBLE);
                edit2.setVisibility(View.INVISIBLE);
                button15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Your new pin is set", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Payments.class);
                        startActivity(intent);
                    }
                });
            }

        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit2.setVisibility(View.VISIBLE);
                edit3.setVisibility(View.VISIBLE);
                edit1.setVisibility(View.VISIBLE);
                button15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Your pin has changed", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Payments.class);
                        startActivity(intent);
                    }
                });
            }
        });




    }
}