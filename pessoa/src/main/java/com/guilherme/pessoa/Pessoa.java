package com.guilherme.pessoa;

// Apache utils
import org.apache.commons.lang3.*;

import java.security.InvalidParameterException;
import java.util.Objects;

public abstract class Pessoa {

    // Atributos de uma Pessoa
    private Endereço endereço;
    private String telefone;

    // Atributos default de uma Pessoa
    private static final String PESSOA_SEM_TELEFONE = "--- Sem telefone ---";

    public Pessoa() {
        this.setTelefone(PESSOA_SEM_TELEFONE);
        this.setEndereço(new Endereço());
    }

    public Pessoa(Endereço endereço) {
        this.setTelefone(PESSOA_SEM_TELEFONE);
        this.setEndereço(endereço);
    }

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

    private boolean telefoneVálido(String telefone) {
        return  (StringUtils.isNumeric(telefone)) &&
                (telefone.length() == 10) &&
                (telefone.replaceAll(String.valueOf(telefone.charAt(0)), "").length() > 0);
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
            throw new InvalidParameterException();
        }
    }
}
