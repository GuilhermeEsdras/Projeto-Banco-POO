package com.guilherme.pessoa.pessoajurídica;


// Outros packages
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.Pessoa;
import com.guilherme.pessoa.exceptions.CNPjInválidoException;


// Apache utils
import org.apache.commons.lang3.StringUtils;

/**
 * Classe que modela uma Pessoa Jurídica.
 * Uma Pessoa Jurídica herda de Pessoa e além disso possui CNPj, Nome Fantasia e Razão Social.
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public class PessoaJurídica extends Pessoa {

    // Atributos
    private String CNPj;
    private String nomeFantasia;
    private String razãoSocial;


    // Atributos Default
    private static final String PESSOA_JURÍDICA_SEM_CNPJ = "--- Sem CNPj ---";
    private static final String PESSOA_JURÍDICA_SEM_NOMEFANTASIA = "--- Sem Nome Fantasia ---";
    private static final String PESSOA_JURÍDICA_SEM_RAZÃOSOCIAL = "--- Sem Razão Social ---";


    // Construtores
    public PessoaJurídica(Endereço endereço, String telefone, // <- Pessoa
                          String CNPj, String nomeFantasia, String razãoSocial) {

        super(endereço, telefone);

        this.setCNPj(CNPj);
        this.setNomeFantasia(nomeFantasia);
        this.setRazãoSocial(razãoSocial);
    }


    // Getters e Setters
    public String getCNPj() {
        return CNPj;
    }

    public void setCNPj(String CNPj) {
        String CNPjTemp = StringUtils.defaultIfBlank(CNPj, PESSOA_JURÍDICA_SEM_CNPJ);
        if (CNPjVálido(CNPjTemp)) {
            // Formato pretendido: xx.xxx.xxx/xxxx-xx
            this.CNPj = CNPjTemp.substring(0, 2) + "." +  // xx.
                        CNPjTemp.substring(2, 5) + "." +  // xxx.
                        CNPjTemp.substring(5, 8) + "/" +  // xxx/
                        CNPjTemp.substring(8, 12) + "-" + // xxxx-
                        CNPjTemp.substring(12, 14);       // xx
        } else if (CNPjTemp.equals(PESSOA_JURÍDICA_SEM_CNPJ)) {
            this.CNPj = CNPj;
        } else {
            throw new CNPjInválidoException();
        }
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        if (nomeFantasia.length() > 0) {
            this.nomeFantasia = nomeFantasia;
        }
    }

    public String getRazãoSocial() {
        return razãoSocial;
    }

    public void setRazãoSocial(String razãoSocial) {
        if (razãoSocial.length() > 0) {
            this.razãoSocial = razãoSocial;
        }
    }


    /* Métodos auxiliares */

    /**
     * <h1>CNPj Válido</h1>
     *
     * <p>Verifica se um determinado CNPj é válido.</p>
     * <p>Analisa se a quantidade de números está correta e se não são todos iguais.</p>
     *
     * @param CNPj Uma String contendo apenas números representado o CNPj.
     * @return Valor booleano. True se for, False caso contrário.
     */
    private boolean CNPjVálido(String CNPj) {
        return (CNPj.length() == 14) && (CNPj.replaceAll(String.valueOf(CNPj.charAt(0)), "").length() > 0);
    }

}
