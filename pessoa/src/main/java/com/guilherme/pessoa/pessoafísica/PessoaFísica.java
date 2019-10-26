package com.guilherme.pessoa.pessoafísica;

// Outros módulos
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.Pessoa;

// Apache Utils | Funções úteis
import com.guilherme.pessoa.exceptions.*;
import org.apache.commons.lang3.*;

// Java utils
import java.util.Date;
import java.util.Objects;

public class PessoaFísica extends Pessoa {

    private static final String PESSOA_SEM_CPF = "--- Sem CPF ---";

    private String CPF;
    private String nome;
    private String sobrenome;
    private Date dataDeNascimento;

    public PessoaFísica(Endereço endereço, String telefone, // <- P/ Construtor de Pessoa
                        String CPF, String nome, String sobrenome, Date dataDeNascimento) {

        super(endereço, telefone);

        this.setCPF(CPF);
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setDataDeNascimento(dataDeNascimento);
    }

    public String getCPF() {
        return CPF;
    }

    private boolean CPFVálido(String CPF) {
        return (CPF.length() == 11) && (CPF.replaceAll(String.valueOf(CPF.charAt(0)), "").length() > 0);
    }

    public void setCPF(String CPF) {
        if (!CPF.equals(PESSOA_SEM_CPF)) {
            String CPFTemp = Objects.requireNonNullElse(StringUtils.defaultIfBlank(CPF, PESSOA_SEM_CPF), PESSOA_SEM_CPF);
            if (CPFVálido(CPFTemp)) {
                this.CPF =  CPFTemp.substring(0, 3) + "." +
                        CPFTemp.substring(3, 6) + "." +
                        CPFTemp.substring(6, 9) + "-" +
                        CPFTemp.substring(9, 11);
            } else {
                throw new CPFInválidoException();
            }
        } else {
            this.CPF = CPF;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PessoaFísica that = (PessoaFísica) o;

        return getCPF().equals(that.getCPF());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCPF());
    }


}
