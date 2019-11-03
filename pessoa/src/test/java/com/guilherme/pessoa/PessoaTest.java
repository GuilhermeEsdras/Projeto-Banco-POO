package com.guilherme.pessoa;

import com.guilherme.pessoa.exceptions.TelefoneInválidoException;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;

// Tests
import org.junit.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.assertj.core.api.Assertions.*;

public class PessoaTest {
    private PessoaFísica pessoaFísica;

    @Before
    public void setUp() {
        pessoaFísica = new PessoaFísica();
    }

    @Test
    public void testGetSetTelefone() {

        // Dado que...
        String telefoneVálido = "83987425691";
        String telefoneVálidoFormatado = "(83) 98742-5691";

        // quando...
        pessoaFísica.setTelefone(telefoneVálido);

        // evite...
        assertThatThrownBy(() -> pessoaFísica.setTelefone( telefoneVálidoFormatado ))
                .isInstanceOf(TelefoneInválidoException.class);
        assertThatThrownBy(() -> pessoaFísica.setTelefone( "083987425691" ))
                .isInstanceOf(TelefoneInválidoException.class);
        assertThatThrownBy(() -> pessoaFísica.setTelefone( "987425691" ))
                .isInstanceOf(TelefoneInválidoException.class);
        assertThatThrownBy(() -> pessoaFísica.setTelefone( "87425691" ))
                .isInstanceOf(TelefoneInválidoException.class);
        assertThatThrownBy(() -> pessoaFísica.setTelefone( "abc" ))
                .isInstanceOf(TelefoneInválidoException.class);
        assertThatThrownBy(() -> pessoaFísica.setTelefone( "ABCD" ))
                .isInstanceOf(TelefoneInválidoException.class);
        assertThatThrownBy(() -> pessoaFísica.setTelefone( "1234567891012" ))
                .isInstanceOf(TelefoneInválidoException.class);
        assertThatThrownBy(() -> pessoaFísica.setTelefone( "@!.e5487dfasSASD" ))
                .isInstanceOf(TelefoneInválidoException.class);

        // certifique-se...
        System.out.println(pessoaFísica.getTelefone());
        assertThat( pessoaFísica.getTelefone(), is( equalTo( telefoneVálidoFormatado )));
    }
}