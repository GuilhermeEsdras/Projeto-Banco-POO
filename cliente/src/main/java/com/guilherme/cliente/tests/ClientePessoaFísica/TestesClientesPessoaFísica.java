package com.guilherme.cliente.tests.ClientePessoaFísica;

import com.guilherme.cliente.Cliente;
import com.guilherme.cliente.ClientePessoaFísica;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;

public class TestesClientesPessoaFísica {
    public static void main(String[] args) {

        /*
         * Informações geradas automatica e aleatoriamente usando:
         * https://www.invertexto.com/gerador-de-pessoas
         * https://www.4devs.com.br/gerador_de_pessoas
         */

        ClientePessoaFísica cpf1 = new ClientePessoaFísica(
                new PessoaFísica(
                        "laracavalcanticardoso@rhyta.com", "Bily1992", "Ookee1Ae",
                        new Endereço(
                                "Avenida Nilson Gottlieb", 83, "Centro", "Foz do Iguaçu", "PR"
                        ),
                        "45970163704",
                        "66816924789",
                        "Lara",
                        "Cardoso",
                        "20/09/1992"
                )
        );

        ClientePessoaFísica cpf2 = new ClientePessoaFísica(
                new PessoaFísica(
                        "ianjosemurilocardoso_@solutionimoveis.com", "ianjosemurilo", "0D9WQm81Yf",
                        new Endereço(
                                "Rua Maria Aurora", 778, "Cidade Universitária Pedra Branca", "Palhoça", "SC"
                        ),
                        "48997228797",
                        "02526657598",
                        "Ian",
                        "José Murilo Cardoso",
                        "14/08/1992"
                )
        );

        ClientePessoaFísica cpf3 = new ClientePessoaFísica(
                new PessoaFísica(
                        "antonellatatianeferreira@jcoronel.com", "antonella", "5W6LG124AJ",
                        new Endereço(
                                "Rua José Lopes de Carvalho", 545, "Antares", "Maceió", "AL"
                        ),
                        "82991286310",
                        "29279671219",
                        "Antonella",
                        "Tatiane Ferreira",
                        "03/05/1964"
                )
        );


        /*
         * TODO:
         *  - e-mail aceitar .com.br
         *  - telefone sem "9" no começo e aceitando qualquer formatação (usar pattern)
         *  - add RG
         */
    }
}
