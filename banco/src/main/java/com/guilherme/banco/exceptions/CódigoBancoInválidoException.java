package com.guilherme.banco.exceptions;

public class CódigoBancoInválidoException extends RuntimeException {
    public CódigoBancoInválidoException() {
        this("Código inválido!");
    }

    public CódigoBancoInválidoException(String menssagem) {
        super();
    }
}
