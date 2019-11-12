package com.guilherme.cli.login.enums;

import com.guilherme.console.utils.enums.cores.TextColor;

public enum OpçõesMenuLogin {
    FAZER_LOGIN("Fazer Login"),
    CADASTRAR("Cadastrar-se"),
    RECUPERAR_SENHA("Recuperar Senha" + TextColor.VERMELHO),
    SAIR("Sair" + TextColor.RESET);

    private final String opçãoNome;

    OpçõesMenuLogin(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
