package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import kotlinx.coroutines.ParentJob;

public class NewuserActivity extends AppCompatActivity {
    Button registerbt;
    EditText  editTextTextPersonName3, name, email, editTextTextPassword2, phone, editTextTextPassword3;
    TextView textView5;
    CheckBox checkBox, checkBox2, checkBox3;
    FirebaseDatabase database;
    DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        registerbt=findViewById(R.id.registerbt);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        editTextTextPersonName3= findViewById(R.id.editTextTextPersonName3);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        textView5= findViewById(R.id.textView5);
        checkBox= findViewById(R.id.checkBox);
        checkBox2= findViewById(R.id.checkBox2);
        checkBox3= findViewById(R.id.checkBox3);
        editTextTextPassword3= findViewById(R.id.editTextTextPassword3);






        registerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                myRef= database.getReference("users");




                String FullName = editTextTextPersonName3.getText().toString();
                String Password = editTextTextPassword2.getText().toString();
                String cnfPassword = editTextTextPassword3.getText().toString();
                String userid = name.getText().toString();
                String EmailId = email.getText().toString();
                String PhoneNumber = phone.getText().toString();

                if(FullName.isEmpty()|| Password.isEmpty() || userid.isEmpty()|| EmailId.isEmpty() || PhoneNumber.isEmpty()){
                    Toast.makeText(NewuserActivity.this, "Please fill all the details", Toast.LENGTH_LONG).show();
                }
                else if(!cnfPassword.equals(Password)){
                    Toast.makeText(NewuserActivity.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();


                }

                HelperClass helperClass = new HelperClass(FullName, Password, userid, EmailId, PhoneNumber);
                myRef.child(userid).setValue(helperClass);
                Toast.makeText(NewuserActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewuserActivity.this, LoginPage.class);
                startActivity(intent);















            }
        });

    }
}