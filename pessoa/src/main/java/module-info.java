module pessoa {
    requires commons.lang3;
    requires usuario;

    exports com.guilherme.pessoa;
    exports com.guilherme.pessoa.enums;
    exports com.guilherme.pessoa.pessoajurídica;
    exports com.guilherme.pessoa.pessoafísica;
}