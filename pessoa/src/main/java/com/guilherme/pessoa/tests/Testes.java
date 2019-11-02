package com.guilherme.pessoa.tests;

import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

public class Testes {
    public static void main(String[] args) {
        PessoaJurídica pessoaJurídica = new PessoaJurídica();

        pessoaJurídica.setTelefone( "83987425691" );
        System.out.println(pessoaJurídica.getTelefone());
    }
}
