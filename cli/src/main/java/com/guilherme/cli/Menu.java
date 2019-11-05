package com.guilherme.cli;

import com.guilherme.cli.exceptions.OpçãoInválidaException;

public abstract class Menu {

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
        System.out.println("  " + preMensagem);
        for (int i = 0; i < getOpçõesDoMenu().getEnumConstants().length; i++) {
            System.out.printf(
                    "\n\t %d. %s", (i+1), getOpçõesDoMenu().getEnumConstants()[i]
            );
        }
        System.out.print("\n\t " + posMensagem + " ");
    }

    public void capturaOpção(int opção) {
        setOpção(opção, this.getOpçõesDoMenu());
    }

    public abstract void executaOpção(int opção);
    public void executa() {
        executaOpção( getOpção() );
    }

}
