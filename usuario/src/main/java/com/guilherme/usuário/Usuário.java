package com.guilherme.usuário;

// Outros packages
import com.guilherme.usuário.exceptions.EmailInválidoException;
import com.guilherme.usuário.exceptions.LoginInválidoException;
import com.guilherme.usuário.exceptions.SenhaInválidaException;


// Email Validator
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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


    /* Auxiliares */
    private Pattern letrasMinúsculas = Pattern.compile("[a-z]");
    private Pattern letrasMaiúsculas = Pattern.compile("[A-Z]");
    private Pattern dígitos = Pattern.compile("[0-9]");
    private Pattern special = Pattern.compile ("[!@#$%&*()_.,`´¨+=|<>?{}\\[\\]~-]");

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

    // Construtor vazio (geralmente para fins de tests)
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
        if (!possuiCaractereEspecial(login)) {
            this.login = login;
        } else {
            throw new LoginInválidoException();
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.length() >= 6) {
            this.senha = senha;
        } else {
            throw new SenhaInválidaException();
        }
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


    /**
     * <h1>String Numérica Válida</h1>
     *
     * <p>Verifica se uma determinada String passada como argumento possui apenas caracteres numéricos, sem letras ou
     * caracteres especiais.</p>
     *
     * @param string String a ser verificada.
     * @return Valor booleano.
     */
    public boolean stringNuméricaVálida(String string) {
        Matcher possuiLetrasMaiúsculas  = letrasMaiúsculas.matcher(string);
        Matcher possuiLetrasMinúsculas  = letrasMinúsculas.matcher(string);
        Matcher possuiCaractereEspecial = special.matcher(string);
        Matcher possuiDígito = dígitos.matcher(string);
        return !( possuiCaractereEspecial.find() && possuiLetrasMaiúsculas.find() && possuiLetrasMinúsculas.find() ) &&
                ( possuiDígito.find() );
    }

    /**
     * <h1>Possui Caractere Especial?</h1>
     *
     * <p>Verifica se uma determinada String passada como argumento possui algum caractere especial.</p>
     *
     * @param string String a ser verificada.
     * @return Valor booleano.
     */
    public boolean possuiCaractereEspecial(String string) {
        Matcher possuiCaracteresEspeciais = special.matcher(string);
        return possuiCaracteresEspeciais.find();
    }
}
