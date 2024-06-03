package com.example.controlandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    Animation anim;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //1.get animation from ressource
        anim= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.logo_anim);
        //2.get ImageView
        image=findViewById(R.id.logo);
        //3.apply animation on image
        image.startAnimation(anim);

        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}