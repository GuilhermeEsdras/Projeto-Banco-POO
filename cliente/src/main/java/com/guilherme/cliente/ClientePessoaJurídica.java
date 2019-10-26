package com.guilherme.cliente;

import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

public class ClientePessoaJurídica extends Cliente implements Comparable<ClientePessoaJurídica> {

    private PessoaJurídica clientePessoaJurídica;

    public PessoaJurídica getClientePessoaJurídica() {
        return clientePessoaJurídica;
    }

    public void setClientePessoaJurídica(PessoaJurídica clientePessoaJurídica) {
        this.clientePessoaJurídica = clientePessoaJurídica;
    }

    @Override
    public int compareTo(ClientePessoaJurídica outraPessoaJurídica) {
        return this.getClientePessoaJurídica().getCNPj().compareTo(outraPessoaJurídica.getClientePessoaJurídica().getCNPj());
    }
}
