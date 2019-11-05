package com.guilherme.cliente;

import com.guilherme.conta.contacorrente.ContaCorrente;
import com.guilherme.conta.contapoupança.ContaPoupança;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;

import java.util.*;

public class ClientePessoaFísica implements Cliente, Comparable<ClientePessoaFísica> {

    /* Atributos */
    private PessoaFísica pessoaFísica;
    private Set<ContaCorrente> listaDeContasCorrente;
    private Set<ContaPoupança> listaDeContasPoupança;


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    {
        this.setListaDeContasCorrente(new TreeSet<>());
        this.setListaDeContasPoupança(new TreeSet<>());
    }

    // Construtor vazio
    public ClientePessoaFísica() {
        super();
        this.setPessoaFísica( new PessoaFísica() );
    }

    // Construtor completo
    public ClientePessoaFísica( PessoaFísica pessoaFísica ) {
        super();
        this.setPessoaFísica(pessoaFísica);
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public PessoaFísica getPessoaFísica() {
        return pessoaFísica;
    }

    public void setPessoaFísica(PessoaFísica pessoaFísica) {
        this.pessoaFísica = Objects.requireNonNullElse(pessoaFísica, new PessoaFísica());
    }


    /* ------------------------------------- */
    /* .:: Manipulação de Contas Corrente::. */
    /* ------------------------------------- */

    @Override
    public Set<ContaCorrente> getListaDeContasCorrente() {
        return this.listaDeContasCorrente;
    }

    @Override
    public void setListaDeContasCorrente(Set<ContaCorrente> listaDeContasCorrente) {
        this.listaDeContasCorrente = listaDeContasCorrente;
    }

    @Override
    public boolean abrirContaCorrente(double depósitoInicial) {
        return getListaDeContasCorrente().add( new ContaCorrente( getPessoaFísica(), depósitoInicial, 400 ) );
    }


    /* ------------------------------------- */
    /* .:: Manipulação de Contas Poupança::. */
    /* ------------------------------------- */

    @Override
    public Set<ContaPoupança> getListaDeContasPoupança() {
        return this.listaDeContasPoupança;
    }

    @Override
    public void setListaDeContasPoupança(Set<ContaPoupança> listaDeContasPoupança) {
        this.listaDeContasPoupança = listaDeContasPoupança;
    }

    @Override
    public boolean abrirContaPoupança(double depósitoInicial) {
        return getListaDeContasPoupança().add( new ContaPoupança( getPessoaFísica(), depósitoInicial, new Date() ) );
    }


    /* ----------------------- */
    /* .::Equals e Hashcode::. */
    /* ----------------------- */
    // Principalmente utilizado como parâmetro de remoção de duplicatas em mapas e/ou conjuntos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientePessoaFísica that = (ClientePessoaFísica) o;

        return getPessoaFísica().equals(that.getPessoaFísica());
    }

    @Override
    public int hashCode() {
        return getPessoaFísica().hashCode();
    }


    /* ---------------- */
    /* .::Comparador::. */
    /* ---------------- */
    // Principalmente utilizado como parâmetro de ordenação em árvores de mapas e/ou de conjuntos.

    @Override
    public int compareTo(ClientePessoaFísica outraPessoaFísica) {
        return getPessoaFísica().getNome().compareTo(outraPessoaFísica.getPessoaFísica().getNome());
    }
}
