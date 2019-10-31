package com.guilherme.conta;

import com.guilherme.conta.exceptions.*;
import com.guilherme.conta.services.*;
import com.guilherme.pessoa.Pessoa;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Conta implements ServiçoDeSaque, ServiçoDeTransferência, ServiçoDeExtrato {

    /* Atributos */
    private Pessoa titular;
    private int    número;
    private double saldo;

    /**
     * Mapa que armazena todas as transações e movimentações da conta, onde:
     * Chave (key) é a data da operação em formato String,
     * Valor (value) é uma lista de operações do tipo String
     */
    private Map<String, List<String>> históricoDeMovimentação;


    /* Constantes */
    private static int ULTIMO_NUMERO = 111111; // Constante auxiliar para o número da conta


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

        this.setTaxaDeSaque(1.0);
        this.setTaxaDeTransferência(1.0);
        this.setTaxaDeExtrato(1.0);
    }

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

            Locale local = new Locale("pt", "BR");
            DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);

            Date dataAtual = Calendar.getInstance().getTime();
            String dataAtualFormatada = formatador.format(dataAtual);

            String descriçãoDaTransação = "Saque | No valor de: " + formatoMoeda.format(quantia);
            addMovimentação(dataAtualFormatada, descriçãoDaTransação);

            return quantia;
        } else if (quantia == 0) {
            throw new IgualAZeroException();
        } else if (quantia < 0) {
            throw new QuantiaNegativaException();
        } else {
            throw new SaldoInsuficienteException();
        }
    }


    /* ------------------------------ */
    /* .::Serviço de Transferência::. */
    /* ------------------------------ */

    @Override
    public double getTaxaDeTransferência() {
        return taxaDeTransferência;
    }

    public void setTaxaDeTransferência(double taxaDeTransferência) {
        this.taxaDeTransferência = taxaDeTransferência;
    }


    /* ------------------------ */
    /* .::Serviço de Extrato::. */
    /* ------------------------ */

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

        return "...";
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

        return getNúmero() == conta.getNúmero();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getNúmero());
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

    public void addMovimentação(String data, String movimentação) {
        List<String> movimentaçõesDoDia = getHistóricoDeMovimentação().get(data);

        if (movimentaçõesDoDia == null) {
            movimentaçõesDoDia = new LinkedList<>();
        }

        movimentaçõesDoDia.add(movimentação);
        getHistóricoDeMovimentação().put(data, movimentaçõesDoDia);
    }
}
