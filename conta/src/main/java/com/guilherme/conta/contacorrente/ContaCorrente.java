package com.guilherme.conta.contacorrente;

import com.guilherme.conta.Conta;
import com.guilherme.conta.services.ServiçoDeEmpréstimo;
import com.guilherme.pessoa.Pessoa;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

public class ContaCorrente extends Conta implements ServiçoDeEmpréstimo {

    /* Atributos */
    private double limite;

    /* Taxas */
    private double taxaDeJuros;


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    { // Bloco de inicialização de instância
        this.setLimite( 1000D );
    }

    public ContaCorrente(Pessoa titular, double saldo, // <-- Conta
                         double limite)
    {
        super(titular, saldo);
        this.setLimite(limite);
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

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

    @Override
    public double pagamento(double quantia, int meses) {
        return 0;
    }
}
