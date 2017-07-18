package br.com.renan.appmix.lab01.app.controller;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import br.com.renan.appmix.R;

public class SplashActivity extends ImpactaActivity {

    Resources resources;
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab01_splash);

        handler = new Handler();
        resources = getResources();

        setToastOnClickAction(R.id.imageView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        handler.postDelayed(new Runnable() { // Objeto anônimo
            @Override
            public void run() {
                startActivity(new Intent(
                        getApplicationContext(),
                        MainActivity.class));
            }
        }, resources.getInteger(R.integer.lab01_handler_delay));
    }
}
