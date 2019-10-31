package com.guilherme.pessoa.pessoafísica;

// Outros packages
import com.guilherme.pessoa.Pessoa;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.exceptions.*;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java utils
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * <h1>Pessoa Física</h1>
 *
 * <p>Classe que modela uma Pessoa Física.</p>
 * <p>Uma Pessoa Física herda de Pessoa e além disso possui CPF, Nome, Sobrenome, Data de Nascimento e Idade.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public class PessoaFísica extends Pessoa {

    /* Atributos */
    private String CPF;
    private String nome;
    private String sobrenome;
    private String dataDeNascimento;
    private byte   idade;

    /* Atributos Default */
    static final String PESSOA_SEM_CPF              = "--- Sem CPF ---";
    static final String PESSOA_SEM_NOME             = "--- Sem nome ---";
    static final String PESSOA_SEM_SOBRENOME        = "--- Sem sobrenome ---";
    static final String PESSOA_SEM_DATADENASCIMENTO = "01/01/2001";


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    // Construtor vazio
    public PessoaFísica() {
        super();

        this.setCPF( PESSOA_SEM_CPF );
        this.setNome( PESSOA_SEM_NOME );
        this.setSobrenome( PESSOA_SEM_SOBRENOME );
        this.setDataDeNascimento( PESSOA_SEM_DATADENASCIMENTO );
    }

    // Construtor que recebe apenas CPF
    public PessoaFísica(String CPF) {
        super();

        this.setCPF( CPF );
        this.setNome( PESSOA_SEM_NOME );
        this.setSobrenome( PESSOA_SEM_SOBRENOME );
        this.setDataDeNascimento( PESSOA_SEM_DATADENASCIMENTO );
    }

    // Construtor completo
    public PessoaFísica(Endereço endereço, String telefone, // <- P/ Construtor de Pessoa
                        String CPF, String nome, String sobrenome, String dataDeNascimento) {

        super( endereço, telefone );

        this.setCPF( CPF );
        this.setNome( nome );
        this.setSobrenome( sobrenome );
        this.setDataDeNascimento( dataDeNascimento );
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

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
        if ((nome.length() > 0) && !(StringUtils.isNumeric(nome))) {
            this.nome = nome;
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if ((sobrenome.length() > 0) && !(StringUtils.isNumeric(sobrenome))) {
            this.sobrenome = sobrenome;
        }
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        try {
            DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

            Date dataAtual = Calendar.getInstance().getTime();
            Date dataDeNascimentoFormatada = formatador.parse(dataDeNascimento);

            if (dataDeNascimentoFormatada.before(dataAtual))
            {
                int idadeTemp = calculaIdade(dataDeNascimentoFormatada, dataAtual);

                if (idadeTemp >= 0 && idadeTemp < 127)
                {
                    this.dataDeNascimento = dataDeNascimento;
                    byte idade = (byte) idadeTemp;
                    this.setIdade(idade);

                } else {
                    throw new DataInválidaException("Idade fora dos limites!");
                }

            } else {
                throw new DataInválidaException("Data de nascimento não pode ser no futuro!");
            }

        } catch (ParseException p) {
            throw new DataInválidaException();
        }
    }

    public short getIdade() {
        return idade;
    }

    private void setIdade(byte idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }


    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.

    @Override
    public String toString() {
        return "PessoaFísica{" +
                "CPF='" + CPF + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", idade=" + idade +
                '}';
    }


    /* ------------------------ */
    /* .::Métodos auxiliares::. */
    /* ------------------------ */

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
     * <h1>Calcula Idade</h1>
     *
     * <p>Calcula a diferença em anos entre duas datas passadas como argumento.</p>
     *
     * @param dataDeNascimento Data de nascimento.
     * @param dataAtual Data atual.
     * @return Valor representando a diferença (idade) em anos.
     */
    protected int calculaIdade(Date dataDeNascimento, Date dataAtual)
    {
        Calendar nasci = Calendar.getInstance(Locale.getDefault());
        nasci.setTime(dataDeNascimento);
        Calendar atual = Calendar.getInstance(Locale.getDefault());
        atual.setTime(dataAtual);

        int diferença = atual.get(Calendar.YEAR) - nasci.get(Calendar.YEAR);

        if ( nasci.get(Calendar.MONTH) >  atual.get(Calendar.MONTH) ||
             nasci.get(Calendar.MONTH) == atual.get(Calendar.MONTH) &&
             nasci.get(Calendar.DATE)  >  atual.get(Calendar.DATE)
        ) {
            diferença--;
        }

        return diferença;
    }
}
