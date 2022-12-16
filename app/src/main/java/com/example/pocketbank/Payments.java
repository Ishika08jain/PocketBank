package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Payments extends AppCompatActivity {
    ImageSlider imageSlider;
    TextView textView10, textView11, textView12, textView13, textView14, textView15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        imageSlider =findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.c1,null));
        imageList.add(new SlideModel(R.drawable.c2,null));
        imageList.add(new SlideModel(R.drawable.c3,null));
        imageList.add(new SlideModel(R.drawable.c4,null));
        imageList.add(new SlideModel(R.drawable.c5,null));

        imageSlider.setImageList(imageList);
        textView10 =  findViewById(R.id.textView10);
        textView11 =  findViewById(R.id.textView11);
        textView12 =  findViewById(R.id.textView12);
        textView13 =  findViewById(R.id.textView13);
        textView14 =  findViewById(R.id.textView14);
        textView15 =  findViewById(R.id.textView15);


        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),accountspage.class);
                startActivity(intent);
            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),BillPaymentPage.class);
                startActivity(intent);
            }
        });

        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),KycActivity.class);
                startActivity(intent);
            }
        });
        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),UpiActivity.class);
                startActivity(intent);
            }
        });
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),loanpage.class);
                startActivity(intent);
            }
        });



    }
}