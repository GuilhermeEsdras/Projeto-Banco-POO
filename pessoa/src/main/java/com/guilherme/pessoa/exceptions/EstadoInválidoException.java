package com.guilherme.pessoa.exceptions;

public class EstadoInválidoException extends RuntimeException {
    public EstadoInválidoException() {
        this("Estado inválido!");
    }

    public EstadoInválidoException(String mensagem) {
        super(mensagem);
    }
}
