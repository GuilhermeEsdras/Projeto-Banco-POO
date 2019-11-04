package com.guilherme.cli.login.enums;

public enum OpçõesMenuLogin {
    FAZER_LOGIN("Fazer Login"),
    CADASTRAR("Cadastrar-se"),
    RECUPERAR_SENHA("Recuperar Senha"),
    SAIR("SAIR");

    private final String opçãoNome;

    OpçõesMenuLogin(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
