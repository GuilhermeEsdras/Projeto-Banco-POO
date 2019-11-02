package com.guilherme.pessoa.pessoajurídica;


// Outros packages
import com.guilherme.pessoa.Pessoa;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.exceptions.*;


// Apache utils
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.function.Predicate;


/**
 * <h1>Pessoa Jurídica</h1>
 *
 * <p>Classe que modela uma Pessoa Jurídica.</p>
 * <p>Uma Pessoa Jurídica herda de Pessoa e além disso possui CNPj, Nome Fantasia e Razão Social.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public class PessoaJurídica extends Pessoa {

    /* Atributos */
    private String CNPj;
    private String nomeFantasia;
    private String razãoSocial;


    /* Atributos Default */
    static final String PESSOA_JURÍDICA_SEM_CNPJ         = "--- Sem CNPj ---";
    static final String PESSOA_JURÍDICA_SEM_NOMEFANTASIA = "--- Sem Nome Fantasia ---";
    static final String PESSOA_JURÍDICA_SEM_RAZÃOSOCIAL  = "--- Sem Razão Social ---";


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    // Construtor vazio
    public PessoaJurídica()
    {
        super();

        this.setCNPj( PESSOA_JURÍDICA_SEM_CNPJ );
        this.setNomeFantasia( PESSOA_JURÍDICA_SEM_NOMEFANTASIA );
        this.setRazãoSocial( PESSOA_JURÍDICA_SEM_RAZÃOSOCIAL );
    }

    // Construtor que recebe apenas CNPj
    public PessoaJurídica(String CNPj) {
        super();

        this.setCNPj( CNPj );
        this.setNomeFantasia( PESSOA_JURÍDICA_SEM_NOMEFANTASIA );
        this.setRazãoSocial( PESSOA_JURÍDICA_SEM_RAZÃOSOCIAL );
    }

    // Construtor básico sem informações de Usuário
    public PessoaJurídica( Endereço endereço, String telefone, // <- Pessoa
                           String CNPj, String nomeFantasia, String razãoSocial)
    {
        super( endereço, telefone );

        this.setCNPj( CNPj );
        this.setNomeFantasia( nomeFantasia );
        this.setRazãoSocial( razãoSocial );
    }

    // Construtor completo
    public PessoaJurídica( String email, String login, String senha, // <-- Usuário
                           Endereço endereço, String telefone,       // <-- Pessoa
                           String CNPj, String nomeFantasia, String razãoSocial)
    {
        super( email, login, senha, endereço, telefone );

        this.setCNPj( CNPj );
        this.setNomeFantasia( nomeFantasia );
        this.setRazãoSocial( razãoSocial );
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public String getCNPj() {
        return CNPj;
    }

    public void setCNPj(String CNPj) {
        String CNPjTemp = StringUtils.defaultIfBlank(CNPj, PESSOA_JURÍDICA_SEM_CNPJ);
        if (CNPj.equals(PESSOA_JURÍDICA_SEM_CNPJ)) {
            this.CNPj = CNPj;
        } else if (CNPjVálido(CNPjTemp)) {
            // Formato pretendido: xx.xxx.xxx/xxxx-xx
            this.CNPj = CNPjTemp.substring(0, 2) + "." +  // xx.
                        CNPjTemp.substring(2, 5) + "." +  // xxx.
                        CNPjTemp.substring(5, 8) + "/" +  // xxx/
                        CNPjTemp.substring(8, 12) + "-" + // xxxx-
                        CNPjTemp.substring(12, 14);       // xx
        } else {
            throw new CNPjInválidoException();
        }
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = Optional.ofNullable( nomeFantasia )
                                    .map( String::strip )
                                    .filter( Predicate.not( String::isBlank ))
                                    .filter( Predicate.not( String::isEmpty ))
                                    .orElse( this.nomeFantasia );
    }

    public String getRazãoSocial() {
        return razãoSocial;
    }

    public void setRazãoSocial(String razãoSocial) {
        this.razãoSocial =  Optional.ofNullable( razãoSocial )
                                    .map( String::strip )
                                    .filter( Predicate.not( String::isBlank ))
                                    .filter( Predicate.not( String::isEmpty ))
                                    .orElse( this.razãoSocial );
    }


    /* ----------------------- */
    /* .::Equals e Hashcode::. */
    /* ----------------------- */
    // Principalmente utilizado como parâmetro de remoção de duplicatas em mapas e/ou conjuntos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PessoaJurídica that = (PessoaJurídica) o;

        return getCNPj().equals(that.getCNPj());
    }

    @Override
    public int hashCode() {
        return getCNPj().hashCode();
    }


    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.

    @Override
    public String toString() {
        return "PessoaJurídica{" +
                "CNPj='" + CNPj + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razãoSocial='" + razãoSocial + '\'' +
                '}';
    }


    /* ------------------------ */
    /* .::Métodos auxiliares::. */
    /* ------------------------ */

    /**
     * <h1>CNPj Válido</h1>
     *
     * <p>Verifica se um determinado CNPj é válido.</p>
     * <p>Analisa se a quantidade de números está correta, se não possui algum caractere diferente além de números
     * e se não são todos iguais.</p>
     *
     * @param CNPj Uma String contendo apenas números representado o CNPj.
     * @return Valor booleano. True se for, False caso contrário.
     */
    private boolean CNPjVálido(String CNPj) {
        return  ( CNPj.length() == 14 ) &&
                ( CNPj.replaceAll(String.valueOf(CNPj.charAt(0)), "").length() > 0 ) &&
                ( stringNuméricaVálida(CNPj) );
    }
}
