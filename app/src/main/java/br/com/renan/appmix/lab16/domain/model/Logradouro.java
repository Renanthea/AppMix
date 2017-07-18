package br.com.renan.appmix.lab16.domain.model;

public class Logradouro {

    private String tipo;

    private String nome;

    private Bairro bairro;

    public Logradouro() {
        super();

        this.bairro = new Bairro();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public void setUf(UF uf) {
        getBairro().setUf(uf);
    }
}
