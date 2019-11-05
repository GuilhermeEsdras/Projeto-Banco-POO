package com.guilherme.cli.login;

import com.guilherme.cli.exceptions.OpçãoInválidaException;
import com.guilherme.cli.login.enums.OpçõesMenuLogin;
import com.guilherme.console.utils.PrintUtils;
import com.guilherme.console.utils.ScannerUtils;
import com.guilherme.console.utils.enums.cores.TextColor;

import java.util.Calendar;
import java.util.EnumSet;

public class TelaDeLogin {

    private MenuTelaDeLogin menuTelaDeLogin;
    private PrintUtils      printUtils;
    private ScannerUtils    scannerUtils;

    {
        menuTelaDeLogin = new MenuTelaDeLogin();
        printUtils      = new PrintUtils();
        scannerUtils    = new ScannerUtils();
    }

    public void exibirTelaDeLogin()
    {
        printUtils.printHeader("Tela de Login", 87);

        /* --- */

        int horaAtual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) -1;
        System.out.print("> ");
        if (horaAtual >= 1 && horaAtual <= 11) {
            System.out.println(TextColor.CIANO + "Bom Dia! \uD83C\uDF1E" + TextColor.RESET);
        } else if (horaAtual >= 12 && horaAtual <= 18) {
            System.out.println(TextColor.AMARELO + "Boa Tarde! \uD83C\uDF23" + TextColor.RESET);
        } else {
            System.out.println(TextColor.AZUL_SUBLINHADO + "Boa Noite..." + TextColor.AZUL + " \uD83C\uDF11" + TextColor.RESET);
        }
        System.out.println("  Seja bem-vindo! :D");

        /* --- */

        printUtils.printaLn();

        exibirStatusDoSistema();

        printUtils.printaDiv("-", 87);

        /* --- */

        menuTelaDeLogin.exibirMenuTelaDeLogin();
        menuTelaDeLogin.setOpção( scannerUtils.inputInt(), OpçõesMenuLogin.class );
        menuTelaDeLogin.capturaOpçõesMenuTelaDeLogin( menuTelaDeLogin.getOpção() );
    }

    public void exibirStatusDoSistema()
    {
        int quantDeBancos       = 0,
            quantDeAgencias     = 0,
            quantDeFuncionarios = 0,
            quantDeClientes     = 0;

        System.out.print(TextColor.AMARELO);
        System.out.println("\t" + "| Status do Sistema |");
        System.out.printf ("\t" +
                        " - %d Banco(s) cadastrado(s);\n\t" +
                        " - %d Agência(s) cadastrada(s);\n\t" +
                        " - %d Funcionário(s) cadastrado(s);\n\t" +
                        " - %d Cliente(s) cadastrado(s).\n\t" +
                        " > Sistema em construção! <\n",
                        quantDeBancos, quantDeAgencias, quantDeFuncionarios, quantDeClientes);

        System.out.print(TextColor.RESET);

    }

}
