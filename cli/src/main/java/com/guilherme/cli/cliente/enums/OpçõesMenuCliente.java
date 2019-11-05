package com.guilherme.cli.cliente.enums;

public enum OpçõesMenuCliente {
    ABRIR_CONTA_CORRENTE("Abrir nova Conta Corrente"),
    ABRIR_CONTA_POUPANCA("Abrir nova Conta Poupança"),
    CONSULTAR_CONTA("Consultar Conta"),
    REALIZAR_OPERACAO_EM_CONTA("Realizar Operação em Conta"),
    LOGOFF("Logoff"),
    SAIR("Sair do Sistema");

    private final String opçãoNome;

    OpçõesMenuCliente(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
