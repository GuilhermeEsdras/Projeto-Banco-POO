package com.guilherme.cli;

import com.guilherme.console.utils.PrintUtils;
import com.guilherme.console.utils.ScannerUtils;
import com.guilherme.console.utils.SystemUtils;

public abstract class Tela {

    protected PrintUtils printUtils = new PrintUtils();
    protected SystemUtils systemUtils = new SystemUtils();
    protected ScannerUtils scannerUtils = new ScannerUtils();


    private String titulo;


    public Tela(String titulo) {
        this.setTitulo(titulo);
        this.printaTitulo();
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void printaTitulo() {
        printUtils.printHeader(getTitulo(), 87);
    }

    public abstract void exibirTela();
}
