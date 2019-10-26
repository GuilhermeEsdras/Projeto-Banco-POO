package com.guilherme.conta.contapoupança;

import com.guilherme.conta.Conta;
import com.guilherme.pessoa.Pessoa;

import java.util.Date;

public class ContaPoupança extends Conta {

    private Date aniversárioDeDepósito;

    public ContaPoupança(Pessoa titular, double saldo,
                         Date aniversárioDeDepósito)
    {
        super(titular, saldo);
        this.setAniversárioDeDepósito(aniversárioDeDepósito);
    }

    public Date getAniversárioDeDepósito() {
        return aniversárioDeDepósito;
    }

    public void setAniversárioDeDepósito(Date aniversárioDeDepósito) {
        this.aniversárioDeDepósito = aniversárioDeDepósito;
    }
}
