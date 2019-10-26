package com.guilherme.conta.exceptions;

public class IgualAZeroException extends RuntimeException {
    public IgualAZeroException() {
        this("Quantia não pode ser zero!");
    }

    public IgualAZeroException(String messagem) {
        super(messagem);
    }
}
