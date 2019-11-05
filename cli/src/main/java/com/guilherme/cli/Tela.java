package com.guilherme.cli;

import com.guilherme.cli.exceptions.OpçãoInválidaException;

public abstract class Tela {

    private int opção;

    public int getOpção() {
        return opção;
    }

    public void setOpção(int opção, Class<?> enumClass) {
        if ( getOpção() > 0 && getOpção() <= enumClass.getEnumConstants().length ) {
            this.opção = opção + 1;
        } else {
            throw new OpçãoInválidaException();
        }
    }

}
