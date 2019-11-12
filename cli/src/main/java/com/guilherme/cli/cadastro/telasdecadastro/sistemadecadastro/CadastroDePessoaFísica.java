package com.guilherme.cli.cadastro.telasdecadastro.sistemadecadastro;

public class CadastroDePessoaFísica extends SistemaDeCadastro {

    public void cadastraPessoaFísica() {
        System.out.println("Cadastrando pessoa física...");
        cadastraEndereço();
        cadastraTelefone();
    }

    @Override
    public void cadastra() {
        cadastraPessoaFísica();
    }
}
