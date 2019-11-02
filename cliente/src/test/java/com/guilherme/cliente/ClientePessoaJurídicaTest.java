package com.guilherme.cliente;

import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;
import org.junit.*;

public class ClientePessoaJurídicaTest {

    private ClientePessoaJurídica clientePessoaJurídica;

    @Before
    public void setUp() {
        clientePessoaJurídica = new ClientePessoaJurídica();
    }

    @Test
    public void testGetSetPessoaJurídica() {

        PessoaJurídica pessoaJurídica = new PessoaJurídica();

        clientePessoaJurídica.setPessoaJurídica( pessoaJurídica );

        Assert.assertEquals(pessoaJurídica, clientePessoaJurídica.getPessoaJurídica());

    }
}