package com.guilherme.pessoa.pessoafísica;

// Outros módulos
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.Pessoa;
import com.guilherme.pessoa.exceptions.*;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java utils
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class PessoaFísica extends Pessoa implements Comparable<PessoaFísica> {

    // Atributos
    private String CPF;
    private String nome;
    private String sobrenome;
    private String dataDeNascimento;
    private short idade;

    // Atributos default
    private static final String PESSOA_SEM_CPF = "--- Sem CPF ---";
    private static final String PESSOA_SEM_NOME = "Sem nome";
    private static final String PESSOA_SEM_SOBRENOME = "Sem sobrenome";
    private static final String PESSOA_SEM_DATADENASCIMENTO = "01/01/2000";


    // Construtor vazio
    public PessoaFísica() {
        super();

        this.setCPF(PESSOA_SEM_CPF);
        this.setNome(PESSOA_SEM_NOME);
        this.setSobrenome(PESSOA_SEM_SOBRENOME);
        this.setDataDeNascimento(PESSOA_SEM_DATADENASCIMENTO);
    }

    // Construtor que recebe apenas CPF
    public PessoaFísica(String CPF) {
        super();

        this.setCPF(CPF);
        this.setNome(PESSOA_SEM_NOME);
        this.setSobrenome(PESSOA_SEM_SOBRENOME);
        this.setDataDeNascimento(PESSOA_SEM_DATADENASCIMENTO);
    }

    // Construtor completo
    public PessoaFísica(Endereço endereço, String telefone, // <- P/ Construtor de Pessoa
                        String CPF, String nome, String sobrenome, String dataDeNascimento) {

        super(endereço, telefone);

        this.setCPF(CPF);
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setDataDeNascimento(dataDeNascimento);
    }


    /* .::Getters e Setters::. */

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        String CPFTemp = StringUtils.defaultIfBlank(CPF, PESSOA_SEM_CPF);
        if (CPFVálido(CPFTemp)) {
            // Formato pretendido: xxx.xxx.xxx-xx
            this.CPF =  CPFTemp.substring(0, 3) + "." + // xxx.
                        CPFTemp.substring(3, 6) + "." + // xxx.
                        CPFTemp.substring(6, 9) + "-" + // xxx-
                        CPFTemp.substring(9, 11);       // xx
        } else if (CPFTemp.equals(PESSOA_SEM_CPF)) {
            this.CPF = CPF;
        } else {
            throw new CPFInválidoException();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if (sobrenome.length() > 0) {
            this.sobrenome = sobrenome;
        }
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        if (dataDeNascimentoVálida("dd/MM/yyyy", dataDeNascimento, Locale.getDefault())) {
            this.dataDeNascimento = dataDeNascimento;
            this.setIdade(dataDeNascimento);
        }
    }

    public short getIdade() {
        return idade;
    }

    public void setIdade(String dataDeNascimento) {

    }


    /* .::Equals e Hashcode::. */
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


    /* .::Comparador::. */
    @Override
    public int compareTo(PessoaFísica outraPessoaFísica) {
        return this.getCPF().compareTo(outraPessoaFísica.getCPF());
    }


    /* .::Métodos auxiliares::. */

    /**
     * <h1>CPF Válido</h1>
     *
     * <p>Verifica se um determinado CPF é válido.</p>
     * <p>Analisa se a quantidade de números está correta e se não são todos iguais.</p>
     *
     * @param CPF Uma String contendo apenas números representando um CPF.
     * @return Valor booleano. True se for, False caso contrário.
     */
    private boolean CPFVálido(String CPF) {
        return (CPF.length() == 11) && (CPF.replaceAll(String.valueOf(CPF.charAt(0)), "").length() > 0);
    }


    /**
     * <h1>Data De Nascimento Válida</h1>
     *
     * <p>Verifica se uma determinada data de nascimento recebida no formato String é válida.</p>
     *
     * @param formato Formato de data requerido;
     * @param dataDeNascimento Data no formato String;
     * @param local Local.
     * @return Valor booleano. True se for, Falso caso contrário.
     */
    public static boolean dataDeNascimentoVálida(String formato, String dataDeNascimento, Locale local) {

        LocalDateTime ldt = null;
        DateTimeFormatter fomatador = DateTimeFormatter.ofPattern(formato, local);

        try {
            ldt = LocalDateTime.parse(dataDeNascimento, fomatador);
            String resultado = ldt.format(fomatador);
            return resultado.equals(dataDeNascimento);

        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(dataDeNascimento, fomatador);
                String resultado = ld.format(fomatador);
                return resultado.equals(dataDeNascimento);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(dataDeNascimento, fomatador);
                    String resultado = lt.format(fomatador);
                    return resultado.equals(dataDeNascimento);
                } catch (DateTimeParseException e2) {
                    // Debug
                    //e2.printStackTrace();
                }
            }
        }

        return false;
    }
}
