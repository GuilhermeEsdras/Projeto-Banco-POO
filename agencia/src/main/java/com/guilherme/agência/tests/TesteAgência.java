package com.guilherme.agência.tests;

import com.guilherme.agência.Agência;
import com.guilherme.cliente.ClientePessoaFísica;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;

public class TesteAgência {
    public static void main(String[] args) {
        Agência agência = new Agência();
        System.out.println( agência );

        ClientePessoaFísica clientePessoaFísica = new ClientePessoaFísica( new PessoaFísica( "12345678910" ));
        System.out.println( clientePessoaFísica.getPessoaFísica() );

        agência.cadastrarClientePessoaFísica( clientePessoaFísica );
        System.out.println(agência.getQuantidadeDeClientesPessoaFísica());

        agência.removerClientePessoaFísica( clientePessoaFísica );
        System.out.println( agência.getQuantidadeDeClientesPessoaFísica() );
    }
}
