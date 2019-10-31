package com.guilherme.usuário.exceptions;

public class EmailInválidoException extends RuntimeException {
    public EmailInválidoException() {
        this("E-mail inválido!");
    }

    public EmailInválidoException(String mensagem) {
        super(mensagem);
    }
}
