package com.guilherme.pessoa;

import com.guilherme.pessoa.enums.Estado;
import com.guilherme.pessoa.exceptions.EstadoInválidoException;
import org.apache.commons.lang3.EnumUtils;

/**
 * <h1>Endereço</h1>
 *
 * <p>Classe que modela um objeto do tipo Endereço.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public class Endereço {

    /* Atributos */
    private String  logradouro;
    private int     número;
    private String  complemento;
    private String  bairro;
    private String  cidade;
    private Estado  estado;


    /* Atributos Default */
    static final String SEM_LOGRADOURO  = "--- Sem logradouro ---";
    static final int    SEM_NÚMERO      = 0;
    static final String SEM_COMPLEMENTO = "--- Sem complemento ---";
    static final String SEM_BAIRRO      = "--- Sem bairro ---";
    static final String SEM_CIDADE      = "--- Sem cidade ---";
    static final String SEM_ESTADO      = "NA";


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    // Construtor vazio
    public Endereço()
    {
        this.setLogradouro(SEM_LOGRADOURO);
        this.setNúmero(SEM_NÚMERO);
        this.setComplemento(SEM_COMPLEMENTO);
        this.setBairro(SEM_BAIRRO);
        this.setCidade(SEM_CIDADE);
        this.setEstado(SEM_ESTADO);
    }

    // Construtor sem complemento
    public Endereço(String logradouro, int número, String bairro, String cidade, String estado)
    {
        this.setLogradouro(logradouro);
        this.setNúmero(número);
        this.setComplemento(SEM_COMPLEMENTO);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
    }

    // Construtor completo
    public Endereço(String logradouro, int número, String complemento, String bairro, String cidade, String estado)
    {
        this.setLogradouro(logradouro);
        this.setNúmero(número);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        if (logradouro.length() > 0) {
            this.logradouro = logradouro;
        }
    }

    public int getNúmero() {
        return número;
    }

    public void setNúmero(int número) {
        if (número >= 0) {
            this.número = número;
        }
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if (complemento.length() > 0) {
            this.complemento = complemento;
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro.length() > 0) {
            this.bairro = bairro;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if (cidade.length() > 0) {
            this.cidade = cidade;
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (EnumUtils.isValidEnum(Estado.class, estado)) {
            this.estado = Estado.valueOf(estado);
        } else {
            throw new EstadoInválidoException();
        }
    }


    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.

    @Override
    public String toString() {
        return "Endereço{" +
                "logradouro='" + logradouro + '\'' +
                ", número=" + número +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado=" + estado +
                '}';
    }
}
