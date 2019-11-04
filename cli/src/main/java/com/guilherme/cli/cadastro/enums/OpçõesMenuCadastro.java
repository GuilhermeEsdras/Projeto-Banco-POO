package com.guilherme.cli.cadastro.enums;

public enum OpçõesMenuCadastro {
    CADASTRAR_CLIENTE("Cliente"),
    CADASTRAR_FUNCIONARIO("Funcionário"),
    CADASTRAR_AGENCIA("Agência"),
    CADASTRAR_BANCO("Banco"),
    VOLTAR("Voltar"),
    SAIR("Sair");

    private final String opçãoNome;

    OpçõesMenuCadastro(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
