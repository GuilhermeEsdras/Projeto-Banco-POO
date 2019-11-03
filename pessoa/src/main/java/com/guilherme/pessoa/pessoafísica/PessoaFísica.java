package com.guilherme.pessoa.pessoafísica;

// Outros packages
import com.guilherme.console.utils.Block;
import com.guilherme.console.utils.Board;
import com.guilherme.console.utils.PrintUtils;
import com.guilherme.console.utils.Table;
import com.guilherme.pessoa.Pessoa;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.exceptions.*;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java utils
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;


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

    // Construtor sem informações de Usuário
    public PessoaFísica(Endereço endereço, String telefone, // <-- Pessoa
                        String CPF, String nome, String sobrenome, String dataDeNascimento)
    {
        super( endereço, telefone );

        this.setCPF( CPF );
        this.setNome( nome );
        this.setSobrenome( sobrenome );
        this.setDataDeNascimento( dataDeNascimento );
    }

    // Construtor completo
    public PessoaFísica(String email, String login, String senha, // <-- Usuário
                        Endereço endereço, String telefone,       // <-- Pessoa
                        String CPF, String nome, String sobrenome, String dataDeNascimento)
    {
        super(  email, login, senha,
                endereço, telefone );

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
        if ( !(StringUtils.isNumeric(nome)) ) {
            this.nome = Optional.ofNullable( nome )
                                .map( String::strip )
                                .filter( Predicate.not( String::isEmpty ))
                                .filter( Predicate.not( String::isBlank ))
                                .orElse( this.nome );
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if ( !(StringUtils.isNumeric(sobrenome)) ) {
            this.sobrenome = Optional.ofNullable( sobrenome )
                                     .map( String::strip )
                                     .filter( Predicate.not( String::isEmpty ))
                                     .filter( Predicate.not( String::isBlank ))
                                     .orElse( this.sobrenome );
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
        this.idade = idade >= 0 ? idade : this.idade;
    }


    /* ----------------------- */
    /* .::Equals e Hashcode::. */
    /* ----------------------- */
    // Principalmente utilizado como parâmetro de remoção de duplicatas em mapas e/ou conjuntos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PessoaFísica that = (PessoaFísica) o;

        return getCPF().equals(that.getCPF());
    }

    @Override
    public int hashCode() {
        return getCPF().hashCode();
    }




    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.

    @Override
    public String toString() {

        PrintUtils printUtils = new PrintUtils();

        /* Informações da Tabela */
        String titulo       = "DADOS DE " + getNome();
        List<String> header = Arrays.asList(" CAMPO ", " VALOR ");

        String campoCPF              = " CPF: ",                CPF = getCPF();
        String campoNome             = " Nome: ",               nome = getNome();
        String campoSobrenome        = " Sobrenome: ",          sobrenome = getSobrenome();
        String campoDataDeNascimento = " Data de Nascimento: ", dataDeNascimento = getDataDeNascimento();
        String campoIdade            = " Idade: ",              idade = String.format("%d", getIdade());
        List<String> linha1 = Arrays.asList(campoCPF, CPF);
        List<String> linha2 = Arrays.asList(campoNome, nome);
        List<String> linha3 = Arrays.asList(campoSobrenome, sobrenome);
        List<String> linha4 = Arrays.asList(campoDataDeNascimento, dataDeNascimento);
        List<String> linha5 = Arrays.asList(campoIdade, idade);
        List<List<String>> linhas = Arrays.asList(linha1, linha2, linha3, linha4, linha5);

        /* Dimensões da Tabela */
        int quantidadeDeColunas = header.size();
        int larguraDoCampo      = campoDataDeNascimento.length();
        int larguraDoValor      = Math.max( Math.max(CPF.length(), nome.length()), Math.max(sobrenome.length(), dataDeNascimento.length()) ) + 2;
        int larguraDaTabela     = Math.max((larguraDoCampo + larguraDoValor), titulo.length() ) + (quantidadeDeColunas + 1);
        int larguraDoTitulo     = larguraDaTabela - 2;
        int alturaDoTitulo      = printUtils.quantidadeDeLinhas(titulo);

        List<Integer> largurasDasLinhas = Arrays.asList(larguraDoCampo, larguraDoValor);
        List<Integer> alinhamentos = Arrays.asList(
                Block.DATA_MIDDLE_LEFT,
                Block.DATA_MIDDLE_LEFT
        );

        /* Construção da Tabela */
        Board tabela = new Board(larguraDaTabela);
        tabela.setInitialBlock(new Block(tabela, larguraDoTitulo, alturaDoTitulo, titulo).setDataAlign(Block.DATA_CENTER));
        tabela.appendTableTo(0, Board.APPEND_BELOW, new Table(tabela, larguraDaTabela, header, linhas, largurasDasLinhas).setColAlignsList(alinhamentos));
        return tabela.invalidate().build().getPreview();
    }


    /* ------------------------ */
    /* .::Métodos auxiliares::. */
    /* ------------------------ */

    /**
     * <h1>CPF Válido</h1>
     *
     * <p>Verifica se um determinado CPF é válido.</p>
     *
     * <p>Analisa se a quantidade de números está correta, se não possui algum caractere diferente além de números
     * e se não são todos iguais.</p>
     *
     * @param CPF Uma String contendo apenas números representando um CPF.
     * @return Valor booleano. True se for, False caso contrário.
     */
    private boolean CPFVálido(String CPF) {
        return  ( CPF.length() == 11 ) &&
                ( CPF.replaceAll(String.valueOf(CPF.charAt(0)), "").length() > 0 ) &&
                ( stringNuméricaVálida(CPF) );
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
