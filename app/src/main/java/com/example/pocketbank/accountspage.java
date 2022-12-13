package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;

public class accountspage extends AppCompatActivity {
    TextView account;
    TextView textView34;
    TextView number;
    TextView textView36;
    TextView balance;
    TextView details;
    TextView mini;
    TextView statement;
    TextView more;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountspage);
        account=findViewById(R.id.textView31);
        textView34=findViewById(R.id.textView34);
        number=findViewById(R.id.textView33);
        textView36=findViewById(R.id.textView36);
        balance=findViewById(R.id.textView35);
        details=findViewById(R.id.textView37);
        mini=findViewById(R.id.textView38);
        statement=findViewById(R.id.textView39);
        more=findViewById(R.id.textView40);

    }
}