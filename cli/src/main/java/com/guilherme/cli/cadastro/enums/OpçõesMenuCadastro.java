package com.guilherme.cli.cadastro.enums;

import com.guilherme.console.utils.enums.cores.TextColor;

public enum OpçõesMenuCadastro {
    CADASTRAR_CLIENTE("Cliente"),
    CADASTRAR_FUNCIONARIO("Funcionário"),
    CADASTRAR_AGENCIA("Agência"),
    CADASTRAR_BANCO("Banco" + TextColor.AMARELO),
    VOLTAR("Voltar" + TextColor.VERMELHO),
    SAIR("Sair" + TextColor.RESET);

    private final String opçãoNome;

    OpçõesMenuCadastro(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
