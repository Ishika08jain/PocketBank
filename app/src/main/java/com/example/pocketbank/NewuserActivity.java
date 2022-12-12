package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewuserActivity extends AppCompatActivity {
    Button button;
    EditText  editTextTextPersonName3, name, email, editTextTextPassword2, phone;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        button=findViewById(R.id.registerbt);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        editTextTextPersonName3= findViewById(R.id.editTextTextPersonName3);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");


                String NewUser = editTextTextPersonName3.getText().toString();
                String Password = editTextTextPassword2.getText().toString();
                String Name = name.getText().toString();
                String EmailId = email.getText().toString();
                String PhoneNumber = phone.getText().toString();

               RegisterDatabase registerDatabase = new RegisterDatabase(NewUser,Password, Name, EmailId, PhoneNumber);
                reference.child(NewUser).setValue(registerDatabase);

                Toast.makeText(NewuserActivity.this, "You have logged in", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);

            }
        });

    }
}