package com.guilherme.usuário;

import com.guilherme.usuário.exceptions.*;

// Tests
import org.junit.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.assertj.core.api.Assertions.*;


public class UsuárioTest {

    private Usuário usuário;

    @Before
    public void setUp() {
        usuário = new Usuário();
    }

    @Test
    public void testGetSetEmail() {
        // Test default
        Assert.assertEquals(Usuário.getEmailTest(), usuário.getEmail());

        // dado que...
        String emailVálido   = "guilherme.esdras@gmail.com";

        // quando...
        usuário.setEmail(emailVálido);

        // evite...
        assertThatThrownBy( () -> usuário.setEmail("guilherme.esdras@gmail") ).isInstanceOf( EmailInválidoException.class );
        assertThatThrownBy( () -> usuário.setEmail("guilherme.esdras@") ).isInstanceOf( EmailInválidoException.class );
        assertThatThrownBy( () -> usuário.setEmail("guilherme.esdras") ).isInstanceOf( EmailInválidoException.class );
        assertThatThrownBy( () -> usuário.setEmail("gu!lherme[esdrás") ).isInstanceOf( EmailInválidoException.class );

        // certifique-se...
        System.out.println(usuário.getEmail());
        assertThat( usuário.getEmail(), is( equalTo( emailVálido )));
    }

    @Test
    public void testGetSetLogin() {
        // Test default
        Assert.assertEquals(Usuário.getLoginTest(), usuário.getLogin());

        // dado que...
        String loginVálido    = "GuiEsdr4s";
        String loginInválido1 = "Gu!-$sdr@s.";        // Caracteres Inválidos
        String loginInválido2 = "GuilhermeEsdrasss";  // Tamanho máximo excedido

        // quando...
        usuário.setLogin(loginVálido);

        // evite...
        assertThatThrownBy( () -> usuário.setLogin( loginInválido1 ) ).isInstanceOf( LoginInválidoException.class );
        assertThatThrownBy( () -> usuário.setLogin( loginInválido2 ) ).isInstanceOf( LoginInválidoException.class );

        // certifique-se...
        System.out.println(usuário.getLogin());
        assertThat( usuário.getLogin(), is( equalTo( loginVálido )));
    }

    @Test
    public void testGetSetSenha() {
        // Test default
        Assert.assertEquals(Usuário.getSenhaPadrão(), usuário.getSenha());

        // dado que...
        String senhaVálida    = "123456";
        String senhaInválida1 = "12345";          // Tamanho mínimo exigido
        String senhaInválida2 = "1234567891234";  // Tamanho máximo excedido

        // quando...
        usuário.setSenha(senhaVálida);

        // evite...
        assertThatThrownBy( () -> usuário.setSenha( senhaInválida1 )).isInstanceOf( SenhaInválidaException.class );
        assertThatThrownBy( () -> usuário.setSenha( senhaInválida2 )).isInstanceOf( SenhaInválidaException.class );

        // certifique-se...
        System.out.println(usuário.getSenha());
        assertThat( usuário.getSenha(), is( equalTo( senhaVálida )));
    }
}