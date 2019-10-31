package com.guilherme.pessoa.exceptions;

public class DataInválidaException extends RuntimeException {
    public DataInválidaException() {
        this("Formato de data inválido!");
    }

    public DataInválidaException(String mensagem) {
        super(mensagem);
    }
}
