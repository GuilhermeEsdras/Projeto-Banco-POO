package com.guilherme.conta.services;

/**
 * <h1>Serviço de Extrato</h1>
 *
 * <p>Interface responsável por calcular as taxas, cobranças e demais métodos ligados ao Serviço de Extrato do Banco.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public interface ServiçoDeExtrato {

    double getTaxaDeExtrato();
    String getExtrato(int dias);

    default double descontaTaxaDeExtrato(double saldo) {
        return (saldo - getTaxaDeExtrato());
    }

}
