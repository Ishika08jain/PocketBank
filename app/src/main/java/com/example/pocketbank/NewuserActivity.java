package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class NewuserActivity extends AppCompatActivity {
    Button registerbt;
    EditText  editTextTextPersonName3, name, email, editTextTextPassword2, phone, editTextTextPassword3;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pocketbank-d5a21-default-rtdb.firebaseio.com/");


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
        editTextTextPassword3= findViewById(R.id.editTextTextPassword3);






        registerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



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
                else{
                    reference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(userid)){
                                    Toast.makeText(NewuserActivity.this, "Userid is already registered", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    reference.child("users").child(userid).child(FullName).setValue(editTextTextPersonName3);
                                    reference.child("users").child(userid).child(Password).setValue(editTextTextPassword2);
                                    reference.child("users").child(userid).child(EmailId).setValue(email);
                                    reference.child("users").child(userid).child(PhoneNumber).setValue(phone);
                                    reference.child("users").child(userid).child(cnfPassword).setValue(editTextTextPassword3);
                                }
                            Toast.makeText(NewuserActivity.this, "You have registered successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                            startActivity(intent);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });
                }






            }
        });

    }
}