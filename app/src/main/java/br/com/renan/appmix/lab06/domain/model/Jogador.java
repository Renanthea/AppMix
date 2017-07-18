package br.com.renan.appmix.lab06.domain.model;

public class Jogador {

    // Estado
    private Integer partidasGanhas;
    private String simbolo;

    // Construtores
    protected Jogador(String simbolo) {
        super();

        this.partidasGanhas = 0;
        this.simbolo = simbolo;
    }

    // Comportamentos
    public Integer getPartidasGanhas() {
        return partidasGanhas;
    }

    public void setPartidasGanhas(Integer partidasGanhas) {
        this.partidasGanhas = partidasGanhas;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void ganharPartida() {
        partidasGanhas++;
    }

    public void reiniciarPartida() {
        partidasGanhas = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;

        if (getPartidasGanhas() != null ? !getPartidasGanhas().equals(jogador.getPartidasGanhas()) : jogador.getPartidasGanhas() != null)
            return false;
        return getSimbolo() != null ? getSimbolo().equals(jogador.getSimbolo()) : jogador.getSimbolo() == null;

    }

    @Override
    public int hashCode() {
        int result = getPartidasGanhas() != null ? getPartidasGanhas().hashCode() : 0;
        result = 31 * result + (getSimbolo() != null ? getSimbolo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return simbolo;
    }
}
