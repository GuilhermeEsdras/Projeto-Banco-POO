package com.guilherme.cli.cadastro;

import com.guilherme.cli.cadastro.enums.OpçõesMenuCadastro;
import com.guilherme.cli.exceptions.OpçãoInválidaException;

public class TelaDeCadastro {

    private int opção;

    public int getOpção() {
        return opção;
    }

    public void setOpção(int opção) {
        if ( getOpção() > 0 && getOpção() <= OpçõesMenuCadastro.values().length ) {
            this.opção = opção + 1;
        } else {
            throw new OpçãoInválidaException();
        }
    }

}
