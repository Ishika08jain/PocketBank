package com.example.pocketbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;
public class spinwheel extends AppCompatActivity {
    private static final String[] sectors={"Get upto 80% discount at your Favourite brands","Earn cashback on Fuel with Indian oil X pocketbank","Invite your 1 friend and get a scratch card worth rs 100000","Get 3 months free membership at favourite streaming platforms","Get upto 1000 rewards by playing our latest game"};
    private static final int[] sectorDegrees=new int[sectors.length];
    private static final Random random=new Random();
    private int degree=0;
    private boolean isSpinning=false;
    private ImageView wheel;
    private KonfettiView konfettiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinwheel);


        final ImageView text=findViewById(R.id.imageView4);
        final Button spinBtn=findViewById(R.id.button2);
         wheel=findViewById(R.id.imageView13);
         konfettiView=findViewById(R.id.konfettiView);
      Shape.DrawableShape drawableShape =new Shape.DrawableShape(AppCompatResources.getDrawable(this,R.drawable.ic_baseline_rectangle_24), true);
        getDegreesForSectors();
        spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSpinning){
                    spin();
                    isSpinning=true;
                    EmitterConfig emitterConfig=new Emitter(300,TimeUnit.MILLISECONDS).max(300);
                    konfettiView.start(
                            new PartyFactory(emitterConfig)
                                    .shapes(Shape.Circle.INSTANCE, Shape.Square.INSTANCE, drawableShape)
                                    .spread(360)
                                    .position(0.5,0.25,1,1)
                                    .sizes(new Size(8,50,10))
                                    .timeToLive(10000)
                                    .fadeOutEnabled(true)
                                    .build()
                    );
                }



            }
        });
    }
    private void spin() {
        degree=random.nextInt(sectors.length-1);

        RotateAnimation rotateAnimation=new RotateAnimation(0,(360* sectors.length)+sectorDegrees[degree],
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }


            @Override
            public void onAnimationEnd(Animation animation) {
                EmitterConfig emitterConfig=new Emitter(300,TimeUnit.MILLISECONDS).max(300);
                Toast.makeText(spinwheel.this, "You've got"+ " "+ sectors[sectors.length-(degree+1)], Toast.LENGTH_SHORT).show();
                isSpinning=false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        wheel.startAnimation(rotateAnimation);



    }

    private void getDegreesForSectors(){
        int sectorDegree=360/ sectors.length;
        for(int i=0;i< sectors.length;i++){
            sectorDegrees[i]=(i+1)*sectorDegree;
        }
    }
}