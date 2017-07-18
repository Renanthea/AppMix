package br.com.renan.appmix.lab16.domain.model;

public class Municipio {

    private String nome;

    private UF uf;

    public Municipio() {
        super();

        this.uf = UF.ESCOLHA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
