package com.guilherme.banco;

import com.guilherme.agência.Agência;
import com.guilherme.banco.exceptions.CódigoBancoInválidoException;

// Tests
import org.junit.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BancoTest {

    private Banco banco = new Banco();
    private Agência agência = new Agência("1234");


    @Test
    public void testGetSetCódigoBanco() {

        // Dado que...
        String códigoVálido = "123";

        // quando...
        banco.setCódigo(códigoVálido);

        // evite...
        assertThatThrownBy( () -> banco.setCódigo("12345") ).isInstanceOf( CódigoBancoInválidoException.class );
        assertThatThrownBy( () -> banco.setCódigo("ABCD") ).isInstanceOf( CódigoBancoInválidoException.class );
        assertThatThrownBy( () -> banco.setCódigo("s24q") ).isInstanceOf( CódigoBancoInválidoException.class );
        assertThatThrownBy( () -> banco.setCódigo("abc") ).isInstanceOf( CódigoBancoInválidoException.class );
        assertThatThrownBy( () -> banco.setCódigo("12#") ).isInstanceOf( CódigoBancoInválidoException.class );
        assertThatThrownBy( () -> banco.setCódigo("12") ).isInstanceOf( CódigoBancoInválidoException.class );

        // certifique-se
        System.out.println(banco.getCódigo());
        assertThat( banco.getCódigo(), is( equalTo( códigoVálido )));
    }

    @Test
    public void testDeve_Cadastrar_e_Remover_Agências()
    {
        // Cadastrando agência
        Assert.assertTrue( banco.cadastrarAgência( agência )) ;
        assertThat( banco.getListaDeAgências(), containsInAnyOrder( agência ));
        assertThat( banco.getQuantidadeDeAgências(), is( 1 ));

        // Removendo agência
        Assert.assertTrue( banco.removerAgência( "1234" ) );
        assertThat( banco.getListaDeAgências(), not( containsInAnyOrder( agência )));
        assertThat( banco.getQuantidadeDeAgências(), is( 0 ));
    }
}