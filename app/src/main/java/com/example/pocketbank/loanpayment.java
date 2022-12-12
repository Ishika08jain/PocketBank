package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import android.os.Bundle;

public class loanpayment extends AppCompatActivity {
    Spinner spinner2;
    Button button12;
    TextView textView29;
    EditText editTextreferncenumber;


    String[]loantype=getResources().getStringArray(R.array.loantype);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loanpayment);
        textView29 = findViewById(R.id.textView29);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.loantype, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        editTextreferncenumber=(EditText)findViewById(R.id.editTextTextPersonName6);
        button12 = findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }


        });
    }
}