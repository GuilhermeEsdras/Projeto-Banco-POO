package com.guilherme.cli.cadastro.telasdecadastro.cliente;

import com.guilherme.cli.Menu;
import com.guilherme.cli.cadastro.TelaDeCadastro;
import com.guilherme.cli.cadastro.telasdecadastro.sistemadecadastro.*;
import com.guilherme.cli.cadastro.telasdecadastro.cliente.enums.OpçõesMenuCadastroCliente;

public class MenuTelaDeCadastroDeCliente extends Menu {

    {
        setOpçõesDoMenu(OpçõesMenuCadastroCliente.class);
    }

    @Override
    public void executaOpção(int opção) {
        OpçõesMenuCadastroCliente opçõesMenuCadastroCliente = OpçõesMenuCadastroCliente.values()[opção];

        switch (opçõesMenuCadastroCliente) {
            case CADASTRO_CLIENTE_PESSOA_FISICA:
                if ( systemUtils.confirmar("Cadastro de Pessoa Física") ) {
                    CadastroDePessoaFísica cadastroDePessoaFísica = new CadastroDePessoaFísica();
                    cadastroDePessoaFísica.cadastra();
                } else {
                    TelaDeCadastroDeCliente telaDeCadastroDeCliente = new TelaDeCadastroDeCliente("Tela de Cadastro de Cliente");
                    telaDeCadastroDeCliente.exibirTela();
                }
                break;

            case CADASTRO_CLIENTE_PESSOA_JURIDICA:
                if ( systemUtils.confirmar("Cadastro de Pessoa Jurídica") ) {
                    CadastroDePessoaJurídica cadastroDePessoaJurídica = new CadastroDePessoaJurídica();
                    cadastroDePessoaJurídica.cadastra();
                } else {
                    TelaDeCadastroDeCliente telaDeCadastroDeCliente = new TelaDeCadastroDeCliente("Tela de Cadastro de Cliente");
                    telaDeCadastroDeCliente.exibirTela();
                }
                break;

            case VOLTAR:
                TelaDeCadastro telaDeCadastro = new TelaDeCadastro("Tela de Cadastro");
                telaDeCadastro.exibirTela();
                break;

            case SAIR:
                systemUtils.sair();
        }
    }

}
