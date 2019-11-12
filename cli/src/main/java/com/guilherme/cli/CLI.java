package com.guilherme.cli;

import com.guilherme.cli.login.TelaDeLogin;
import com.guilherme.cli.welcome.BoasVindas;
import com.guilherme.console.utils.PrintUtils;

public class CLI {

    public void runCLI() {
        PrintUtils printUtils = new PrintUtils();

        BoasVindas boasVindas = new BoasVindas();
        boasVindas.printBoasVindas(0);

        printUtils.printaDiv("-", 87);

        TelaDeLogin telaDeLogin = new TelaDeLogin("Tela de Login");
        telaDeLogin.exibirTela();
    }

}
