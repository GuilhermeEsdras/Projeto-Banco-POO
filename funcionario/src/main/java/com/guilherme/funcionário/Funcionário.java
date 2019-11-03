package com.guilherme.funcionário;

// Outros módulos
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;

// Java utils
import java.util.Objects;

public class Funcionário extends PessoaFísica implements Comparable<Funcionário> {

    /* Atributos */
    private String ID;
    private double salárioBase;


    /* Atributos Default */
    private static int SALÁRIO_MÍNIMO = 1000;


    /* Atributos Auxiliares */
    private static int INCREMENTADOR = 1;


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    // Construtor vazio
    public Funcionário() {
        super();
        this.setSalárioBase(SALÁRIO_MÍNIMO);
        this.setID( INCREMENTADOR++ );
    }

    // Construtor que recebe apenas CPF
    public Funcionário(String CPF) {
        super(CPF);
        this.setSalárioBase(SALÁRIO_MÍNIMO);
        this.setID( INCREMENTADOR++ );
    }

    // Construtor que recebe apenas CPF e ID
    public Funcionário(String CPF, int ID) {
        super(CPF);
        this.setSalárioBase(SALÁRIO_MÍNIMO);
        this.setID( ID );
    }

    // Construtor sem dados de usuário
    public Funcionário(Endereço endereço, String telefone,                                 // <-- Pessoa
                       String CPF, String nome, String sobrenome, String dataDeNascimento, // <-- PessoaFísica
                       int ID, double salárioBase)
    {
        super(endereço, telefone, CPF, nome, sobrenome, dataDeNascimento);
        this.setSalárioBase(salárioBase);
        this.setID( ID );
    }

    // Construtor completo
    public Funcionário(String email, String login, String senha,                           // <-- Usuário
                       Endereço endereço, String telefone,                                 // <-- Pessoa
                       String CPF, String nome, String sobrenome, String dataDeNascimento, // <-- PessoaFísica
                       int ID, double salárioBase)
    {
        super(email, login, senha,
              endereço, telefone,
              CPF, nome, sobrenome, dataDeNascimento
        );
        this.setSalárioBase(salárioBase);
        this.setID( ID );
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public String getID() {
        return ID;
    }

    private void setID(int ID) {
        this.ID = String.valueOf(ID);
        INCREMENTADOR = ID;
    }

    public double getSalárioBase() {
        return salárioBase;
    }

    public void setSalárioBase(double salárioBase) {
        if (salárioBase > 0) {
            this.salárioBase = salárioBase;
        }
    }


    /* ----------------------- */
    /* .::Equals e Hashcode::. */
    /* ----------------------- */
    // Principalmente utilizado como parâmetro de remoção de duplicatas em mapas e/ou conjuntos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Funcionário that = (Funcionário) o;

        return getID().equals(that.getID());
    }

    @Override
    public int hashCode() {
        return getID().hashCode();
    }


    /* ---------------- */
    /* .::Comparador::. */
    /* ---------------- */
    // Principalmente utilizado como parâmetro de ordenação em árvores de mapas e/ou de conjuntos.

    @Override
    public int compareTo(Funcionário outroFuncionário) {
        return this.getNome().compareTo(outroFuncionário.getNome());
    }
}
