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

public class PaymentsPage extends AppCompatActivity {
    ImageSlider imageSlider;
    TextView textView10, textView11, textView12, textView13, textView14, textView15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_page);
        imageSlider =findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.image1,null));
        imageList.add(new SlideModel(R.drawable.image3,null));
        imageList.add(new SlideModel(R.drawable.pocket,null));

        imageSlider.setImageList(imageList);
        textView10 =  findViewById(R.id.textView10);
        textView11 =  findViewById(R.id.textView11);
        textView12 =  findViewById(R.id.textView12);
        textView13 =  findViewById(R.id.textView13);
        textView14 =  findViewById(R.id.textView14);
        textView15 =  findViewById(R.id.textView15);









        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),BillPaymentPage.class);
                startActivity(intent);
            }
        });

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),UpiActivity.class);
                startActivity(intent);

            }
        });
    }
}