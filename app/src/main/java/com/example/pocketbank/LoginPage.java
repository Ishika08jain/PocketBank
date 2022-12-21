package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class LoginPage extends AppCompatActivity {
    Button button2;
    TextView linkTextView;
    EditText editTextTextEmailAddress, editTextTextPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button2 = findViewById(R.id.button2);
        linkTextView = findViewById(R.id.textView);
     editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
         editTextTextPassword = findViewById(R.id.editTextTextPassword);



//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkDataEntered();
//            }
//
//            private void checkDataEntered() {
//                String N = editTextTextEmailAddress.getText().toString();
//                if (N.isEmpty()) {
//                    Toast t = Toast.makeText(LoginPage.this, "You must enter name to apply for loan!", Toast.LENGTH_LONG);
//                    t.show();
//
//                }
//                String Q = editTextTextPassword.getText().toString();
//                if (Q.isEmpty()) {
//                    editTextTextPassword.setError("quotation for loan  is required!");
//                }
//
//            }
//
//        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editTextTextEmailAddress.getText().toString();
                String password = editTextTextPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginPage.this, "Username and password can't be empty", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Payments.class);
                    startActivity(intent);
                }


            }
        });
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewuserActivity.class);
                startActivity(intent);

            }
        });
    }
}





