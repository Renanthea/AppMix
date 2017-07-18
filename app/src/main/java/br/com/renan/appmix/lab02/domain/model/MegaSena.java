package br.com.renan.appmix.lab02.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public final class MegaSena {

    public interface Bundle {
        String JOGO = "lab02.megasena.jogo";
        String JOGOS = "lab02.megasena.jogos";
    }

    public interface Formats { // classe interna
        String JOGO = "%02d %02d %02d %02d %02d %02d";
    }

    private MegaSena() {
        super();
    }

    public static String sortear() {
        final Object[] jogo = { 0, 0, 0, 0, 0, 0 };
        int numero, count = 0;

        sorteio : do {
            numero = (int) (1 + Math.random() * 60);
            for (int i = 0; i < jogo.length; i++) {
                if (jogo[i].equals(0)) {
                    jogo[i] = numero;
                    count++;
                    continue sorteio;
                } else if (jogo[i].equals(numero)) {
                    continue sorteio;
                }
            }
        } while (count < jogo.length);

        Arrays.sort(jogo);
        return String.format(Locale.getDefault(), Formats.JOGO, jogo);
    }

    public static ArrayList<String> sortear(int jogos) {
        final ArrayList<String> js = new ArrayList<>();
        String jogo;

        while (jogos != 0) {
            jogo = sortear();

            if (js.contains(jogo)) {
                continue;
            }

            js.add(jogo);
            --jogos;
        }

        Collections.sort(js);

        return js;
    }
}
