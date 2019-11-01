package com.guilherme.conta.services;

/**
 * <h1>Serviço de Saque</h1>
 *
 * <p>Interface responsável por calcular as taxas, cobranças e demais métodos ligados ao Serviço de Saque do Banco.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public interface ServiçoDeSaque {

    double getTaxaDeSaque();
    double sacar(double quantia);

    /**
     * Calcula o valor a ser descontado do Saldo do Cliente no ato do Saque baseada na quantia a ser sacada.
     * @param quantia Valor double a ser sacado.
     * @return Quantia double a ser descontada (não-inclusa a quantia a ser sacada).
     */
    default double calculaTaxaDeSaque(double quantia) {
        return (quantia * getTaxaDeSaque());
    }

    /**
     * É descontada uma taxa apenas para saques acima de R$ 10,00.
     * Soma a Taxa de Saque + a quantia a ser sacada e desconta do Saldo do Cliente.
     * @param saldo Saldo da conta do Cliente.
     * @param quantia Quantia a sacar.
     * @return Novo saldo.
     */
    default double descontaTaxaDeSaque(double saldo, double quantia) {
        if (quantia > 10D) {
            return (saldo - (quantia + calculaTaxaDeSaque(quantia)));
        } else {
            return (saldo - quantia);
        }
    }
}
