package com.guilherme.cli.cadastro.telasdecadastro.cliente;

import com.guilherme.cli.Tela;

public class TelaDeCadastroDeCliente extends Tela {

    public TelaDeCadastroDeCliente(String titulo) {
        super(titulo);
    }

    @Override
    public void exibirTela() {
        MenuTelaDeCadastroDeCliente menuTelaDeCadastroDeCliente = new MenuTelaDeCadastroDeCliente();
        menuTelaDeCadastroDeCliente.exibirMenu("Qual tipo de cliente deseja cadastrar?", "Digite a opção: ");
        menuTelaDeCadastroDeCliente.capturaOpção();
        menuTelaDeCadastroDeCliente.executa();
    }
}
