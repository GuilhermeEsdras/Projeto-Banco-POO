package com.guilherme.funcionário.caixa;

import com.guilherme.funcionário.Funcionário;
import com.guilherme.pessoa.Endereço;

public class Caixa extends Funcionário {

    private int numHorasExtra;


    public Caixa(Endereço endereço, String telefone,
                 String CPF, String nome, String sobrenome, String dataDeNascimento,
                 double salárioBase) {
        super(endereço, telefone, CPF, nome, sobrenome, dataDeNascimento, salárioBase);
    }

    public int getNumHorasExtra() {
        return numHorasExtra;
    }

    public void setNumHorasExtra(int numHorasExtra) {
        this.numHorasExtra = numHorasExtra;
    }

}
