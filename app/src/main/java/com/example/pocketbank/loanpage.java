package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class loanpage extends AppCompatActivity {
    TextView linkTextView;
    Button button10,button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loanpage);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        linkTextView = findViewById(R.id.textView28);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), loanpayment.class);
                startActivity(intent);
            }

    });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), newloan.class);
                startActivity(intent);
            }


        });
}
    }


