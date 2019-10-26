package com.guilherme.funcionário.gerente;

import com.guilherme.funcionário.Funcionário;
import com.guilherme.pessoa.Endereço;

import java.util.Date;

public class Gerente extends Funcionário {
    public Gerente(Endereço endereço, String telefone,
                   String CPF, String nome, String sobrenome, Date dataDeNascimento,
                   double salárioBase) {
        super(endereço, telefone, CPF, nome, sobrenome, dataDeNascimento, salárioBase);
    }
}
