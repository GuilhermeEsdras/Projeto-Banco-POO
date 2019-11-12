package com.guilherme.main;

import com.guilherme.cli.CLI;
import com.guilherme.gui.GUI;

public class Main {
    public static void main(String[] args) {

        if (args[0].equals("-CLI")) {
            CLI cli = new CLI();
            cli.runCLI();
        } else if (args[0].equals("-GUI")) {
            GUI gui = new GUI();
            gui.runGUI();
        } else {
            System.out.println("Bem-vindo ao Projeto Banco POO (por Guilherme Esdras)");
            System.out.println("Você deve executar o .jar seguido de um argumento! =)");
        }

    }
}
