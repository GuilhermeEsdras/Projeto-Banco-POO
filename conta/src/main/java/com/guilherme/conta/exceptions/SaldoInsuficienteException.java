package com.guilherme.conta.exceptions;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException() {
        this("Saldo insuficiente!");
    }

    public SaldoInsuficienteException(String messagem) {
        super(messagem);
    }
}
