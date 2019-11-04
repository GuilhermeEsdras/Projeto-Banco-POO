package com.guilherme.console.utils;

import java.util.Scanner;

public class ScannerUtils {

    public int inputInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String inputStr() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public double inputDouble() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

}
