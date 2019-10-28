package com.guilherme.funcionário.caixa;

import com.guilherme.funcionário.Funcionário;
import com.guilherme.pessoa.Endereço;

public class Caixa extends Funcionário {

    private int numHorasExtra;


    public Caixa() {
        super();
        this.setNumHorasExtra(0);
    }

    public Caixa(Endereço endereço, String telefone, // Construtor Pessoa
                 String CPF, String nome, String sobrenome, String dataDeNascimento, // Construtor PessoaFísica
                 double salárioBase, // Construtor Funcionário
                 int numHorasExtra) {
        super(endereço, telefone, CPF, nome, sobrenome, dataDeNascimento, salárioBase);
        this.setNumHorasExtra(numHorasExtra);
    }


    public int getNumHorasExtra() {
        return numHorasExtra;
    }

    public void setNumHorasExtra(int numHorasExtra) {
        this.numHorasExtra = numHorasExtra;
    }

    @Override
    public double getSalárioBase() {
        return super.getSalárioBase() + (4.20 * this.getNumHorasExtra());
    }

}
