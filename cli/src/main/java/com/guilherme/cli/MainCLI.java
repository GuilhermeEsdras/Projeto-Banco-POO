package com.guilherme.cli;

import com.guilherme.cli.welcome.BoasVindas;
import com.guilherme.console.utils.PrintUtils;


public class MainCLI {
    public static void main(String[] args)
    {

        PrintUtils printUtils = new PrintUtils();

        BoasVindas boasVindas = new BoasVindas();
        boasVindas.printBoasVindas();

        printUtils.printaLn();
        printUtils.printaDiv("-", 50);

    }
}
