package com.guilherme.cliente;

import com.guilherme.pessoa.pessoafísica.PessoaFísica;

import java.util.Objects;

public class ClientePessoaFísica extends Cliente implements Comparable<ClientePessoaFísica> {

    /* Atributos */
    private PessoaFísica pessoaFísica;


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

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
