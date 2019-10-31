package com.guilherme.usuário.tests;

import com.guilherme.usuário.Usuário;

public class Tests {
    public static void main(String[] args) {
        Usuário usuário = new Usuário();
        usuário.setEmail("Exe-mplo@gmailcom");
        System.out.println(usuário.getEmail());
    }
}
