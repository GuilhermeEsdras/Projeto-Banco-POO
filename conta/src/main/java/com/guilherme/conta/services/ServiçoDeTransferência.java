package com.guilherme.conta.services;

/**
 * <h1>Serviço de Transferência</h1>
 *
 * <p>Interface responsável por calcular as taxas, cobranças e demais métodos ligados ao Serviço de Transferência do Banco.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public interface ServiçoDeTransferência {

    double getTaxaDeTransferência();
    double transferir(double quantia, int número);

    /**
     * Calcula o valor a ser descontado do Saldo do Cliente no ato da Transferência baseada na quantia a ser transferida.
     * @param quantia Valor double a ser transferido.
     * @return Quantia double a ser descontada (não-inclusa a quantia a ser transferida).
     */
    default double calculaTaxaDeTransferência(double quantia) {
        return (quantia * getTaxaDeTransferência());
    }

    /**
     * Soma a Taxa de Transferência + a quantia a ser transferida e desconta do Saldo do Cliente.
     * @param saldo Saldo da conta do Cliente.
     * @param quantia Quantia a transferir.
     * @return Novo saldo.
     */
    default double descontaTaxaDeTransferência(double saldo, double quantia) {
        return (saldo - (quantia + calculaTaxaDeTransferência(quantia)));
    }
}
