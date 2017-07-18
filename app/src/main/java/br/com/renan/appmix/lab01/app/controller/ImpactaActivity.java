package br.com.renan.appmix.lab01.app.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.renan.appmix.R;

public abstract class ImpactaActivity extends AppCompatActivity {

    public static final String TAG = "LIMPACTA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Passei pelo onCreate em: "
                + getClass().getSimpleName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Passei pelo onStart em: "
                + getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Passei pelo onResume em: "
                + getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Passei pelo onPause em: "
                + getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Passei pelo onStop em: "
                + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Passei pelo onDestroy em: "
                + getClass().getSimpleName());
    }

    protected void setOnClickActivity(int id, Class<?> c) {
        View v = findViewById(id);

        setOnClickActivity(v, c);
    }

    protected void setOnClickActivity(View v, final Class<?> c) {
        // Objeto anônimo
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context cc = ImpactaActivity.this;
                Bundle anim = ActivityOptionsCompat.makeCustomAnimation(cc,
                        R.anim.slide_in_left, R.anim.slide_out_left)
                        .toBundle();
                Intent i = new Intent(cc, c);
                startActivity(i, anim);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(
                R.anim.slide_in_right, R.anim.slide_out_right);
    }

    protected <T extends View> T getViewById(int id) {
        return (T) findViewById(id);
    }

    protected void setToastOnClickAction(int id) {
        final View b;
        final Object texto;

        b = getViewById(id);
        texto = (b instanceof TextView) ?
                ((TextView) b).getText() : "";
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t; // Toast

                t = Toast.makeText(getApplicationContext(),
                        getResources().getString(
                                R.string.lab01_toast_clicado,
                                texto),
                        Toast.LENGTH_SHORT);

                t.show();
            }
        });
    }
}
