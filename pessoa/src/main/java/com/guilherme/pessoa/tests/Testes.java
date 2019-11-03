package com.guilherme.pessoa.tests;

import com.guilherme.console.utils.PrintUtils;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;
import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

public class Testes {
    public static void main(String[] args) {

        PrintUtils printUtils = new PrintUtils();

        Endereço endereço = new Endereço(
                "Rua Tal de Tal",
                33,
                "Centro",
                "João Pessoa",
                "PB"
        );

        System.out.println(endereço);

        printUtils.printaDivLn("-", 5);

        endereço.setComplemento("Um complemento qualquer bem grande...");

        System.out.println(endereço);

        printUtils.printaDivLn("-", 5);

        PessoaFísica pessoaFísica = new PessoaFísica();

        System.out.println(pessoaFísica);
    }
}
