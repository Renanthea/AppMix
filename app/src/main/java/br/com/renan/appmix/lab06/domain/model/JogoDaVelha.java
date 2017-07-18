package br.com.renan.appmix.lab06.domain.model;

import java.util.Arrays;

public class JogoDaVelha {

    private static final int TABULEIRO_TAMANHO = 3;
    private static final CharSequence[] JOGO_NAO_GANHO = new CharSequence[0];

    public interface Formatos {
        String POSICAO = "%s,%s";
    }

    private Jogador jogadorAtual;
    private Jogador jogadorVencedor;

    private int jogadas;
    private CharSequence[] pos;

    private Jogador[] jogadores = new Jogador[]{
            new JogadorO(),
            new JogadorX()
    };

    private Jogador[][] tabuleiro;

    public void iniciar() {
        tabuleiro = new Jogador[TABULEIRO_TAMANHO][TABULEIRO_TAMANHO];
        jogadorAtual = jogadores[0];
        jogadorVencedor = null;
    }

    public void reinicarPartida() {
        jogadorVencedor = null;
        jogadores[0].reiniciarPartida();
        jogadores[1].reiniciarPartida();
    }

    private boolean isNotExistVencedor(CharSequence[] pos) {
        return Arrays.equals(JOGO_NAO_GANHO, pos);
    }

    public CharSequence[] ganharPorDiagonal() {
        CharSequence[] pos = {null, null, null};
        Jogador jogador;
        boolean igual = Boolean.FALSE;
        int linha, coluna;

        linha = coluna = 0;
        jogador = tabuleiro[linha][coluna];

        if (jogador != null) {
            pos[linha] = String.format(Formatos.POSICAO,
                    linha, coluna);

            igual = jogador.equals(tabuleiro[++linha]
                    [++coluna]);
            pos[linha] = igual ? String.format(Formatos.
                    POSICAO, linha, coluna) : null;

            igual = igual ? jogador.equals(tabuleiro[++linha]
                    [++coluna]) : igual;
            pos[linha] = igual ? String.format(Formatos.
                    POSICAO, linha, coluna) : null;
        }

        if (!igual) {
            linha = 0;
            coluna = (tabuleiro[linha].length - 1);
            jogador = tabuleiro[linha][coluna];

            if (jogador != null) {
                pos[linha] = String.format(Formatos.POSICAO,
                        linha, coluna);

                igual = jogador.equals(tabuleiro[++linha]
                        [--coluna]);
                pos[linha] = igual ? String.format(Formatos.
                        POSICAO, linha, coluna) : null;

                igual = igual ? jogador.
                        equals(tabuleiro[++linha][--coluna]) : igual;
                pos[linha] = igual ? String.format(Formatos.
                        POSICAO, linha, coluna) : null;
            }
        }

        if (!igual)
            return JOGO_NAO_GANHO;
        else
            return pos;
    }

    public CharSequence[] ganharPorColuna(int index) {
        CharSequence[] pos = {null, null, null};
        Jogador j01, j02 = null;

        for (int linha = 0; linha < tabuleiro.length; linha++) {
            j01 = tabuleiro[linha][index];

            if (linha == 0) {
                j02 = j01;
            }

            if (j01 == null || !j01.equals(j02)) {
                return JOGO_NAO_GANHO;
            }

            pos[linha] = toStringPosicao(linha, index);
        }
        return pos;
    }

    public CharSequence[] ganharPorLinha(int index) {
        CharSequence[] pos = {null, null, null};
        Jogador j01, j02 = null;

        for (int coluna = 0; coluna < tabuleiro[index].
                length; coluna++) {
            j01 = tabuleiro[index][coluna];

            if (j01 == null) {
                return JOGO_NAO_GANHO;
            }

            if (coluna == 0) {
                j02 = j01;
            }

            if (!j01.equals(j02)) {
                return JOGO_NAO_GANHO;
            }

            pos[coluna] = toStringPosicao(index, coluna);
        }

        return pos;
    }

    public CharSequence[] jogar(CharSequence posicao) {
        String[] pos = String.valueOf(posicao).
                split(",");

        return jogar(Integer.valueOf(pos[0]), Integer.
                valueOf(pos[1]));
    }

    public CharSequence[] jogar(int linha, int coluna) {
        pos = JOGO_NAO_GANHO;
        Jogador j = tabuleiro[linha][coluna];

        if (j == null) {
            tabuleiro[linha][coluna] = jogadorAtual;
            jogadas++;

            pos = ganharPorDiagonal();
            pos = isNotExistVencedor(pos) ?
                    ganharPorLinha(linha) : pos;
            pos = isNotExistVencedor(pos) ?
                    ganharPorColuna(coluna) : pos;

            if (isNotExistVencedor(pos)) {
                trocarJogador();
            } else {
                jogadorVencedor = jogadorAtual;
                jogadorAtual.ganharPartida();
            }
        }

        return pos;
    }

    public boolean isPartidaEmpatada() {
        final int linhas = tabuleiro.length;
        final int colunas = tabuleiro[0].length;
        return jogadas == (linhas * colunas);
    }

    public void trocarJogador() {
        for (int i = 0; i < jogadores.length; i++) {
            if (!jogadorAtual.equals(jogadores[i])) {
                jogadorAtual = jogadores[i];
                break;
            }
        }
    }

    public boolean isJogadorVencedorO() {
        return getJogadorO().equals(jogadorVencedor);
    }

    public boolean isJogadorVencedorX() {
        return getJogadorX().equals(jogadorVencedor);
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public Jogador getJogadorX() {
        return jogadores[1];
    }

    public Jogador getJogadorO() {
        return jogadores[0];
    }

    public int getAlturaTabuleiro() {
        return TABULEIRO_TAMANHO;
    }

    public int getLarguraTabuleiro() {
        return TABULEIRO_TAMANHO;
    }

    public static CharSequence toStringPosicao(int linha, int coluna) {
        return String.format(Formatos.POSICAO, linha, coluna);
    }

    public boolean isFimDeJogo() {
        return pos != null && pos.length > 0;
    }
}
