package br.com.renan.appmix.lab14.domain.model;

import java.io.Serializable;

// Objeto
public class Hotel implements Serializable {

    // Estado
    private String nome;
    private String endereco;
    private float estrelas;

    // Construtor
    public Hotel() {
        super();
    }

    public Hotel(String nome, String endereco, float estrelas) {
        super();

        this.nome = nome;
        this.endereco = endereco;
        this.estrelas = estrelas;
    }

    // Comportamentos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (this.nome == null) {
            this.nome = nome;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(float estrelas) {
        this.estrelas = estrelas;
    }

    @Override
    public String toString() {
        return nome;
    }
}
