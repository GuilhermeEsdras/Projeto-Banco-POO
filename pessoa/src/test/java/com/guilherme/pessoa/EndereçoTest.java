package com.guilherme.pessoa;

// Módulos
import com.guilherme.pessoa.enums.Estado;
import com.guilherme.pessoa.exceptions.EstadoInválidoException;

// JUnit
import org.junit.*;

public class EndereçoTest {

    // Dado que...
    private Endereço endereço1 = new Endereço();

    @Test
    public void testGetSetLogradouro() {
        // Set default
        Assert.assertEquals(Endereço.SEM_LOGRADOURO, endereço1.getLogradouro());

        // quando...
        String nomeAleatório = "Rua Tal";
        endereço1.setLogradouro(nomeAleatório);

        // certifique-se de...
        Assert.assertEquals(nomeAleatório, endereço1.getLogradouro());

        // evite que...
        endereço1.setLogradouro("");
        Assert.assertEquals(nomeAleatório, endereço1.getLogradouro());
    }

    @Test
    public void testGetSetNúmero() {
        // Set default
        Assert.assertEquals(Endereço.SEM_NÚMERO, endereço1.getNúmero());

        // quando...
        int númAleatório = 232;
        endereço1.setNúmero(númAleatório);

        // certifique-se de...
        Assert.assertEquals(númAleatório, endereço1.getNúmero());

        // evite que...
        endereço1.setNúmero(-1);
        Assert.assertEquals(númAleatório, endereço1.getNúmero());
    }

    @Test
    public void testGetSetComplemento() {
        // Set default
        Assert.assertEquals(Endereço.SEM_COMPLEMENTO, endereço1.getComplemento());

        // quando...
        String complemento = "Próximo a...";
        endereço1.setComplemento(complemento);

        // certifique-se de...
        Assert.assertEquals(complemento, endereço1.getComplemento());

        // evite que...
        endereço1.setComplemento("");
        Assert.assertEquals(complemento, endereço1.getComplemento());

    }

    @Test
    public void testGetSetBairro() {
        // Set default
        Assert.assertEquals(Endereço.SEM_BAIRRO, endereço1.getBairro());

        // quando...
        String bairro = "Jardim Floral";
        endereço1.setBairro(bairro);

        // evite que...
        endereço1.setBairro("");

        // certifique-se de...
        Assert.assertEquals(bairro, endereço1.getBairro());
    }

    @Test
    public void testGetSetCidade() {
        // Set default
        Assert.assertEquals(Endereço.SEM_CIDADE, endereço1.getCidade());

        // quando...
        String cidade = "Puxinanã";
        endereço1.setCidade(cidade);

        // evite que...
        endereço1.setCidade("");

        // certifique-se de...
        Assert.assertEquals(cidade, endereço1.getCidade());
    }

    @Test(expected = EstadoInválidoException.class)
    public void testGetSetEstado() {
        // Set default
        Assert.assertEquals(Estado.valueOf(Endereço.SEM_ESTADO), endereço1.getEstado());

        // quando...
        String estado = "PB";
        endereço1.setEstado(estado);

        // evite que...
        endereço1.setEstado("");
        endereço1.setEstado("AS");

        // certifique-se de...
        Assert.assertEquals(Estado.valueOf(estado), endereço1.getEstado());
    }
}