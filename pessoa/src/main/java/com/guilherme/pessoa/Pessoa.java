package com.guilherme.pessoa;

// Outros packages
import com.guilherme.usuário.Usuário;
import com.guilherme.pessoa.exceptions.*;


// Apache utils
import org.apache.commons.lang3.*;

// Java utils
import java.util.Objects;


/**
 * <h1>Pessoa</h1>
 *
 * <p>Classe que modela um objeto do tipo Pessoa.</p>
 * <p>Uma Pessoa de qualquer tipo nesse sistema deve possuir um Endereço e (não obrigatoriamente) um número de Telefone.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public abstract class Pessoa extends Usuário {

    /* Atributos */
    private Endereço endereço;
    private String   telefone;


    /* Atributos Default */
    static final String PESSOA_SEM_TELEFONE = "--- Sem telefone ---";

    /* Atributos auxiliares */
    private static int larguraGeralDasTabelas = 0;
    public static int getLarguraGeralDasTabelas() {
        return larguraGeralDasTabelas;
    }
    public static void setLarguraGeralDasTabelas(int larguraGeralDasTabelas) {
        Pessoa.larguraGeralDasTabelas = larguraGeralDasTabelas;
    }
    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    // Construtor vazio
    public Pessoa() {
        super();
        this.setTelefone( PESSOA_SEM_TELEFONE );
        this.setEndereço( new Endereço() );
    }

    // Construtor de Pessoa sem informações de Usuário (para tests)
    public Pessoa(Endereço endereço, String telefone) {
        super();
        this.setEndereço( endereço );
        this.setTelefone( telefone );
    }

    // Construtor sem telefone / com endereço
    public Pessoa(String email, String login, String senha, // <-- Usuário
                  Endereço endereço)
    {
        super( email, login, senha );
        this.setTelefone( PESSOA_SEM_TELEFONE );
        this.setEndereço( endereço );
    }

    // Construtor completo
    public Pessoa(String email, String login, String senha, // <-- Usuário
                  Endereço endereço, String telefone)
    {
        super( email, login, senha );
        this.setEndereço( endereço );
        this.setTelefone( telefone );
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = Objects.requireNonNullElse(endereço, new Endereço());
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String telefoneTemp = StringUtils.defaultIfBlank(telefone, PESSOA_SEM_TELEFONE);
        if (telefoneVálido(telefoneTemp)) {
            // Formato pretendido: (xx) xxxxx-xxxx
            this.telefone = "(" + telefoneTemp.substring(0, 2) + ")" +
                            " " + telefoneTemp.substring(2, 7) + "-" +
                                  telefoneTemp.substring(7, 11);
        } else if (telefoneTemp.equals(PESSOA_SEM_TELEFONE)) {
            this.telefone = telefoneTemp;
        } else {
            throw new TelefoneInválidoException();
        }
    }


    /* ------------------------ */
    /* .::Métodos auxiliares::. */
    /* ------------------------ */

    /**
     * <h1>Telefone Válido</h1>
     *
     * <p>Verifica se um determinado número de telefone no formato String é válido.</p>
     *
     * @param telefone Número de telefone no formato String.
     * @return Valor booleano. True se for, False caso contrário.
     */
    private boolean telefoneVálido(String telefone) {
        return  ( stringNuméricaVálida(telefone) ) &&
                ( telefone.length() == 11 ) &&
                ( telefone.replaceAll(String.valueOf(telefone.charAt(0)), "").length() > 0 );
    }
}
