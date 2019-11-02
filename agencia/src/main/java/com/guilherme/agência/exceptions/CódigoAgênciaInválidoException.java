package com.guilherme.agência.exceptions;

public class CódigoAgênciaInválidoException extends RuntimeException {
    public CódigoAgênciaInválidoException() {
        this("Código inválido!");
    }

    public CódigoAgênciaInválidoException(String messagem) {
        super(messagem);
    }
}
