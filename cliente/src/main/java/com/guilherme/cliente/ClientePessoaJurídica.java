package com.guilherme.cliente;

import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

import java.util.Objects;

public class ClientePessoaJurídica extends Cliente implements Comparable<ClientePessoaJurídica> {

    /* Atributos */
    private PessoaJurídica pessoaJurídica;


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

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
