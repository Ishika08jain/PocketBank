package com.example.pocketbank;

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
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class newloan extends AppCompatActivity {
    TextView textView27;
    TextView textView30;
    Spinner spinner3;
    EditText name;
    EditText quotation;
    EditText amount;
    CheckBox consent;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    EditText uniqueid;
    Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newloan);

        textView27= findViewById(R.id.textView27);
        textView30= findViewById(R.id.textView30);
        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.loantype, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner3.setAdapter(adapter);
        name= findViewById(R.id.editTextTextPersonName9);
        quotation = findViewById(R.id.editTextTextPersonName10);
        amount = findViewById(R.id.editTextTextPersonName11);
        radioGroup = findViewById(R.id.radioGroup);
        consent= findViewById(R.id.checkBox4);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1=findViewById(R.id.radio_one);
        radioButton2=findViewById(R.id.radio_two);
        uniqueid= findViewById(R.id.editTextNumberPassword);
        apply=findViewById((R.id.button13));
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }

            private void checkDataEntered() {
                String N=name.getText().toString();
                if (N.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter name to apply for loan!", Toast.LENGTH_SHORT);
                    t.show();
                }
                String Q=quotation.getText().toString();
                if (Q.isEmpty()) {
                    quotation.setError("quotation for loan  is required!");
                }

            }





        });

}}








