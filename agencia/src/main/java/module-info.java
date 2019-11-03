module agencia {
    requires pessoa;
    requires funcionario;
    requires cliente;
    requires commons.lang3;
    requires console.utils;

    exports com.guilherme.agência;
}