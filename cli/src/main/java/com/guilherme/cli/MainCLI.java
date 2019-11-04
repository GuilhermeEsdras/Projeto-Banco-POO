package com.guilherme.cli;

import com.guilherme.cli.login.TelaDeLogin;
import com.guilherme.cli.welcome.BoasVindas;
import com.guilherme.console.utils.PrintUtils;


public class MainCLI {
    public static void main(String[] args)
    {

        PrintUtils printUtils = new PrintUtils();

        BoasVindas boasVindas = new BoasVindas();
        boasVindas.printBoasVindas(0);

        printUtils.printaDiv("-", 87);

        TelaDeLogin telaDeLogin = new TelaDeLogin();
        telaDeLogin.exibirTelaDeLogin();

    }
}
