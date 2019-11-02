package com.guilherme.cliente;

import com.guilherme.pessoa.pessoafísica.PessoaFísica;
import org.junit.*;

public class ClientePessoaFísicaTest {

    private ClientePessoaFísica clientePessoaFísica;

    @Before
    public void setUp() {
        clientePessoaFísica = new ClientePessoaFísica();
    }

    @Test
    public void testGetSetPessoaFísica() {

        PessoaFísica pessoaFísica = new PessoaFísica();

        clientePessoaFísica.setPessoaFísica( pessoaFísica );

        Assert.assertEquals(pessoaFísica, clientePessoaFísica.getPessoaFísica());

    }

}