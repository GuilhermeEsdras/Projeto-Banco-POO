package com.guilherme.cli;

import com.guilherme.cli.login.TelaDeLogin;
import com.guilherme.cli.welcome.BoasVindas;

public class Main {
    public static void main(String[] args)
    {
        BoasVindas boasVindas = new BoasVindas();
        boasVindas.printBoasVindas();

        TelaDeLogin telaDeLogin = new TelaDeLogin();
    }
}
