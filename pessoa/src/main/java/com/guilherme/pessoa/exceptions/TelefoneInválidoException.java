package com.guilherme.pessoa.exceptions;

public class TelefoneInválidoException extends RuntimeException {
    public TelefoneInválidoException() {
        this("Número de telefone inválido!");
    }

    public TelefoneInválidoException(String mensagem) {
        super(mensagem);
    }
}
