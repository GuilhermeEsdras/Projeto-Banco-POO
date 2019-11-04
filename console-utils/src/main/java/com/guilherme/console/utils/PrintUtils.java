package com.guilherme.console.utils;

public class PrintUtils {

    public void printaLn() {
        System.out.println();
    }

    public void printaDiv(String div, int quant) {
        System.out.println("+" + div.repeat(quant) + "+");
    }
    public void printaDivLn(String div, int quant) {
        System.out.println("+" + div.repeat(quant) + "+\n");
    }

    public void printHeader(String titulo, int tamanho) {
        int tam = tamanho;
        if (titulo.length() > tamanho) {
            tam = titulo.length();
        }

        String div = "+" + "=".repeat(tam) + "+";
        String esp = " ".repeat((tamanho - titulo.length()) / 2);

        System.out.println(div);
        System.out.print("|");
        System.out.print(esp);
        System.out.print(titulo);
        System.out.print(esp);
        System.out.println("|");
        System.out.println(div);
    }

    public String divisóriaDeTexto(String texto, String divisória) {
        int max = 0, cont = 0;
        for (int i = 0; i < texto.length(); i++) {
            cont++;
            if (texto.charAt(i) == '\n') {
                if (cont > max) {
                    max = cont;
                }
                cont = 0;
            }
        }

        if (max == 0) {
            max = texto.length();
        }

        return "+" + divisória.repeat(max) + "+";
    }

    /**
     * Printa texto com divisórias adaptadas nas linhas de cima e baixo.
     * @param texto String
     * @param divisória Divisória desejada.
     */
    public void printaStringEntreDivs(String texto, String divisória) {
        String div = divisóriaDeTexto(texto, divisória);
        System.out.println(div);
        System.out.println(texto);
        System.out.println(div);
    }

    public int quantidadeDeLinhas(String texto) {
        int cont = 1;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '\n') {
                cont++;
            }
        }
        return cont;
    }

}
