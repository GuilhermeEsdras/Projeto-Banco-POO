package com.guilherme.cli.welcome;


import com.guilherme.console.utils.PrintUtils;
import com.guilherme.console.utils.enums.cores.TextColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoasVindas
{
    private List<String> listaDeBanners;
    private PrintUtils printUtils;
    private Random random;

    {
        printUtils = new PrintUtils();
        random = new Random();

        this.setListaDeBanners( new ArrayList<>() );
        this.banners();
    }

    private List<String> getListaDeBanners() {
        return listaDeBanners;
    }

    private void setListaDeBanners(List<String> listaDeBanners) {
        this.listaDeBanners = listaDeBanners;
    }

    public void printBoasVindas(int opção) {
        int cor = random.nextInt(5) +2;
        String banner = String.format("%s ", TextColor.values()[cor].toString()) +
                        getListaDeBanners().get(opção) +
                        String.format(" %s", TextColor.RESET);
        printUtils.printaStringEntreDivs(banner, "=");
    }

    public void printBoasVindas() {
        int cor = random.nextInt(6) +1;
        String banner = String.format("%s ", TextColor.values()[cor].toString()) +
                        getListaDeBanners().get(random.nextInt(getListaDeBanners().size())) +
                        String.format(" %s", TextColor.RESET);

        printUtils.printaStringEntreDivs(banner, "=");
    }



    /* ==================================================== */

    /*
     *------------------------------------------------------+
     *      ____                                            |
     *     |  _ \                                           |
     *     | |_) |  __ _  _ __   _ __    ___  _ __  ___     |
     *     |  _ <  / _` || '_ \ | '_ \  / _ \| '__|/ __|    |
     *     | |_) || (_| || | | || | | ||  __/| |   \__ \    |
     *     |____/  \__,_||_| |_||_| |_| \___||_|   |___/    |
     *                                                      |
     *------------------------------------------------------+
     */

    private void banners()
    {
        String normal1 = (
                "                    _____              _      ____                            \n" +
                "                    |  __ \\            (_)    |  _ \\                           \n" +
                "                    | |__) |_ __  ___   _     | |_) |  __ _  _ __    ___  ___  \n" +
                "                    |  ___/| '__|/ _ \\ | |    |  _ <  / _` || '_ \\  / __|/ _ \\ \n" +
                "                    | |    | |  | (_) || | _  | |_) || (_| || | | || (__| (_) |\n" +
                "                    |_|    |_|   \\___/ | |(_) |____/  \\__,_||_| |_| \\___|\\___/ \n" +
                "                                      _/ |                                     \n" +
                "                                     |__/                                      "
        ); getListaDeBanners().add(normal1);

        String normal2 = (
                "                  ______              _       ______                             \n" +
                "                  (_____ \\            (_)     (____  \\                            \n" +
                "                   _____) )____  ___   _       ____)  )  ____  ____    ____  ___  \n" +
                "                  |  ____// ___)/ _ \\ | |     |  __  (  / _  ||  _ \\  / ___)/ _ \\ \n" +
                "                  | |    | |   | |_| || | _   | |__)  )( ( | || | | |( (___| |_| |\n" +
                "                  |_|    |_|    \\___/_| |(_)  |______/  \\_||_||_| |_| \\____)\\___/ \n" +
                "                                    (__/                                          "
        ); getListaDeBanners().add(normal2);




        /* TESTES */

        String money = (
                "/$$$$$$$                                  /$$    /$$ /$$                 /$$                                                            \n" +
                "| $$__  $$                                | $$   | $$|__/                | $$                                                            \n" +
                "| $$  \\ $$  /$$$$$$  /$$$$$$/$$$$         | $$   | $$ /$$ /$$$$$$$   /$$$$$$$  /$$$$$$               /$$$$$$   /$$$$$$                   \n" +
                "| $$$$$$$  /$$__  $$| $$_  $$_  $$ /$$$$$$|  $$ / $$/| $$| $$__  $$ /$$__  $$ /$$__  $$             |____  $$ /$$__  $$                  \n" +
                "| $$__  $$| $$$$$$$$| $$ \\ $$ \\ $$|______/ \\  $$ $$/ | $$| $$  \\ $$| $$  | $$| $$  \\ $$              /$$$$$$$| $$  \\ $$                  \n" +
                "| $$  \\ $$| $$_____/| $$ | $$ | $$          \\  $$$/  | $$| $$  | $$| $$  | $$| $$  | $$             /$$__  $$| $$  | $$                  \n" +
                "| $$$$$$$/|  $$$$$$$| $$ | $$ | $$           \\  $/   | $$| $$  | $$|  $$$$$$$|  $$$$$$/            |  $$$$$$$|  $$$$$$/                  \n" +
                "|_______/  \\_______/|__/ |__/ |__/            \\_/    |__/|__/  |__/ \\_______/ \\______/              \\_______/ \\______/                   \n" +
                "             /$$$$$$$                                     /$$                           /$$$$$$$                                         \n" +
                "            | $$__  $$                                   | $$                          | $$__  $$                                        \n" +
                "            | $$  \\ $$ /$$$$$$   /$$$$$$  /$$  /$$$$$$  /$$$$$$    /$$$$$$             | $$  \\ $$  /$$$$$$  /$$$$$$$   /$$$$$$$  /$$$$$$ \n" +
                "            | $$$$$$$//$$__  $$ /$$__  $$|__/ /$$__  $$|_  $$_/   /$$__  $$            | $$$$$$$  |____  $$| $$__  $$ /$$_____/ /$$__  $$\n" +
                "            | $$____/| $$  \\__/| $$  \\ $$ /$$| $$$$$$$$  | $$    | $$  \\ $$            | $$__  $$  /$$$$$$$| $$  \\ $$| $$      | $$  \\ $$\n" +
                "            | $$     | $$      | $$  | $$| $$| $$_____/  | $$ /$$| $$  | $$            | $$  \\ $$ /$$__  $$| $$  | $$| $$      | $$  | $$\n" +
                "            | $$     | $$      |  $$$$$$/| $$|  $$$$$$$  |  $$$$/|  $$$$$$/            | $$$$$$$/|  $$$$$$$| $$  | $$|  $$$$$$$|  $$$$$$/\n" +
                "            |__/     |__/       \\______/ | $$ \\_______/   \\___/   \\______/             |_______/  \\_______/|__/  |__/ \\_______/ \\______/ \n" +
                "                                    /$$  | $$                                                                                            \n" +
                "                                   |  $$$$$$/                                                                                            \n" +
                "                                    \\______/                                                                                             "
        ); getListaDeBanners().add( money );

        String comSobra = (
                "     ██████╗ ███████╗███╗   ███╗      ██╗   ██╗██╗███╗   ██╗██████╗  ██████╗          █████╗  ██████╗        \n" +
                "      ██╔══██╗██╔════╝████╗ ████║      ██║   ██║██║████╗  ██║██╔══██╗██╔═══██╗        ██╔══██╗██╔═══██╗       \n" +
                "      ██████╔╝█████╗  ██╔████╔██║█████╗██║   ██║██║██╔██╗ ██║██║  ██║██║   ██║        ███████║██║   ██║       \n" +
                "      ██╔══██╗██╔══╝  ██║╚██╔╝██║╚════╝╚██╗ ██╔╝██║██║╚██╗██║██║  ██║██║   ██║        ██╔══██║██║   ██║       \n" +
                "      ██████╔╝███████╗██║ ╚═╝ ██║       ╚████╔╝ ██║██║ ╚████║██████╔╝╚██████╔╝        ██║  ██║╚██████╔╝       \n" +
                "      ╚═════╝ ╚══════╝╚═╝     ╚═╝        ╚═══╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝         ╚═╝  ╚═╝ ╚═════╝        \n" +
                "██████╗ ██████╗  ██████╗      ██╗███████╗████████╗ ██████╗         ██████╗  █████╗ ███╗   ██╗ ██████╗ ██████╗ \n" +
                "██╔══██╗██╔══██╗██╔═══██╗     ██║██╔════╝╚══██╔══╝██╔═══██╗        ██╔══██╗██╔══██╗████╗  ██║██╔════╝██╔═══██╗\n" +
                "██████╔╝██████╔╝██║   ██║     ██║█████╗     ██║   ██║   ██║        ██████╔╝███████║██╔██╗ ██║██║     ██║   ██║\n" +
                "██╔═══╝ ██╔══██╗██║   ██║██   ██║██╔══╝     ██║   ██║   ██║        ██╔══██╗██╔══██║██║╚██╗██║██║     ██║   ██║\n" +
                "██║     ██║  ██║╚██████╔╝╚█████╔╝███████╗   ██║   ╚██████╔╝        ██████╔╝██║  ██║██║ ╚████║╚██████╗╚██████╔╝\n" +
                "╚═╝     ╚═╝  ╚═╝ ╚═════╝  ╚════╝ ╚══════╝   ╚═╝    ╚═════╝         ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═════╝ "
        ); getListaDeBanners().add( comSobra );

        String comSombra2 = (
                " __ )                        \\ \\     / _)             |                                      \n" +
                "  __ \\    _ \\  __ `__ \\        \\ \\   /   |  __ \\    _` |   _ \\            _` |   _ \\          \n" +
                "  |   |   __/  |   |   | _____| \\ \\ /    |  |   |  (   |  (   |          (   |  (   |         \n" +
                " ____/  \\___| _|  _|  _|         \\_/    _| _|  _| \\__,_| \\___/          \\__,_| \\___/          \n" +
                "              _ \\              _)        |                   __ )                             \n" +
                "             |   |   __|  _ \\   |   _ \\  __|   _ \\           __ \\    _` |  __ \\    __|   _ \\  \n" +
                "             ___/   |    (   |  |   __/  |    (   |          |   |  (   |  |   |  (     (   | \n" +
                "            _|     _|   \\___/   | \\___| \\__| \\___/          ____/  \\__,_| _|  _| \\___| \\___/  \n" +
                "                            ___/                                                              "
        ); getListaDeBanners().add( comSombra2 );

        String básico = (
                " ____                        __      __ _             _                        \n" +
                " |  _ \\                       \\ \\    / /(_)           | |                       \n" +
                " | |_) |  ___  _ __ ___  ______\\ \\  / /  _  _ __    __| |  ___      __ _   ___  \n" +
                " |  _ <  / _ \\| '_ ` _ \\|______|\\ \\/ /  | || '_ \\  / _` | / _ \\    / _` | / _ \\ \n" +
                " | |_) ||  __/| | | | | |        \\  /   | || | | || (_| || (_) |  | (_| || (_) |\n" +
                " |____/  \\___||_| |_| |_|         \\/    |_||_| |_| \\__,_| \\___/    \\__,_| \\___/ \n" +
                "    _____              _        _            ____                               \n" +
                "   |  __ \\            (_)      | |          |  _ \\                              \n" +
                "   | |__) |_ __  ___   _   ___ | |_  ___    | |_) |  __ _  _ __    ___  ___     \n" +
                "   |  ___/| '__|/ _ \\ | | / _ \\| __|/ _ \\   |  _ <  / _` || '_ \\  / __|/ _ \\    \n" +
                "   | |    | |  | (_) || ||  __/| |_| (_) |  | |_) || (_| || | | || (__| (_) |   \n" +
                "   |_|    |_|   \\___/ | | \\___| \\__|\\___/   |____/  \\__,_||_| |_| \\___|\\___/    \n" +
                "                     _/ |                                                       \n" +
                "                    |__/                                                        "
        ); getListaDeBanners().add( básico );

        String retângulos = (
                "_____                   _____  _         _                            \n" +
                "| __  | ___  _____  ___ |  |  ||_| ___  _| | ___      ___  ___         \n" +
                "| __ -|| -_||     ||___||  |  || ||   || . || . |    | .'|| . |        \n" +
                "|_____||___||_|_|_|      \\___/ |_||_|_||___||___|    |__,||___|       \n" +
                "     _____             _       _             _____                     \n" +
                "    |  _  | ___  ___  |_| ___ | |_  ___     | __  | ___  ___  ___  ___ \n" +
                "    |   __||  _|| . | | || -_||  _|| . |    | __ -|| .'||   ||  _|| . |\n" +
                "    |__|   |_|  |___|_| ||___||_|  |___|    |_____||__,||_|_||___||___|\n" +
                "                    |___|                                              "
        ); getListaDeBanners().add( retângulos );

    }

}
