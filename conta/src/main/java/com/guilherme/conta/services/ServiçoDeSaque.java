package com.guilherme.conta.services;

public interface ServiçoDeSaque {

    double getTaxaDeSaque();
    double sacar(double quantia);

    default double calculaTaxaDeSaque(double quantia) {
        return (quantia * getTaxaDeSaque());
    }

    default double descontaTaxaDeSaque(double saldo, double quantia) {
        return (saldo - (quantia + calculaTaxaDeSaque(quantia)));
    }
}
