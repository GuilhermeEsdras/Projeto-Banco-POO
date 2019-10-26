package com.guilherme.cliente;

// Outros módulos
import com.guilherme.conta.contacorrente.ContaCorrente;
import com.guilherme.conta.contapoupança.ContaPoupança;

// Java utils
import java.util.Set;
import java.util.TreeSet;

/**
 * <h1>Cliente</h1>
 * <p>Classe que representa um Cliente do Banco.</p>
 *
 * <p>Este Cliente pode possuir mais de uma Conta Corrente e Conta Poupança, por isso, são armazenados em listas
 * separadas.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public abstract class Cliente {

    private Set<ContaCorrente> listaDeContasCorrente;
    private Set<ContaPoupança> listaDeContasPoupança;

    {
        this.setListaDeContasCorrente(new TreeSet<>());
        this.setListaDeContasPoupança(new TreeSet<>());
    }

    public Set<ContaCorrente> getListaDeContasCorrente() {
        return listaDeContasCorrente;
    }

    public void setListaDeContasCorrente(Set<ContaCorrente> listaDeContasCorrente) {
        this.listaDeContasCorrente = listaDeContasCorrente;
    }

    public Set<ContaPoupança> getListaDeContasPoupança() {
        return listaDeContasPoupança;
    }

    public void setListaDeContasPoupança(Set<ContaPoupança> listaDeContasPoupança) {
        this.listaDeContasPoupança = listaDeContasPoupança;
    }

    /**
     * Cria uma nova Conta Corrente para o Cliente e armazena-a na lista de Contas Corrente do mesmo.
     * @param depósitoInicial: Quantia inicial de depósito para a conta.
     * @return Valor Booleano: True se der certo, False caso contrário.
     */
    public boolean abrirContaCorrente(double depósitoInicial) {
        return true;
    }

    /**
     * Cria uma nova Conta Poupança para o Cliente e armazena-a na lista de Contas Poupança do mesmo.
     * @param depósitoInicial: Quantia inicial de depósito para a conta.
     * @return Valor Booleano: True se der certo, False caso contrário.
     */
    public boolean abrirContaPoupança(double depósitoInicial) {
        return true;
    }
}
