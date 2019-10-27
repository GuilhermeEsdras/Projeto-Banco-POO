package com.guilherme.pessoa;

import com.guilherme.pessoa.enums.Estado;

public class Endereço {

    // Atributos
    private String logradouro;
    private int número;
    private String complemento;
    private String bairro;
    private String cidade;
    private Estado estado;


    // Atributos default
    private static final String SEM_LOGRADOURO = "--- Sem logradouro ---";
    private static final int SEM_NÚMERO = 0;
    private static final String SEM_COMPLEMENTO = "--- Sem complemento ---";
    private static final String SEM_BAIRRO = "--- Sem bairro ---";
    private static final String SEM_CIDADE = "--- Sem cidade ---";


    public Endereço()
    {
        this.setLogradouro(SEM_LOGRADOURO);
        this.setNúmero(SEM_NÚMERO);
        this.setBairro(SEM_BAIRRO);
        this.setCidade(SEM_CIDADE);
        this.setEstado(Estado.NA);
    }

    public Endereço(String logradouro, int número, String bairro, String cidade, Estado estado)
    {
        this.setLogradouro(logradouro);
        this.setNúmero(número);
        this.setComplemento(SEM_COMPLEMENTO);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
    }

    public Endereço(String logradouro, int número, String complemento, String bairro, String cidade, Estado estado)
    {
        this.setLogradouro(logradouro);
        this.setNúmero(número);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
    }

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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
