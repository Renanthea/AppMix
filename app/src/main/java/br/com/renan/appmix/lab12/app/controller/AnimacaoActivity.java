package br.com.renan.appmix.lab12.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.renan.appmix.R;
import br.com.renan.appmix.lab01.app.controller.ImpactaActivity;

public class AnimacaoActivity extends ImpactaActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab12_animacao);
    }
}
