package br.com.renan.appmix.lab02.domain.model;

import org.junit.Test;

import java.util.ArrayList;

public class MegasenaTest {

    @Test
    public void sortearTest() {
        String jogo = MegaSena.sortear();

        System.out.println("Um jogo");
        System.out.println(jogo);
        System.out.println();
        System.out.println();
    }

    @Test
    public void sortear10JogosTest() {
        final int jogos = 10;
        ArrayList<String> r = MegaSena.sortear(jogos);

        System.out.println("Dez jogos");
        if (!r.isEmpty()) {
            for (int i = 0; i < jogos; i++) {
                System.out.println(r.get(i));
            }
            System.out.println();
            System.out.println();
        }
    }
}
