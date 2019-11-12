package com.guilherme.cli.cadastro.telasdecadastro.sistemadecadastro;

public abstract class SistemaDeCadastro {

    public abstract void cadastra();

    public void cadastraEndereço() {
        System.out.println("Cadastrando endereço...");
    }

    public void cadastraTelefone() {
        System.out.println("Cadastrando telefone...");
    }

}
