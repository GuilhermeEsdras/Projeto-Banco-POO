package com.guilherme.funcionário;

// Outros módulos
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;

// Java utils
import java.util.Date;
import java.util.Objects;

public class Funcionário extends PessoaFísica implements Comparable<Funcionário> {

    private int ID;
    private double salárioBase;

    private static int INCREMENTADOR = 1;

    {
        this.setID(INCREMENTADOR++);
    }

    public Funcionário(Endereço endereço, String telefone, // Construtor de Pessoa
                       String CPF, String nome, String sobrenome, Date dataDeNascimento, // Construtor de PessoaFísica
                       double salárioBase)
    {
        super(endereço, telefone, CPF, nome, sobrenome, dataDeNascimento);
        this.setSalárioBase(salárioBase);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalárioBase() {
        return salárioBase;
    }

    public void setSalárioBase(double salárioBase) {
        this.salárioBase = salárioBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Funcionário that = (Funcionário) o;

        return getID() == that.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getID());
    }

    @Override
    public int compareTo(Funcionário outroFuncionário) {
        return this.getCPF().compareTo(outroFuncionário.getCPF());
    }
}
