package com.guilherme.conta.services;

import java.security.InvalidParameterException;

/**
 * <h1>Serviço de Empréstimo</h1>
 *
 * <p>Interface responsável por calcular as taxas, cobranças e demais métodos ligados ao Serviço de Empréstimo do Banco.</p>
 *
 * <p>Apenas Contas Correntes podem realizar Empréstimo.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public interface ServiçoDeEmpréstimo {

    double getTaxaDeJuros();
    double pegarEmpréstimo(double quantia, int meses);

    /**
     * Calcula o valor a ser pago com juros para cobrir o empréstimo.
     *
     * Cálculo realizado:
     *      Pagamento = empréstimo * (1 + (TaxaDeJuros / 100))^n  (n = quantidade de meses)
     *
     * @param quantia Valor do empréstimo.
     * @param meses Quantidade de meses pretendida para pagar o empréstimo.
     * @return Quantia total a ser paga após os meses com juros.
     */
    default double pagamento(double quantia, int meses) {
        if (meses < 1) {
            throw new InvalidParameterException("A quantidade de meses deve ser maior que zero!");
        }
        return quantia * Math.pow(1.0 + (getTaxaDeJuros() / 100.0), meses);
    }
}
