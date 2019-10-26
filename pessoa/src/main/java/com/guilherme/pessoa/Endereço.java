package com.guilherme.pessoa;

import com.guilherme.pessoa.enums.Estado;

public class Endereço {

    private String logradouro;
    private int número;
    private String complemento;
    private String bairro;
    private String cidade;
    private Estado estado;

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
        this.logradouro = logradouro;
    }

    public int getNúmero() {
        return número;
    }

    public void setNúmero(int número) {
        this.número = número;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
