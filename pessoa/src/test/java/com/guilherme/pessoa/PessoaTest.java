package com.guilherme.pessoa;

import com.guilherme.pessoa.exceptions.TelefoneInválidoException;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;

import org.junit.*;

public class PessoaTest {
    private PessoaFísica pessoaFísica;

    @Before
    public void setUp() {
        pessoaFísica = new PessoaFísica();
    }

    @Test(expected = TelefoneInválidoException.class)
    public void testGetSetTelefone() {

        // Dado que...
        String telefoneVálido = "83987425691";
        String telefoneVálidoFormatado = "(83) 98742-5691";

        String telefoneInválido1 = "083987425691";
        String telefoneInválido2 = "987425691";
        String telefoneInválido3 = "87425691";
        String telefoneInválido4 = "abc";
        String telefoneInválido5 = "ABCD";
        String telefoneInválido6 = "1234567891012";
        String telefoneInválido7 = "@!.e5487dfasSASD";

        // quando...
        pessoaFísica.setTelefone(telefoneVálido);

        // evite...
        pessoaFísica.setTelefone( telefoneVálidoFormatado );
        pessoaFísica.setTelefone( telefoneInválido1 );
        pessoaFísica.setTelefone( telefoneInválido2 );
        pessoaFísica.setTelefone( telefoneInválido3 );
        pessoaFísica.setTelefone( telefoneInválido4 );
        pessoaFísica.setTelefone( telefoneInválido5 );
        pessoaFísica.setTelefone( telefoneInválido6 );
        pessoaFísica.setTelefone( telefoneInválido7 );

        // certifique-se
        Assert.assertEquals(telefoneVálidoFormatado, pessoaFísica.getTelefone());
    }
}