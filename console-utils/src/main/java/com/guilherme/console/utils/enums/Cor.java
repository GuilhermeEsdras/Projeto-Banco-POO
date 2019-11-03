package com.guilherme.console.utils.enums;

public enum Cor {
    RESET("\033[0m"),

    // Cores Padrão
    PRETO("\033[0;30m"),
    VERMELHO("\033[0;31m"),
    VERDE("\033[0;32m"),
    AMARELO("\033[0;33m"),
    AZUL("\033[0;34m"),
    MAGENTA("\033[0;35m"),
    CIANO("\033[0;36m"),
    BRANCO("\033[0;37m"),

    // Negrito
    PRETO_NEGRITO("\033[1;30m"),
    VERMELHO_NEGRITO("\033[1;31m"),
    VERDE_NEGRITO("\033[1;32m"),
    AMARELO_NEGRITO("\033[1;33m"),
    AZUL_NEGRITO("\033[1;34m"),
    MAGENTA_NEGRITO("\033[1;35m"),
    CIANO_NEGRITO("\033[1;36m"),
    BRANCO_NEGRITO("\033[1;37m"),

    // Sublinhado
    PRETO_SUBLINHADO("\033[4;30m"),
    VERMELHO_SUBLINHADO("\033[4;31m"),
    VERDE_SUBLINHADO("\033[4;32m"),
    AMARELO_SUBLINHADO("\033[4;33m"),
    AZUL_SUBLINHADO("\033[4;34m"),
    MAGENTA_SUBLINHADO("\033[4;35m"),
    CIANO_SUBLINHADO("\033[4;36m"),
    BRANCO_SUBLINHADO("\033[4;37m"),

    // Background
    PRETO_BACKGROUND("\033[40m"),
    VERMELHO_BACKGROUND("\033[41m"),
    VERDE_BACKGROUND("\033[42m"),
    AMARELO_BACKGROUND("\033[43m"),
    AZUL_BACKGROUND("\033[44m"),
    MAGENTA_BACKGROUND("\033[45m"),
    CIANO_BACKGROUND("\033[46m"),
    BRANCO_BACKGROUND("\033[47m"),

    // Alta Intensidade
    PRETO_CLARO("\033[0;90m"),
    VERMELHO_CLARO("\033[0;91m"),
    VERDE_CLARO("\033[0;92m"),
    AMARELO_CLARO("\033[0;93m"),
    AZUL_CLARO("\033[0;94m"),
    MAGENTA_CLARO("\033[0;95m"),
    CIANO_CLARO("\033[0;96m"),
    BRANCO_CLARO("\033[0;97m"),

    // Negrito com Alta Intensidade
    PRETO_NEGRITO_CLARO("\033[1;90m"),
    VERMELHO_NEGRITO_CLARO("\033[1;91m"),
    VERDE_NEGRITO_CLARO("\033[1;92m"),
    AMARELO_NEGRITO_CLARO("\033[1;93m"),
    AZUL_NEGRITO_CLARO("\033[1;94m"),
    MAGENTA_NEGRITO_CLARO("\033[1;95m"),
    CIANO_NEGRITO_CLARO("\033[1;96m"),
    BRANCO_NEGRITO_CLARO("\033[1;97m"),

    // Background com Alta Intensidade
    PRETO_BACKGROUND_CLARO("\033[0;100m"),
    VERMELHO_BACKGROUND_CLARO("\033[0;101m"),
    VERDE_BACKGROUND_CLARO("\033[0;102m"),
    AMARELO_BACKGROUND_CLARO("\033[0;103m"),
    AZUL_BACKGROUND_CLARO("\033[0;104m"),
    MAGENTA_BACKGROUND_CLARO("\033[0;105m"),
    CIANO_BACKGROUND_CLARO("\033[0;106m"),
    BRANCO_BACKGROUND_CLARO("\033[0;107m");

    private final String código;

    Cor(String código) {
        this.código = código;
    }

    @Override
    public String toString() {
        return código;
    }
}
