package com.guilherme.cliente;

import com.guilherme.pessoa.pessoafísica.PessoaFísica;

public class ClientePessoaFísica extends Cliente implements Comparable<ClientePessoaFísica> {

    private PessoaFísica clientePessoaFísica;

    public PessoaFísica getClientePessoaFísica() {
        return clientePessoaFísica;
    }

    public void setClientePessoaFísica(PessoaFísica clientePessoaFísica) {
        this.clientePessoaFísica = clientePessoaFísica;
    }

    @Override
    public int compareTo(ClientePessoaFísica outraPessoaFísica) {
        return getClientePessoaFísica().getCPF().compareTo(outraPessoaFísica.getClientePessoaFísica().getCPF());
    }
}
