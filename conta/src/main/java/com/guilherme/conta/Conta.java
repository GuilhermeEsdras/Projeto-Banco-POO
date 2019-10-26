package com.guilherme.conta;

import com.guilherme.conta.exceptions.*;
import com.guilherme.conta.services.*;
import com.guilherme.pessoa.Pessoa;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Conta implements ServiçoDeSaque, ServiçoDeTransferência, ServiçoDeExtrato {

    /* Atributos principais de uma Conta */
    private Pessoa titular;
    private int número;
    private double saldo;

    /* Mapa que armazena todas as transações e movimentações da conta
     onde a chave é a data da transação e o valor é uma lista de operações do tipo String */
    private Map<Date, LinkedList<String>> históricoDeMovimentação;

    /* Constante auxiliar para o número da conta */
    private static int ULTIMO_NUMERO = 111111;


    /* Taxas */
    private double taxaDeSaque;
    private double taxaDeTransferência;
    private double taxaDeExtrato;


    /* Construtores */
    {
        this.setNúmero(ULTIMO_NUMERO++);

        this.setHistóricoDeMovimentação(new LinkedHashMap<>());

        this.setTaxaDeSaque(1.0);
        this.setTaxaDeTransferência(1.0);
        this.setTaxaDeExtrato(1.0);
    }

    public Conta(Pessoa titular, double saldo) {
        this.setTitular(titular);
        this.setSaldo(saldo);
    }


    /* .::Getters e Setters de uma Conta::. */

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public int getNúmero() {
        return número;
    }

    public void setNúmero(int número) {
        this.número = número;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    /* .::Métodos referentes ao Serviço de Saque::. */

    @Override
    public double getTaxaDeSaque() {
        return taxaDeSaque;
    }

    public void setTaxaDeSaque(double taxaDeSaque) {
        this.taxaDeSaque = taxaDeSaque;
    }

    @Override
    public double sacar(double quantia) {
        if ( (quantia > 0) && ( this.getSaldo() > (quantia + calculaTaxaDeSaque(quantia)) ) ) {
            this.setSaldo( descontaSaque(this.getSaldo(), quantia) );


            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date dateWithoutTime = cal.getTime();


            return quantia;
        } else if (quantia == 0) {
            throw new IgualAZeroException();
        } else if (quantia < 0) {
            throw new QuantiaNegativaException();
        } else {
            throw new SaldoInsuficienteException();
        }
    }


    /* .::Métodos referentes ao Serviço de Transferência::. */

    @Override
    public double getTaxaDeTransferência() {
        return taxaDeTransferência;
    }

    public void setTaxaDeTransferência(double taxaDeTransferência) {
        this.taxaDeTransferência = taxaDeTransferência;
    }


    /* .::Métodos referentes ao Serviço de Extrato::. */

    public Map<Date, LinkedList<String>> getHistóricoDeMovimentação() {
        return históricoDeMovimentação;
    }

    public void setHistóricoDeMovimentação(Map<Date, LinkedList<String>> históricoDeMovimentação) {
        this.históricoDeMovimentação = históricoDeMovimentação;
    }

    @Override
    public double getTaxaDeExtrato() {
        return taxaDeExtrato;
    }

    public void setTaxaDeExtrato(double taxaDeExtrato) {
        this.taxaDeExtrato = taxaDeExtrato;
    }

    @Override
    public Map<Date, LinkedList<String>> getExtrato() {
        return getHistóricoDeMovimentação();
    }


    /* Métodos essenciais para listas do tipo Hash */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        return getNúmero() == conta.getNúmero();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getNúmero());
    }


    /* toString básico de uma Conta */

    @Override
    public String toString() {
        return "Conta{" +
                "titular=" + titular +
                ", número=" + número +
                ", saldo=" + saldo +
                '}';
    }
}
