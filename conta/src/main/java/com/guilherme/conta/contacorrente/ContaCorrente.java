package com.guilherme.conta.contacorrente;

import com.guilherme.conta.Conta;
import com.guilherme.conta.services.ServiçoDeEmpréstimo;
import com.guilherme.pessoa.Pessoa;

import java.security.InvalidParameterException;

public class ContaCorrente extends Conta implements ServiçoDeEmpréstimo {

    private double limite;
    private double taxaDeJuros;

    public ContaCorrente(Pessoa titular, double saldo,
                         double limite)
    {
        super(titular, saldo);
        this.setLimite(limite);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public double getTaxaDeJuros() {
        return this.taxaDeJuros;
    }

    public void setTaxaDeJuros(double taxa) {
        this.taxaDeJuros = taxa;
    }

    @Override
    public double pegarEmpréstimo(double quantia, int meses) {
        if (quantia > 0) {
            setSaldo(getSaldo() + quantia);
            return pagamento(quantia, meses);
        } else {
            throw new InvalidParameterException("Quantia deve ser maior que zero!");
        }
    }
}
