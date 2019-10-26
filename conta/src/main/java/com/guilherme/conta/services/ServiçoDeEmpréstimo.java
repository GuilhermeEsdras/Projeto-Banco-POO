package com.guilherme.conta.services;

import java.security.InvalidParameterException;

public interface ServiçoDeEmpréstimo {

    double getTaxaDeJuros();
    double pegarEmpréstimo(double quantia, int meses);

    default double pagamento(double quantia, int meses) {
        if (meses < 1) {
            throw new InvalidParameterException("A quantidade de meses deve ser maior que zero!");
        }
        return quantia * Math.pow(1.0 + getTaxaDeJuros() / 100.0, quantia);
    }
}
