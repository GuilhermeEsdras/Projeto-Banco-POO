package com.guilherme.cli.printUtils;

public class PrintUtils {

    public void printaLn() {
        System.out.println();
    }

    public void printaDiv(String div, int quant) {
        System.out.print(div.repeat(quant));
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
        System.out.print(texto);
        System.out.println(div);
    }

}
