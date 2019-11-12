package com.guilherme.cli.cadastro;

import com.guilherme.cli.Menu;
import com.guilherme.cli.cadastro.enums.OpçõesMenuCadastro;
import com.guilherme.cli.cadastro.telasdecadastro.cliente.TelaDeCadastroDeCliente;
import com.guilherme.cli.login.TelaDeLogin;


public class MenuTelaDeCadastro extends Menu {

    {
        setOpçõesDoMenu(OpçõesMenuCadastro.class);
    }

    @Override
    public void executaOpção(int opção) {
        OpçõesMenuCadastro opçõesMenuCadastro = OpçõesMenuCadastro.values()[opção];

        switch (opçõesMenuCadastro) {

            case CADASTRAR_AGENCIA:
                printUtils.printaDiv("-", 5);
                systemUtils.carregar("Tela de Cadastro de Agência", 1);
                break;

            case CADASTRAR_BANCO:
                printUtils.printaDiv("-", 5);
                systemUtils.carregar("Tela de Cadastro de Banco", 1);
                break;

            case CADASTRAR_CLIENTE:
                printUtils.printaDiv("-", 5);
                systemUtils.carregar("Tela de Cadastro de Cliente", 1);
                TelaDeCadastroDeCliente telaDeCadastroDeCliente = new TelaDeCadastroDeCliente("Tela de Cadastro de Cliente");
                telaDeCadastroDeCliente.exibirTela();
                break;

            case CADASTRAR_FUNCIONARIO:
                printUtils.printaDiv("-", 5);
                systemUtils.carregar("Tela de Cadastro de Funcionário", 1);
                break;

            case VOLTAR:
                TelaDeLogin telaDeLogin = new TelaDeLogin("Tela de Login");
                telaDeLogin.exibirTela();
                break;

            case SAIR:
                printUtils.printaDiv("-", 5);
                systemUtils.sair();
        }
    }
}
