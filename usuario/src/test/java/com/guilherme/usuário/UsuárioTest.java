package com.guilherme.usuário;

import com.guilherme.usuário.exceptions.*;

import org.junit.*;

public class UsuárioTest {

    private Usuário usuário;

    @Before
    public void setUp() {
        usuário = new Usuário();
    }

    @Test(expected = EmailInválidoException.class)
    public void testGetSetEmail() {
        // dado que...
        String emailVálido   = "guilherme.esdras@gmail.com";

        String emailInválido1 = "guilherme.esdras@gmail";
        String emailInválido2 = "guilherme.esdras@";
        String emailInválido3 = "guilherme.esdras";
        String emailInválido4 = "gu!lherme[esdrás";

        // quando...
        usuário.setEmail(emailVálido);

        // evite...
        usuário.setEmail(emailInválido1);
        usuário.setEmail(emailInválido2);
        usuário.setEmail(emailInválido3);
        usuário.setEmail(emailInválido4);

        // certifique-se...
        Assert.assertEquals(emailVálido, usuário.getEmail());
    }

    @Test(expected = LoginInválidoException.class)
    public void testGetSetLogin() {
        // dado que...
        String loginVálido = "GuiEsdr4s";

        String loginInválido1 = "Gu!-$sdr@s.";

        // quando...
        usuário.setLogin(loginVálido);

        // evite...
        usuário.setLogin(loginInválido1);

        // certifique-se...
        Assert.assertEquals(loginVálido, usuário.getLogin());

    }

    @Test(expected = SenhaInválidaException.class)
    public void testGetSetSenha() {
        // dado que...
        String senhaVálida = "123456";

        String senhaInválida = "12345"; // Menos de 6 caracteres

        // quando...
        usuário.setSenha(senhaVálida);

        // evite...
        usuário.setSenha(senhaInválida);

        // certifique-se...
        Assert.assertEquals(senhaVálida, usuário.getSenha());
    }
}