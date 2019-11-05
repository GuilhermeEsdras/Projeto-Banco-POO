package com.guilherme.cliente;

// Outros módulos
import com.guilherme.conta.contacorrente.ContaCorrente;
import com.guilherme.conta.contapoupança.ContaPoupança;

// Java utils
import java.util.Set;
import java.util.TreeSet;

/**
 * <h1>Cliente</h1>
 * <p>Interface que representa um Cliente do Banco.</p>
 *
 * @since 2.0
 * @author Guilherme Esdras
 * @version 2.0
 */
public interface Cliente {

    Set<ContaCorrente> getListaDeContasCorrente();
    void setListaDeContasCorrente(Set<ContaCorrente> listaDeContasCorrente);

    Set<ContaPoupança> getListaDeContasPoupança();
    void setListaDeContasPoupança(Set<ContaPoupança> listaDeContasPoupança);

    /**
     * Cria uma nova Conta Corrente para o Cliente e armazena-a na lista de Contas Corrente do mesmo.
     * @param depósitoInicial: Quantia inicial de depósito para a conta.
     * @return Valor Booleano: True se der certo, False caso contrário.
     */
    boolean abrirContaCorrente(double depósitoInicial);

    default boolean removerContaCorrente(String número) {
        return getListaDeContasCorrente().removeIf( contaCorrente -> contaCorrente.getNúmero().equals(número) );
    }

    /**
     * Cria uma nova Conta Poupança para o Cliente e armazena-a na lista de Contas Poupança do mesmo.
     * @param depósitoInicial: Quantia inicial de depósito para a conta.
     * @return Valor Booleano: True se der certo, False caso contrário.
     */
    boolean abrirContaPoupança(double depósitoInicial);

    default boolean removerContaPoupança(String número) {
        return getListaDeContasPoupança().removeIf( contaPoupança -> contaPoupança.getNúmero().equals( número ));
    }
}
