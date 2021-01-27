package com.example.flyshoes.Aplicacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.flyshoes.R;


public class SplashVentanaActivity extends AppCompatActivity {
    private LottieAnimationView animacionView;
    private ConstraintLayout clContenedor;
    private AnimationDrawable adAnimacion;
    private final int DURACION_SPLASH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ventana);
        clContenedor = (ConstraintLayout) findViewById(R.id.clContenedor);
        animacionView = (LottieAnimationView) findViewById(R.id.ivSplash);
        animacionView.setAnimation(R.raw.shoes);
        animacionView.playAnimation();
        animacionView.setRepeatCount(500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashVentanaActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();


            }
        }, DURACION_SPLASH);
    }
}