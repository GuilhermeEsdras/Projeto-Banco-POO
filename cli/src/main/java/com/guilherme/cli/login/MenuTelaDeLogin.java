package com.guilherme.cli.login;

import com.guilherme.cli.Tela;
import com.guilherme.cli.exceptions.OpçãoInválidaException;
import com.guilherme.cli.login.enums.OpçõesMenuLogin;

import java.util.EnumSet;

public class MenuTelaDeLogin extends Tela {

    public void exibirMenuTelaDeLogin() {
        System.out.print("  O que deseja fazer?");

        EnumSet.allOf(OpçõesMenuLogin.class).forEach(
                OpçõesMenuLogin -> System.out.print(
                        "\n\t" +
                                (OpçõesMenuLogin.ordinal() +1) +
                                ". " +
                                OpçõesMenuLogin.toString()
                )
        );

        System.out.print("\n\t Digite sua opção: ");
    }

    public void capturaOpçõesMenuTelaDeLogin(int opção) {
        OpçõesMenuLogin opçãoMenuLogin = OpçõesMenuLogin.values()[opção];

        switch (opçãoMenuLogin) {
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
