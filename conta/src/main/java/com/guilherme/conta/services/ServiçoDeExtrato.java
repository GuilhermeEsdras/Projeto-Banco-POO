package com.guilherme.conta.services;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

public interface ServiçoDeExtrato {

    double getTaxaDeExtrato();
    String getExtrato(int dias);

    default double descontaTaxaDeExtrato(double saldo) {
        return (saldo - getTaxaDeExtrato());
    }

}
