package com.guilherme.usuário.exceptions;

public class SenhaInválidaException extends RuntimeException {
    public SenhaInválidaException() {
        this("Senha inválida!");
    }

    public SenhaInválidaException(String mensagem) {
        super(mensagem);
    }
}
