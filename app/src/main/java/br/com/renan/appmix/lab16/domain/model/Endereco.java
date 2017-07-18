package br.com.renan.appmix.lab16.domain.model;

import java.io.Serializable;

public class Endereco implements Serializable {

    // Avenida Paulista, 1009, andar 4, 00000-000, Bela Vista, São Paulo - SP

    private String numero;

    private String complemento;

    private CEP cep;

    private Logradouro logradouro;

    public Endereco() {
        super();

        this.cep = new CEP();
        this.logradouro = new Logradouro();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public CEP getCep() {
        return cep;
    }

    public void setCep(CEP cep) {
        this.cep = cep;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public void setUf(UF uf) {
        getLogradouro().setUf(uf);
    }
}
