package com.guilherme.cli;

import com.guilherme.cli.exceptions.OpçãoInválidaException;
import com.guilherme.console.utils.PrintUtils;
import com.guilherme.console.utils.ScannerUtils;
import com.guilherme.console.utils.SystemUtils;
import com.guilherme.console.utils.enums.cores.TextColor;

public abstract class Menu {

    protected PrintUtils printUtils = new PrintUtils();
    protected SystemUtils systemUtils = new SystemUtils();
    protected ScannerUtils scannerUtils = new ScannerUtils();

    private int opção;
    private Class<?> opçõesDoMenu;

    public int getOpção() {
        return opção;
    }

    public void setOpção(int opção, Class<?> enumClass) {
        if ( opção > 0 && opção <= enumClass.getEnumConstants().length ) {
            this.opção = opção - 1;
        } else {
            throw new OpçãoInválidaException();
        }
    }

    public Class<?> getOpçõesDoMenu() {
        return opçõesDoMenu;
    }

    public void setOpçõesDoMenu(Class<?> opçõesDoMenu) {
        this.opçõesDoMenu = opçõesDoMenu;
    }

    public void exibirMenu(String preMensagem, String posMensagem) {
        System.out.println(TextColor.CIANO + " > " + preMensagem + TextColor.RESET);
        for (int i = 0; i < getOpçõesDoMenu().getEnumConstants().length; i++) {
            System.out.printf(
                    "\n\t %d. %s", (i+1), getOpçõesDoMenu().getEnumConstants()[i]
            );
        }
        System.out.print("\n\t\t " + posMensagem + " ");
    }

    public void capturaOpção() {
        while (true) {
            try {
                setOpção( scannerUtils.inputInt(), this.getOpçõesDoMenu() );
                break;
            } catch (OpçãoInválidaException oie) {
                printUtils.printaDiv("-", 5);
                System.out.print("> Desculpe, mas esta opção não existe! '-'\n---\n" +
                                 "  Digite novamente: ");
            }
        }
    }

    public abstract void executaOpção(int opção);
    public void executa() {
        executaOpção( getOpção() );
    }

}
