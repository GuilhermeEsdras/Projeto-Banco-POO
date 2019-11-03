package com.guilherme.pessoa.pessoajurídica;

import com.guilherme.pessoa.exceptions.CNPjInválidoException;

// Tests
import org.junit.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.assertj.core.api.Assertions.*;

public class PessoaJurídicaTest {

    // Dado que...
    private PessoaJurídica pessoaJurídica;

    @Before
    public void setUp() {
        pessoaJurídica = new PessoaJurídica();
    }

    @Test
    public void testSetGetCNPj() {
        // Test default
        Assert.assertEquals(PessoaJurídica.PESSOA_JURÍDICA_SEM_CNPJ, pessoaJurídica.getCNPj());

        // quando...
        String CNPjFormatado = "12.345.678/9101-12";
        String CNPj = "12345678910112";
        pessoaJurídica.setCNPj(CNPj);

        // evite...
        assertThatThrownBy( () -> pessoaJurídica.setCNPj(CNPjFormatado) ).isInstanceOf( CNPjInválidoException.class );
        assertThatThrownBy( () -> pessoaJurídica.setCNPj("abc")         ).isInstanceOf( CNPjInválidoException.class );

        // certifique-se...
        System.out.println(pessoaJurídica.getCNPj());
        assertThat( pessoaJurídica.getCNPj(), is( equalTo( CNPjFormatado )));
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
        System.out.println(pessoaJurídica.getNomeFantasia());
        assertThat( pessoaJurídica.getNomeFantasia(), is( equalTo( nomeFantasia )));
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
        System.out.println(pessoaJurídica.getRazãoSocial());
        assertThat( pessoaJurídica.getRazãoSocial(), is( equalTo( razãoSocial )));
    }
}