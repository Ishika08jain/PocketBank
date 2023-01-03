package com.example.pocketbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Payments extends AppCompatActivity {
    ImageSlider imageSlider;
    TextView textView10, textView11, textView12, textView13, textView14, textView15,textView48;
    Button button3;
    ImageButton imageButton;
    private static final int PERMISSION_REQUEST_CALL_PHONE =1;
    private static final int PERMISSION_REQUEST_READ_CONTACTS= 2;
    private static final int PERMISSION_REQUEST_GET_ACCOUNTS= 3;


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
        button3= findViewById(R.id.button3);
        imageButton=findViewById(R.id.imageButton);
        textView48=findViewById(R.id.textView48);

        //hi




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

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ProfilePage.class);
                startActivity(intent);
            }
        });

        textView48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);
            }
        });


                PopupMenu popupMenu = new PopupMenu(this, button3);
        popupMenu.inflate(R.menu.menu_item);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.callbtn:

                        if (ContextCompat.checkSelfPermission(Payments.this, Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED) {
                            // Permission is not granted
                            // Request permission
                            ActivityCompat.requestPermissions(Payments.this,
                                    new String[]{Manifest.permission.CALL_PHONE},
                                    PERMISSION_REQUEST_CALL_PHONE);
                        } else {
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:8770778897"));
                            try {
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // Handle the exception here
                                Log.e("MyActivity", "ActivityNotFoundException", e);
                            } catch (SecurityException e) {
                                // Handle the exception here
                                Log.e("MyActivity", "SecurityException", e);
                            }
                            return true;
                        }

                    case R.id.mailbtn:
                        if (ContextCompat.checkSelfPermission(Payments.this, Manifest.permission.GET_ACCOUNTS)
                                != PackageManager.PERMISSION_GRANTED) {
                            // Permission is not granted
                            // Request permission
                            ActivityCompat.requestPermissions(Payments.this,
                                    new String[]{Manifest.permission.GET_ACCOUNTS},
                                    PERMISSION_REQUEST_GET_ACCOUNTS);
                        } else {
                            Intent intent = new Intent(Intent.ACTION_SENDTO);
                            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jainishika578@gmail.com"});
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                            intent.putExtra(Intent.EXTRA_TEXT, "Body");
                            startActivity(intent);
                        }

                        return true;

                case R.id.chatbtn:

                String phoneNumber = "9826293511"; // Replace with the phone number you want to send the message to
                String message = "I need help with my bank!"; // Replace with the message you want to send
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + message);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                return true;




                    default:
                        return false;
                }
            }
        });


                    button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();
            }
        });



















                }




}