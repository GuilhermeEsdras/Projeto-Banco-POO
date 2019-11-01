package com.guilherme.conta.services;

/**
 * <h1>Serviço de Depósito</h1>
 *
 * <p>Interface responsável por calcular as taxas, cobranças e demais métodos ligados ao Serviço de Depósito do Banco.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public interface ServiçoDeDepósito {

    void depositar(double quantia);

}
