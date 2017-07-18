package br.com.renan.appmix.lab16.domain.model;

public class Bairro {

    private String nome;

    private Municipio municipio;

    public Bairro() {
        super();

        this.municipio = new Municipio();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public void setUf(UF uf) {
        getMunicipio().setUf(uf);
    }
}
