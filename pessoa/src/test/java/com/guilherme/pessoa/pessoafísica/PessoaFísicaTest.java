package com.guilherme.pessoa.pessoafísica;

import com.guilherme.pessoa.exceptions.CPFInválidoException;
import com.guilherme.pessoa.exceptions.DataInválidaException;

// JUnit
import org.junit.*;

public class PessoaFísicaTest {

    // Dado que...
    private PessoaFísica pessoaFísica;

    @Before
    public void setUp() {
        pessoaFísica = new PessoaFísica();
    }

    @Test(expected = CPFInválidoException.class)
    public void testSetGetCPF() {
        // Test default
        Assert.assertEquals(PessoaFísica.PESSOA_SEM_CPF, pessoaFísica.getCPF());

        // quando...
        String CPFFormatado = "123.456.789-10";
        String CPFVálido = "12345678910";
        pessoaFísica.setCPF(CPFVálido);

        // evite...
        pessoaFísica.setCPF("");
        pessoaFísica.setCPF(CPFFormatado);
        pessoaFísica.setCPF("abc");

        // certifique-se...
        Assert.assertEquals(CPFFormatado, pessoaFísica.getCPF());

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
        Assert.assertEquals(nome, pessoaFísica.getNome());
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
        Assert.assertEquals(sobrenome, pessoaFísica.getSobrenome());
    }

    @Test(expected = DataInválidaException.class)
    public void testSetGetDataDeNascimento_e_Idade() {
        // Test default
        Assert.assertEquals(PessoaFísica.PESSOA_SEM_DATADENASCIMENTO, pessoaFísica.getDataDeNascimento());

        // quando...
        String dataVálida = "21/04/1997";
        pessoaFísica.setDataDeNascimento(dataVálida);

        // evite...
        String dataInválida = "10/20/30";
        pessoaFísica.setDataDeNascimento(dataInválida);

        String dataFuturo = "01/01/2050";
        pessoaFísica.setDataDeNascimento(dataFuturo);

        String formatoInválido = "01012000";
        pessoaFísica.setDataDeNascimento(formatoInválido);

        // certifique-se...
        Assert.assertEquals(dataVálida, pessoaFísica.getDataDeNascimento());
        Assert.assertEquals(22, pessoaFísica.getIdade());
    }
}