module funcionario {
    requires pessoa;
    exports com.guilherme.funcionário;
    exports com.guilherme.funcionário.gerente;
    exports com.guilherme.funcionário.atendente;
    exports com.guilherme.funcionário.caixa;
    exports com.guilherme.funcionário.segurança;
}