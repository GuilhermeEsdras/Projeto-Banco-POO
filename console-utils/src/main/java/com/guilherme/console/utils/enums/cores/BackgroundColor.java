package com.guilherme.console.utils.enums.cores;

public enum BackgroundColor {
    RESET("\033[0m"),

    // Background
    PRETO("\033[40m"),
    VERMELHO("\033[41m"),
    VERDE("\033[42m"),
    AMARELO("\033[43m"),
    AZUL("\033[44m"),
    MAGENTA("\033[45m"),
    CIANO("\033[46m"),
    BRANCO("\033[47m"),

    // Background com Alta Intensidade
    PRETO_CLARO("\033[0;100m"),
    VERMELHO_CLARO("\033[0;101m"),
    VERDE_CLARO("\033[0;102m"),
    AMARELO_CLARO("\033[0;103m"),
    AZUL_CLARO("\033[0;104m"),
    MAGENTA_CLARO("\033[0;105m"),
    CIANO_LARO("\033[0;106m"),
    BRANCO_CLARO("\033[0;107m");

    private final String código;

    BackgroundColor(String código) {
        this.código = código;
    }

    @Override
    public String toString() {
        return código;
    }
}
