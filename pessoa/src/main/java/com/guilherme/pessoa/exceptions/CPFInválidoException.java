package com.guilherme.pessoa.exceptions;

public class CPFInválidoException extends RuntimeException {
    public CPFInválidoException() {
        this("CPF inválido!");
    }

    public CPFInválidoException(String messagem) {
        super(messagem);
    }

}
