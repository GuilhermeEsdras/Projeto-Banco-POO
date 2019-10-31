package com.guilherme.pessoa.exceptions;

public class CNPjInválidoException extends RuntimeException {
    public CNPjInválidoException() {
        this("CNPj inválido!");
    }

    public CNPjInválidoException(String mensagem) {
        super(mensagem);
    }
}
