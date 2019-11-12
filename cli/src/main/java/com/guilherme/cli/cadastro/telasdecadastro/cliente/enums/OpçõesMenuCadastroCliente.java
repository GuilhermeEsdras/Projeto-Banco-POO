package com.guilherme.cli.cadastro.telasdecadastro.cliente.enums;

import com.guilherme.console.utils.enums.cores.TextColor;

public enum OpçõesMenuCadastroCliente {
    CADASTRO_CLIENTE_PESSOA_FISICA("Pessoa Física"),
    CADASTRO_CLIENTE_PESSOA_JURIDICA("Pessoa Jurídica" + TextColor.AMARELO),
    VOLTAR("Voltar" + TextColor.VERMELHO),
    SAIR("Sair" + TextColor.RESET);

    private final String opçãoNome;

    OpçõesMenuCadastroCliente(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
