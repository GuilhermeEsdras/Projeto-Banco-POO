package com.guilherme.cli.exceptions;

public class OpçãoInválidaException extends RuntimeException {
    public OpçãoInválidaException() {
        this("Opção inválida!");
    }

    public OpçãoInválidaException(String mensagem) {
        super(mensagem);
    }
}
