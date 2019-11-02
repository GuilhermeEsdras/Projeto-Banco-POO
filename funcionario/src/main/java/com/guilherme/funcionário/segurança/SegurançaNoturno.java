package com.guilherme.funcionário.segurança;

import com.guilherme.funcionário.FuncionárioNoturno;
import com.guilherme.pessoa.Endereço;

import java.util.Date;

public class SegurançaNoturno extends Segurança implements FuncionárioNoturno {
    public SegurançaNoturno(Endereço endereço, String telefone,
                            String CPF, String nome, String sobrenome, String dataDeNascimento,
                            int ID, double salárioBase) {
        super(endereço, telefone, CPF, nome, sobrenome, dataDeNascimento, ID, salárioBase);
    }
}
