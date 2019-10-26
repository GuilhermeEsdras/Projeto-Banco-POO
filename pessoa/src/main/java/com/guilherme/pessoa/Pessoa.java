package com.guilherme.pessoa;

public abstract class Pessoa {

    private Endereço endereço;
    private String telefone;

    public Pessoa(Endereço endereço, String telefone) {
        this.setEndereço(endereço);
        this.setTelefone(telefone);
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
