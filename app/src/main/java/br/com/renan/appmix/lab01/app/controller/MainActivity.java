package br.com.renan.appmix.lab01.app.controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.com.renan.appmix.R;
import br.com.renan.appmix.lab02.app.controller.MegaSenaActivity;
import br.com.renan.appmix.lab03.app.controller.GorjetaActivity;
import br.com.renan.appmix.lab12.app.controller.AnimacaoActivity;
import br.com.renan.appmix.lab13.app.controller.QuadroAnimacaoActivity;
import br.com.renan.appmix.lab14.app.controller.HotelActivity;

public class MainActivity extends ImpactaActivity {

    TextView title;

    Resources r;

    SimpleDateFormat sdf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab01_main);

        title = getViewById(R.id.lab01_tv_title);
        sdf = new SimpleDateFormat(" EEEE", Locale.getDefault());
        r = getResources();

        setOnClickActivity(R.id.lab01_bt_megasena, MegaSenaActivity.class);
        setOnClickActivity(R.id.lab01_bt_gorjeta, GorjetaActivity.class);
        setToastOnClickAction(R.id.lab01_bt_camera);

        setOnClickActivity(R.id.lab01_bt_animacao, AnimacaoActivity.class);
        setOnClickActivity(R.id.lab01_bt_animacao_quadro, QuadroAnimacaoActivity.class);
        setOnClickActivity(R.id.lab01_bt_fragment, HotelActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String texto = sdf.format(new Date());
        texto = r.getString(R.string.lab01_tv_laboratorios, texto);
        Log.d(TAG, texto);
        title.setText(texto);
    }
}
