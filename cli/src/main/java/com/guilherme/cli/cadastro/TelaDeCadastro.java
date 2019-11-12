package com.guilherme.cli.cadastro;

import com.guilherme.cli.Tela;

public class TelaDeCadastro extends Tela {

    public TelaDeCadastro(String titulo) {
        super(titulo);
    }

    @Override
    public void exibirTela() {
        MenuTelaDeCadastro menuTelaDeCadastro = new MenuTelaDeCadastro();
        menuTelaDeCadastro.exibirMenu("Qual tipo de usuário deseja cadastrar?", "Digite a opção: ");
        menuTelaDeCadastro.capturaOpção();
        menuTelaDeCadastro.executa();
    }

}
