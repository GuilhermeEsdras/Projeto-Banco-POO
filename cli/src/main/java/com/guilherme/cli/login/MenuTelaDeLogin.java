package com.guilherme.cli.login;

import com.guilherme.cli.Menu;
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
                System.out.println("Cadastrando...");
                break;

            case RECUPERAR_SENHA:
                System.out.println("Recuperando senha...");
                break;

            case SAIR:
                System.out.println("Saindo...");
                System.exit(0);
        }
    }

}
