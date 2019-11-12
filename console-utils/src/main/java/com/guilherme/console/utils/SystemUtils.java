package com.guilherme.console.utils;

import java.util.concurrent.TimeUnit;

public class SystemUtils {
    protected PrintUtils printUtils = new PrintUtils();
    protected ScannerUtils scannerUtils = new ScannerUtils();

    public void sair() {
        System.out.println("Saindo do sistema... Volte sempre! :)");
        System.exit(0);
    }

    public void carregar(String componente, long tempoEmSegs) {
        try {
            System.out.print("> Carregando " + componente);
            System.out.print(", aguarde");
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println(".");
            TimeUnit.SECONDS.sleep(tempoEmSegs);
        } catch (InterruptedException ie) {
            System.out.println("Ops! Houve um erro durante o carregamento... :/");
        }
    }

    public void pausar(long tempoEmSegs) {
        try {
            TimeUnit.SECONDS.sleep(tempoEmSegs);
        } catch (InterruptedException ie) {
            System.out.println("Ops! Houve um erro... :/");
        }
    }

    public boolean confirmar(String processo) {
        printUtils.printaDiv("-", 5);
        System.out.println("> Iniciando processo de " + processo + "...");
        while (true) {
            System.out.print("  Prosseguir? [Sim/Nao]: ");
            String resposta = scannerUtils.inputStr().toUpperCase();
            if ( resposta.equals("SIM") || resposta.equals("S") ) {
                return true;
            } else if ( resposta.equals("NAO") || resposta.equals("N") ) {
                return false;
            } else {
                printUtils.printaDiv("-", 5);
                System.out.println("> Digite uma resposta válida (sem acentuação)!");
                printUtils.printaDiv("-", 5);
            }
        }
    }
}
