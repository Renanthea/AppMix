package br.com.renan.appmix.lab16.domain.model;

import org.junit.Test;

public class EnderecoTest {

    @Test
    public void instanciaTest() {
        Endereco e;

        e = new Endereco();
        e.setNumero("1009");
        e.setComplemento("andar 4");
        e.getCep().setValor("00000-000");
        e.getLogradouro().setTipo("Avenida");
        e.getLogradouro().setNome("Paulista");
        //e.setBairroNome("Bela Vista");
        e.getLogradouro().getBairro().setNome("Bela Vista");
        //e.setMunicipioNome("São Paulo");
        e.getLogradouro().getBairro().getMunicipio().setNome("São Paulo");
        // Princípio do menor conhecimento
        e.setUf(UF.SP);
        //e.getLogradouro().getBairro().getMunicipio().setUf(UF.SP);
        System.out.println(e);

        e = new Endereco();
        System.out.println(e);
    }
}
