package com.guilherme.conta.exceptions;

public class QuantiaNegativaException extends RuntimeException {
    public QuantiaNegativaException() {
        this("Quantia não pode ser negativa!");
    }

    public QuantiaNegativaException(String messagem) {
        super(messagem);
    }
}
