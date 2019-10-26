package com.guilherme.pessoa.pessoajurídica;

import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.Pessoa;

public class PessoaJurídica extends Pessoa {

    private String CNPj;
    private String nomeFantasia;
    private String razãoSocial;

    public PessoaJurídica(Endereço endereço, String telefone, // <- Pessoa
                          String CNPj, String nomeFantasia, String razãoSocial) {

        super(endereço, telefone);

        this.CNPj = CNPj;
        this.nomeFantasia = nomeFantasia;
        this.razãoSocial = razãoSocial;
    }

    public String getCNPj() {
        return CNPj;
    }

    public void setCNPj(String CNPj) {
        this.CNPj = CNPj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazãoSocial() {
        return razãoSocial;
    }

    public void setRazãoSocial(String razãoSocial) {
        this.razãoSocial = razãoSocial;
    }
}
