package com.guilherme.conta;

import com.guilherme.conta.exceptions.*;
import com.guilherme.conta.services.*;
import com.guilherme.pessoa.Pessoa;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Conta implements Comparable<Conta>, ServiçoDeSaque, ServiçoDeDepósito, ServiçoDeTransferência, ServiçoDeExtrato {

    /* Atributos */
    private Pessoa titular;
    private String número;
    private double saldo;

    /**
     * Mapa que armazena todas as transações e movimentações da conta, onde:
     * Chave (key) é a data da operação em formato String,
     * Valor (value) é uma lista de operações do tipo String
     */
    private Map<String, List<String>> históricoDeMovimentação;

    /* Atributos default */
    static final double SALDO_INICIAL = 100;


    /* Atributos auxiliares */
    private Locale local = new Locale("pt", "BR");
    private NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);
    private DateFormat formatadorDeData = new SimpleDateFormat("dd/MM/yyyy");


    /* Constantes */
    static int ULTIMO_NUMERO = 123456; // Constante auxiliar para o número da conta


    /* Taxas */
    private double taxaDeSaque;
    private double taxaDeTransferência;
    private double taxaDeExtrato;


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    { // Bloco de inicialização de instância
        this.setNúmero(ULTIMO_NUMERO++);

        this.setHistóricoDeMovimentação(new LinkedHashMap<>());

        // Taxas
        this.setTaxaDeSaque         ( 0.01 ); // Desconta 1.0% do valor do Saque no Saldo do Cliente
        this.setTaxaDeTransferência ( 0.02 ); // Desconta 2.0% do valor da Transferência no Saldo do Cliente
        this.setTaxaDeExtrato       ( 0.50 ); // Desconta R$ 0,25 por Extrato no Saldo do Cliente
    }

    // Construtor apenas com titular
    public Conta(Pessoa titular) {
        this.setTitular( titular );
        this.setSaldo( SALDO_INICIAL );
    }

    // Construtor completo
    public Conta(Pessoa titular, double saldo) {
        this.setTitular(titular);
        this.setSaldo(saldo);
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public String getNúmero() {
        return número;
    }

    public void setNúmero(int número) {
        this.número = String.valueOf(número);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo > 0) {
            this.saldo = saldo;
        }
    }


    /* ---------------------- */
    /* .::Serviço de Saque::. */
    /* ---------------------- */

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
            this.setSaldo( descontaTaxaDeSaque(this.getSaldo(), quantia) );
            addMovimentação( "Saque | No valor de " + formatoMoeda.format(quantia) );
            return quantia;
        } else if (quantia == 0) {
            throw new IgualAZeroException();
        } else if (quantia < 0) {
            throw new QuantiaNegativaException();
        } else {
            throw new SaldoInsuficienteException();
        }
    }


    /* ------------------------- */
    /* .::Serviço de Depósito::. */
    /* ------------------------- */

    @Override
    public void depositar(double quantia) {
        if (quantia > 0) {
            this.setSaldo(getSaldo() + quantia);
            addMovimentação( "Depósito | No valor de " + formatoMoeda.format(quantia) );
        }
    }


    /* ------------------------------ */
    /* .::Serviço de Transferência::. */
    /* ------------------------------ */
    // Invativo por enquanto...

    @Override
    public double getTaxaDeTransferência() {
        return taxaDeTransferência;
    }

    public void setTaxaDeTransferência(double taxaDeTransferência) {
        this.taxaDeTransferência = taxaDeTransferência;
    }

    @Override
    public double transferir(double quantia, int número) {


        addMovimentação( "Transferência para Conta " + " | No valor de " + formatoMoeda.format(quantia) );
        return quantia;
    }


    /* ------------------------ */
    /* .::Serviço de Extrato::. */
    /* ------------------------ */
    // Invativo por enquanto...

    public Map<String, List<String>> getHistóricoDeMovimentação() {
        return históricoDeMovimentação;
    }

    public void setHistóricoDeMovimentação(Map<String, List<String>> históricoDeMovimentação) {
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
    public String getExtrato(int dias) {
        if (this.getSaldo() > getTaxaDeExtrato()) {

            return "...";
        } else {
            throw new SaldoInsuficienteException();
        }

    }


    /* ----------------------- */
    /* .::Equals e Hashcode::. */
    /* ----------------------- */
    // Principalmente utilizado como parâmetro de remoção de duplicatas em mapas e/ou conjuntos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        return getNúmero().equals(conta.getNúmero());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNúmero());
    }


    /* ---------------- */
    /* .::Comparador::. */
    /* ---------------- */
    // Principalmente utilizado como parâmetro de ordenação em árvores de mapas e/ou de conjuntos.

    @Override
    public int compareTo(Conta outraConta) {
        return getNúmero().compareTo(outraConta.getNúmero());
    }


    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.

    @Override
    public String toString() {
        return "Conta{" +
                "titular=" + titular +
                ", número=" + número +
                ", saldo=" + saldo +
                '}';
    }


    /* ------------------------ */
    /* .::Métodos auxiliares::. */
    /* ------------------------ */

    /**
     * <h1>Add Movimentação</h1>
     *
     * <p>Acrescenta uma movimentação em uma data no Histórico de Movimentação da Conta.</p>
     *
     * @param movimentação Descrição da movimentação.
     */
    private void addMovimentação(String movimentação) {
        String data = formatadorDeData.format(Calendar.getInstance().getTime());
        List<String> movimentaçõesDoDia = getHistóricoDeMovimentação().get(data);

        if (movimentaçõesDoDia == null) {
            movimentaçõesDoDia = new LinkedList<>();
        }

        movimentaçõesDoDia.add(movimentação);
        getHistóricoDeMovimentação().put(data, movimentaçõesDoDia);
    }
}
