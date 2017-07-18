package br.com.renan.appmix.lab02.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.renan.appmix.R;
import br.com.renan.appmix.lab01.app.controller.ImpactaActivity;
import br.com.renan.appmix.lab01.design.pattern.OnSeekBarChangeAdapter;
import br.com.renan.appmix.lab02.domain.model.MegaSena;

public class MegaSenaActivity extends ImpactaActivity {

    TextView textView;
    SeekBar seekBar;
    ListView listView;

    int jogos;
    ArrayList<String> sorteios = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lab02_megasena);

        textView = getViewById(R.id.tv_sorteio);
        seekBar = getViewById(R.id.sb_sorteio);
        listView = getViewById(android.R.id.list);

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeAdapter() {

            @Override
            public void onProgressChanged(SeekBar seekBar,
                                          int progress,
                                          boolean fromUser) {
                if (fromUser) {
                    textView.setText(String.valueOf(progress));
                }
            }
        });

        if (savedInstanceState != null) {
            jogos = savedInstanceState.getInt(MegaSena.Bundle.JOGO);
            sorteios = savedInstanceState.getStringArrayList(
                    MegaSena.Bundle.JOGOS);

            textView.setText(String.valueOf(jogos));
            seekBar.setProgress(jogos);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(MegaSena.Bundle.JOGO, jogos);
        outState.putStringArrayList(MegaSena.Bundle.JOGOS, sorteios);
    }

    public void sortear(View v) {
        jogos = seekBar.getProgress();
        sorteios = MegaSena.sortear(jogos);

        onResume();
    }

    @Override
    protected void onResume() {
        super.onResume();

        listView.setAdapter(new ArrayAdapter<>(this,
                R.layout.lab02_jogo,
                sorteios));
    }
}
