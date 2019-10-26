module agencia {
    requires pessoa;
    requires funcionario;
    requires cliente;
    requires commons.lang3;

    exports com.guilherme.agência;
}