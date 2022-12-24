package com.example.pocketbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.biometrics.BiometricPrompt;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View;
import android.widget.Spinner;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    //BiometricPrompt biometricPrompt;
    //BiometricPrompt.PromptInfo promptInfo;
    ConstraintLayout mMainLayout;
    RadioButton rb;
    Button button, button14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mMainLayout=findViewById(R.id.main_layout);
        rb = findViewById(R.id.rb);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);

            }
        });
        button14 = findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage();
            }
        });
    }

    private void changeLanguage(){
        final String languages[]={"English","Hindi","Marathi"};
        AlertDialog.Builder mbuilder= new AlertDialog.Builder(this);
        mbuilder.setTitle("Choose Language");
        mbuilder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (which==0){
                    setLocale("");
                    recreate();
                    }
                else if(which==1){
                    setLocale("hi");
                    recreate();
                }
                else if(which==2){
                    setLocale("mr");
                    recreate();
                }


            }
        });
        mbuilder.create();
        mbuilder.show();
    }

    private void setLocale(String language) {
        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext()
                .getResources().getDisplayMetrics());

    }


}




