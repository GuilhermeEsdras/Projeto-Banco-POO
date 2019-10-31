package com.guilherme.pessoa.pessoajurídica;

import com.guilherme.pessoa.exceptions.CNPjInválidoException;

// JUnit
import org.junit.*;

public class PessoaJurídicaTest {

    // Dado que...
    private PessoaJurídica pessoaJurídica;

    @Before
    public void setUp() {
        pessoaJurídica = new PessoaJurídica();
    }

    @Test(expected = CNPjInválidoException.class)
    public void testSetGetCNPj() {
        // Test default
        Assert.assertEquals(PessoaJurídica.PESSOA_JURÍDICA_SEM_CNPJ, pessoaJurídica.getCNPj());

        // quando...
        String CNPjFormatado = "12.345.678/9101-12";
        String CNPj = "12345678910112";
        pessoaJurídica.setCNPj(CNPj);

        // evite...
        pessoaJurídica.setCNPj("");
        pessoaJurídica.setCNPj(CNPjFormatado);
        pessoaJurídica.setCNPj("abc");

        // certifique-se...
        Assert.assertEquals(CNPjFormatado, pessoaJurídica.getCNPj());
    }

    @Test
    public void testSetGetNomeFantasia() {
        // Test default
        Assert.assertEquals(PessoaJurídica.PESSOA_JURÍDICA_SEM_NOMEFANTASIA, pessoaJurídica.getNomeFantasia());

        // quando...
        String nomeFantasia = "Algum Nome";
        pessoaJurídica.setNomeFantasia(nomeFantasia);

        // evite...
        pessoaJurídica.setNomeFantasia("");

        // certifique-se...
        Assert.assertEquals(nomeFantasia, pessoaJurídica.getNomeFantasia());
    }

    @Test
    public void testSetGetRazãoSocial() {
        // Test default
        Assert.assertEquals(PessoaJurídica.PESSOA_JURÍDICA_SEM_RAZÃOSOCIAL, pessoaJurídica.getRazãoSocial());

        // quando...
        String razãoSocial = "Alguma Razão";
        pessoaJurídica.setRazãoSocial(razãoSocial);

        // evite...
        pessoaJurídica.setRazãoSocial("");

        // certifique-se...
        Assert.assertEquals(razãoSocial, pessoaJurídica.getRazãoSocial());
    }
}