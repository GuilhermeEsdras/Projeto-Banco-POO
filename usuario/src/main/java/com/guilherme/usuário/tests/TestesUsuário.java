package com.guilherme.usuário.tests;

import com.guilherme.console.utils.PrintUtils;
import com.guilherme.usuário.Usuário;

public class TestesUsuário {
    public static void main(String[] args) {

        PrintUtils printUtils = new PrintUtils();

        Usuário usuário = new Usuário(
                "guilherme.esdras@hotmail.com",
                "GuiEsdras",
                "123456"
        );

        System.out.println(usuário);

        printUtils.printaDivLn("-", 5);

        usuário.setEmail("guilherme@admin.com");
        usuário.setLogin("Admin");
        usuário.setSenha("Admin123");

        System.out.println(usuário);
    }
}
