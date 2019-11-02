package com.guilherme.usuário.exceptions;

public class LoginInválidoException extends RuntimeException {
    public LoginInválidoException() {
        this("Login inválido!");
    }

    public LoginInválidoException(String mensagem) {
        super(mensagem);
    }
}
