package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import java.util.HashMap;

import kotlinx.coroutines.ParentJob;

public class NewuserActivity extends AppCompatActivity {
    Button signup_button;
    EditText signup_name, signup_email, signup_username, signup_password;
    TextView loginRedirectText;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference().child("users").push();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signup_button = findViewById(R.id.signup_button);
        signup_name = findViewById(R.id.signup_name);
        signup_email = findViewById(R.id.signup_email);
        signup_password = findViewById(R.id.signup_password);
        signup_username = findViewById(R.id.signup_username);


        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = signup_name.getText().toString();
                String Password = signup_password.getText().toString();
                String userid = signup_username.getText().toString();
                String EmailId = signup_email.getText().toString();

                if(name.isEmpty() || Password.isEmpty() || userid.isEmpty() || EmailId.isEmpty()){
                    Toast.makeText(NewuserActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();


                }




                if(!name.isEmpty() && !Password.isEmpty() && !userid.isEmpty() && !EmailId.isEmpty()){
                    DatabaseReference myRef = database.getReference("users");
                    myRef.child(userid).setValue(new HelperClass(name, userid, EmailId, Password));

                    Toast.makeText(NewuserActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NewuserActivity.this, LoginPage.class);
                    startActivity(intent);

                }





//                HashMap<String, String> usermap = new HashMap<>();
//                usermap.put("name", name);
//                usermap.put("email", EmailId);
//                usermap.put("username", userid);
//                usermap.put("password", Password);
//
//                myRef.setValue(usermap);








            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewuserActivity.this, LoginPage.class);
                startActivity(intent);

            }
        });

    }


}













