package com.guilherme.cli.login;

import com.guilherme.cli.Menu;
import com.guilherme.cli.cadastro.TelaDeCadastro;
import com.guilherme.cli.login.enums.OpçõesMenuLogin;


public class MenuTelaDeLogin extends Menu {

    {
        setOpçõesDoMenu(OpçõesMenuLogin.class);
    }

    @Override
    public void executaOpção(int opção) {
        OpçõesMenuLogin opçõesMenuLogin = OpçõesMenuLogin.values()[opção];

        switch (opçõesMenuLogin) {
            case FAZER_LOGIN:
                TelaDeAutenticação telaDeAutenticação = new TelaDeAutenticação();
                telaDeAutenticação.autentica();
                break;

            case CADASTRAR:
                String tituloCadastrar = "Tela de Cadastro";
                printUtils.printaDiv("-", 5);
                systemUtils.carregar(tituloCadastrar, 1);
                TelaDeCadastro telaDeCadastro = new TelaDeCadastro(tituloCadastrar);
                telaDeCadastro.exibirTela();
                break;

            case RECUPERAR_SENHA:
                System.out.println("Recuperando senha...");
                break;

            case SAIR:
                printUtils.printaDiv("-", 5);
                systemUtils.sair();
        }
    }

}
