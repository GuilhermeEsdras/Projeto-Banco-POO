package com.guilherme.pessoa;

// Apache utils
import com.guilherme.pessoa.exceptions.TelefoneInválidoException;
import org.apache.commons.lang3.*;

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
public abstract class Pessoa {

    /* Atributos */
    private Endereço endereço;
    private String   telefone;


    /* Atributos Default */
    private static final String PESSOA_SEM_TELEFONE = "--- Sem telefone ---";


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    // Construtor vazio
    public Pessoa() {
        this.setTelefone(PESSOA_SEM_TELEFONE);
        this.setEndereço(new Endereço());
    }

    // Construtor sem telefone / com endereço
    public Pessoa(Endereço endereço) {
        this.setTelefone(PESSOA_SEM_TELEFONE);
        this.setEndereço(endereço);
    }

    // Construtor completo
    public Pessoa(Endereço endereço, String telefone) {
        this.setEndereço(endereço);
        this.setTelefone(telefone);
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        if (endereço != null) {
            this.endereço = endereço;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String telefoneTemp = StringUtils.defaultIfBlank(telefone, PESSOA_SEM_TELEFONE);
        if (telefoneVálido(telefoneTemp)) {
            this.telefone = "(" + telefoneTemp.substring(0, 2) + ")" + " " +
                            telefoneTemp.substring(2, 7) + "-" +
                            telefoneTemp.substring(7, 10);
        } else if (telefoneTemp.equals(PESSOA_SEM_TELEFONE)) {
            this.telefone = telefoneTemp;
        } else {
            throw new TelefoneInválidoException();
        }
    }


    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.

    @Override
    public String toString() {
        return "Pessoa{" +
                "endereço=" + endereço +
                ", telefone='" + telefone + '\'' +
                '}';
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
        return  (StringUtils.isNumeric(telefone)) &&
                (telefone.length() == 10) &&
                (telefone.replaceAll(String.valueOf(telefone.charAt(0)), "").length() > 0);
    }
}
