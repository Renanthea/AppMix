package br.com.renan.appmix.lab13.app.controller;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import br.com.renan.appmix.R;
import br.com.renan.appmix.lab01.app.controller.ImpactaActivity;

public class QuadroAnimacaoActivity extends ImpactaActivity {

    ImageView iv;
    AnimationDrawable ad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab13_animacao);

        iv = getViewById(R.id.imageView);
        ad = (AnimationDrawable) iv.getBackground();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ad.start();
        Log.i(TAG, "Animação iniciada!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        ad.stop();
        Log.i(TAG, "Animação parada!");
    }
}
