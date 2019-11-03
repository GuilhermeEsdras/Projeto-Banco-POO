package com.guilherme.banco;

import com.guilherme.agência.Agência;
import com.guilherme.banco.exceptions.CódigoBancoInválidoException;

// Hamcrest
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

// JUnit
import org.junit.*;

public class BancoTest {

    private Banco banco = new Banco();
    private Agência agência = new Agência("1234");


    @Test(expected = CódigoBancoInválidoException.class)
    public void testGetSetCódigoBanco() {

        String códigoVálido = "123";

        banco.setCódigo(códigoVálido);

        // evite...
        banco.setCódigo("abc");
        banco.setCódigo("ABCD");
        banco.setCódigo("12345");
        banco.setCódigo("s24q");
        banco.setCódigo("12#");

        Assert.assertEquals(códigoVálido, banco.getCódigo());
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