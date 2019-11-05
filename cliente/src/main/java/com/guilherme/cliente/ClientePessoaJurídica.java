package com.guilherme.cliente;

import com.guilherme.conta.contacorrente.ContaCorrente;
import com.guilherme.conta.contapoupança.ContaPoupança;
import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ClientePessoaJurídica implements Cliente, Comparable<ClientePessoaJurídica> {

    /* Atributos */
    private PessoaJurídica pessoaJurídica;
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
    public ClientePessoaJurídica() {
        super();
        this.setPessoaJurídica( new PessoaJurídica() );
    }

    // Construtor completo
    public ClientePessoaJurídica( PessoaJurídica pessoaJurídica ) {
        super();
        this.setPessoaJurídica( pessoaJurídica );
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public PessoaJurídica getPessoaJurídica() {
        return pessoaJurídica;
    }

    public void setPessoaJurídica(PessoaJurídica pessoaJurídica) {
        this.pessoaJurídica = Objects.requireNonNullElse(pessoaJurídica, new PessoaJurídica());
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
        return getListaDeContasCorrente().add( new ContaCorrente( getPessoaJurídica(), depósitoInicial, 400 ) );
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
        return getListaDeContasPoupança().add( new ContaPoupança( getPessoaJurídica(), depósitoInicial, new Date() ) );
    }


    /* ----------------------- */
    /* .::Equals e Hashcode::. */
    /* ----------------------- */
    // Principalmente utilizado como parâmetro de remoção de duplicatas em mapas e/ou conjuntos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientePessoaJurídica that = (ClientePessoaJurídica) o;

        return getPessoaJurídica().equals(that.getPessoaJurídica());
    }

    @Override
    public int hashCode() {
        return getPessoaJurídica().hashCode();
    }


    /* ---------------- */
    /* .::Comparador::. */
    /* ---------------- */
    // Principalmente utilizado como parâmetro de ordenação em árvores de mapas e/ou de conjuntos.

    @Override
    public int compareTo(ClientePessoaJurídica outraPessoaJurídica) {
        return this.getPessoaJurídica().getNomeFantasia().compareTo(outraPessoaJurídica.getPessoaJurídica().getNomeFantasia());
    }

}
