package com.guilherme.usuário;

// Outros packages
import com.guilherme.console.utils.Block;
import com.guilherme.console.utils.Board;
import com.guilherme.console.utils.PrintUtils;
import com.guilherme.console.utils.Table;
import com.guilherme.usuário.exceptions.EmailInválidoException;
import com.guilherme.usuário.exceptions.LoginInválidoException;
import com.guilherme.usuário.exceptions.SenhaInválidaException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
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
    private static final int LOGIN_TAM_MAX = 16;
    public static int getLoginTamMax() {
        return LOGIN_TAM_MAX;
    }
    private static final int SENHA_TAM_MAX = 12;
    public static int getSenhaTamMax() {
        return SENHA_TAM_MAX;
    }
    private static final int SENHA_TAM_MIN = 6;
    public static int getSenhaTamMin() {
        return SENHA_TAM_MIN;
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
        if (!possuiCaractereEspecial(login) && StringUtils.isNotBlank(login) && login.length() <= getLoginTamMax()) {
            this.login = login;
        } else {
            throw new LoginInválidoException();
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.length() >= getSenhaTamMin() && senha.length() <= getSenhaTamMax()) {
            this.senha = senha;
        } else {
            throw new SenhaInválidaException();
        }
    }


    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.

    @Override
    public String toString() {

        PrintUtils printUtils = new PrintUtils();

        /* Informações da Tabela */
        String titulo       = "DADOS DO USUÁRIO";
        List<String> header = Arrays.asList(" CAMPO ", " VALOR ");
        String campoEmail   = " Email: ", email = getEmail();
        String campoLogin   = " Login: ", login = getLogin();
        String campoSenha   = " Senha: ", senha = getSenha();
        List<String> linha1 = Arrays.asList(campoEmail, email);
        List<String> linha2 = Arrays.asList(campoLogin, login);
        List<String> linha3 = Arrays.asList(campoSenha, senha);
        List<List<String>> linhas = Arrays.asList(linha1, linha2, linha3);

        /* Dimensões da Tabela */
        int quantidadeDeColunas = header.size();
        int larguraDoCampo      = campoEmail.length();
        int larguraDoValor      = getEmail().length() + 2;
        int larguraDaTabela     = Math.max((larguraDoCampo + larguraDoValor), titulo.length() ) + (quantidadeDeColunas + 1);
        int larguraDoTitulo     = larguraDaTabela - 2;
        int alturaDoTitulo      = printUtils.quantidadeDeLinhas(titulo);

        List<Integer> largurasDasLinhas = Arrays.asList(larguraDoCampo, larguraDoValor);
        List<Integer> alinhamentos = Arrays.asList(
                Block.DATA_CENTER,
                Block.DATA_CENTER
        );

        /* Construção da Tabela */
        Board tabela = new Board(larguraDaTabela);
        tabela.setInitialBlock(new Block(tabela, larguraDoTitulo, alturaDoTitulo, titulo).setDataAlign(Block.DATA_CENTER));
        tabela.appendTableTo(0, Board.APPEND_BELOW, new Table(tabela, larguraDaTabela, header, linhas, largurasDasLinhas).setColAlignsList(alinhamentos));
        return tabela.invalidate().build().getPreview();
    }


    /* ------------------------ */
    /* .::Métodos auxiliares::. */
    /* ------------------------ */

    /**
     * <h1>E-mail Válido </h1>
     *
     * <p>Verifica se o e-mail passado como argumento está em formato válido.</p>
     * <p>Regex de formato válido: [caracteres e números + @ + caracteres + . + de 2 a 4 caracteres]</p>
     *
     * @param email Endereço de E-mail tipo String.
     * @return Valor booleano. True se for válido, false caso contrário
     */
    public static boolean emailVálido(String email) {
        return email.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
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
