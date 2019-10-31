package com.guilherme.usuário;

// Outros packages
import com.guilherme.usuário.exceptions.EmailInválidoException;


// Email Validator
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class Usuário {

    /* Atributos */
    private String email;
    private String login;
    private String senha;


    /* Atributos Padrão */
    private static final String SENHA_PADRÃO = "123456";
    public static String getSenhaPadrão() {
        return SENHA_PADRÃO;
    }


    /* Para fins de Teste */
    private static final String EMAIL_TEST = "teste@test.com";
    public static String getEmailTest() {
        return EMAIL_TEST;
    }
    private static final String LOGIN_TEST = "test123";
    public static String getLoginTest() {
        return LOGIN_TEST;
    }


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    // Construtor vazio (geralmente para fins de testes)
    public Usuário() {
        this.setEmail( EMAIL_TEST );
        this.setLogin( LOGIN_TEST );
        this.setSenha( SENHA_PADRÃO );
    }

    // Construtor de Usuário sem senha
    public Usuário(String email, String login) {
        this.setEmail( email );
        this.setLogin( login );
        this.setSenha( SENHA_PADRÃO );
    }

    // Construtor Completo
    public Usuário(String email, String login, String senha) {
        this.setEmail( email );
        this.setLogin( login );
        this.setSenha( senha );
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (emailVálido(email)) {
            this.email = email;
        } else {
            throw new EmailInválidoException();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /* ------------------------ */
    /* .::Métodos auxiliares::. */
    /* ------------------------ */

    /**
     * <h1>E-mail Válido </h1>
     *
     * <p>Verifica se o e-mail passado como argumento está em formato válido.</p>
     *
     * @param email Endereço de E-mail tipo String.
     * @return Valor booleano. True se for válido, false caso contrário
     */
    public static boolean emailVálido(String email) {
        boolean válido = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            válido = false;
        }
        return válido;
    }
}
