package com.guilherme.pessoa.pessoafísica;

import com.guilherme.pessoa.exceptions.CPFInválidoException;
import com.guilherme.pessoa.exceptions.DataInválidaException;

// Tests
import org.junit.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.assertj.core.api.Assertions.*;

public class PessoaFísicaTest {

    // Dado que...
    private PessoaFísica pessoaFísica;

    @Before
    public void setUp() {
        pessoaFísica = new PessoaFísica();
    }

    @Test
    public void testSetGetCPF() {
        // Test default
        Assert.assertEquals(PessoaFísica.PESSOA_SEM_CPF, pessoaFísica.getCPF());

        // quando...
        String CPFFormatado = "123.456.789-10";
        String CPFVálido = "12345678910";
        pessoaFísica.setCPF(CPFVálido);

        // evite...
        assertThatThrownBy( () -> pessoaFísica.setCPF(CPFFormatado) ).isInstanceOf( CPFInválidoException.class );
        assertThatThrownBy( () -> pessoaFísica.setCPF("abc")        ).isInstanceOf( CPFInválidoException.class );

        // certifique-se...
        System.out.println(pessoaFísica.getCPF());
        assertThat( pessoaFísica.getCPF(), is( equalTo( pessoaFísica.getCPF() )));

    }

    @Test
    public void testSetGetNome() {
        // Test default
        Assert.assertEquals(PessoaFísica.PESSOA_SEM_NOME, pessoaFísica.getNome());

        // quando...
        String nome = "Guilherme";
        pessoaFísica.setNome(nome);

        // evite...
        pessoaFísica.setNome("");
        pessoaFísica.setNome("123");

        // certifique-se...
        System.out.println(pessoaFísica.getNome());
        assertThat( pessoaFísica.getNome(), is( equalTo( nome )));
    }

    @Test
    public void testSetGetSobrenome() {
        // Test default
        Assert.assertEquals(PessoaFísica.PESSOA_SEM_SOBRENOME, pessoaFísica.getSobrenome());

        // quando...
        String sobrenome = "Esdras";
        pessoaFísica.setSobrenome(sobrenome);

        // evite...
        pessoaFísica.setSobrenome("");
        pessoaFísica.setSobrenome("456");

        // certifique-se...
        System.out.println(pessoaFísica.getSobrenome());
        assertThat( pessoaFísica.getSobrenome(), is( equalTo( sobrenome )));
    }

    @Test
    public void testSetGetDataDeNascimento_e_Idade() {
        // Test default
        Assert.assertEquals(PessoaFísica.PESSOA_SEM_DATADENASCIMENTO, pessoaFísica.getDataDeNascimento());

        // quando...
        String dataVálida = "21/04/1997";
        byte idade = 22;
        pessoaFísica.setDataDeNascimento(dataVálida);

        // evite...
        String dataInválida = "10/20/30";
        assertThatThrownBy( () -> pessoaFísica.setDataDeNascimento(dataInválida)    ).isInstanceOf( DataInválidaException.class );


        String dataFuturo = "01/01/2050";
        assertThatThrownBy( () -> pessoaFísica.setDataDeNascimento(dataFuturo)      ).isInstanceOf( DataInválidaException.class );

        String formatoInválido = "01012000";
        assertThatThrownBy( () -> pessoaFísica.setDataDeNascimento(formatoInválido) ).isInstanceOf( DataInválidaException.class );

        // certifique-se...
        System.out.println(pessoaFísica.getDataDeNascimento() + " " + pessoaFísica.getIdade());
        assertThat( pessoaFísica.getDataDeNascimento(), is( equalTo( dataVálida )));
        Assert.assertEquals( idade, pessoaFísica.getIdade() );
    }
}