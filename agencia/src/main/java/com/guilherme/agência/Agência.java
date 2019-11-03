package com.guilherme.agência;

// Outros módulos
import com.guilherme.agência.exceptions.CódigoAgênciaInválidoException;
import com.guilherme.cliente.ClientePessoaFísica;
import com.guilherme.cliente.ClientePessoaJurídica;
import com.guilherme.funcionário.Funcionário;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java utils
import java.util.*;


/**
 * <h1>Agência</h1>
 *
 * <p>Classe que modela objeto do tipo Agência.</p>
 * <p>Possui um código de 4 dígitos para fins de autenticação, uma lista de Funcionários, uma lista de Clientes do
 * tipo PessoaFísica e outra do tipo PessoaJurídica.</p>
 * <p>Fica responsável por cadastrar e armazenar os Clientes e Funcionários de seu Banco.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public class Agência extends PessoaJurídica implements Comparable<Agência> {

    /* Atributos */
    private String código;
    private Set<Funcionário> listaDeFuncionários;
    private Set<ClientePessoaFísica> listaDeClientesPessoaFísica;
    private Set<ClientePessoaJurídica> listaDeClientesPessoaJurídica;


    /* Atributos default */
    static final String AGÊNCIA_SEM_CÓDIGO = "0000";


    /* ------------------ */
    /* .::Construtores::. */
    /* ------------------ */

    { // Bloco de inicialização de instância
        this.setListaDeFuncionários ( new HashSet<>() );
        this.setListaDeClientesPessoaFísica( new HashSet<>() );
        this.setListaDeClientesPessoaJurídica( new HashSet<>() );
    }

    // Construtor simples
    public Agência() {
        super();
        this.setCódigo( AGÊNCIA_SEM_CÓDIGO );
    }

    public Agência(String código) {
        super();
        this.setCódigo(código);
    }

    // Construtor completo
    public Agência(String email, String login, String senha,             // <-- Usuário
                   Endereço endereço, String telefone,                   // <-- Pessoa
                   String CNPj, String nomeFantasia, String razãoSocial, // <-- PessoaJurídica
                   String código)
    {
        super(  email, login, senha,
                endereço, telefone,
                CNPj, nomeFantasia, razãoSocial
        );
        this.setCódigo(código);
    }


    /* ----------------------- */
    /* .::Getters e Setters::. */
    /* ----------------------- */

    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        if (StringUtils.isNumeric(código) && (código.length() > 0 && código.length() <= 4) ) {
            this.código = código;
        } else {
            throw new CódigoAgênciaInválidoException();
        }
    }


    /* --------------------------------- */
    /* .::Manipulação de Funcionários::. */
    /* --------------------------------- */

    public Set<Funcionário> getListaDeFuncionários() {
        return listaDeFuncionários;
    }

    public void setListaDeFuncionários(Set<Funcionário> listaDeFuncionários) {
        this.listaDeFuncionários = listaDeFuncionários;
    }

    public boolean cadastrarFuncionário(Funcionário funcionário) {
        for (Funcionário func : getListaDeFuncionários()) {
            if ( func.getID().equals(funcionário.getID()) ) {
                return false;
            }
        }
        return getListaDeFuncionários().add( funcionário );
    }

    public boolean removerFuncionário(Funcionário funcionário) {
        return getListaDeFuncionários().remove( funcionário );
    }

    public int getQuantidadeDeFuncionários() {
        return this.getListaDeFuncionários().size();
    }


    /* -------------------------------------------- */
    /* .::Manipulação de Clientes (PessoaFísica)::. */
    /* -------------------------------------------- */

    public Set<ClientePessoaFísica> getListaDeClientesPessoaFísica() {
        return listaDeClientesPessoaFísica;
    }

    public void setListaDeClientesPessoaFísica(Set<ClientePessoaFísica> listaDeClientesPessoaFísica) {
        this.listaDeClientesPessoaFísica = listaDeClientesPessoaFísica;
    }

    public boolean cadastrarClientePessoaFísica(ClientePessoaFísica cliente) {
        return getListaDeClientesPessoaFísica().add( cliente );
    }

    public boolean removerClientePessoaFísica(ClientePessoaFísica cliente) {
        return getListaDeClientesPessoaFísica().remove( cliente );
    }

    public int getQuantidadeDeClientesPessoaFísica() {
        return this.getListaDeClientesPessoaFísica().size();
    }

    /* Comparators/Ordenadores de PessoaFísica */

    public Comparator<ClientePessoaFísica> comparaPorNome = (pF1, pF2) ->
            pF1.getPessoaFísica().getNome().compareTo(pF2.getPessoaFísica().getNome());

    public Comparator<ClientePessoaFísica> comparaPorIdade = (pF1, pF2) ->
            pF1.getPessoaFísica().getDataDeNascimento().compareTo(pF2.getPessoaFísica().getDataDeNascimento());



    /* ---------------------------------------------- */
    /* .::Manipulação de Clientes (PessoaJurídica)::. */
    /* ---------------------------------------------- */

    public Set<ClientePessoaJurídica> getListaDeClientesPessoaJurídica() {
        return listaDeClientesPessoaJurídica;
    }

    public void setListaDeClientesPessoaJurídica(Set<ClientePessoaJurídica> listaDeClientesPessoaJurídica) {
        this.listaDeClientesPessoaJurídica = listaDeClientesPessoaJurídica;
    }

    public boolean cadastrarClientePessoaJurídica(ClientePessoaJurídica cliente) {
        return getListaDeClientesPessoaJurídica().add( cliente );
    }

    public boolean removerClientePessoaJurídica(ClientePessoaJurídica cliente) {
        return getListaDeClientesPessoaJurídica().remove( cliente );
    }

    public int getQuantidadeDeClientesPessoaJurídica() {
        return this.getListaDeClientesPessoaJurídica().size();
    }

    /* Comparators/Ordenadores de PessoaJurídica */

    public Comparator<ClientePessoaJurídica> comparaPorNomeFantasia = (pJ1, pJ2) ->
            pJ1.getPessoaJurídica().getNomeFantasia().compareTo(pJ2.getPessoaJurídica().getNomeFantasia());

    public Comparator<ClientePessoaJurídica> comparaPorRazãoSocial = (pJ1, pJ2) ->
            pJ1.getPessoaJurídica().getRazãoSocial().compareTo(pJ2.getPessoaJurídica().getRazãoSocial());


    /* ---------------------------------------- */
    /* .::Manipulação de Clientes (Genérico)::. */
    /* ---------------------------------------- */

    public int getQuantidadeDeClientesTotal() {
        return this.getQuantidadeDeClientesPessoaFísica() + this.getQuantidadeDeClientesPessoaJurídica();
    }


    /* ----------------------- */
    /* .::Equals e Hashcode::. */
    /* ----------------------- */
    // Principalmente utilizado como parâmetro de remoção de duplicatas em mapas e/ou conjuntos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agência agência = (Agência) o;

        return getCódigo().equals(agência.getCódigo());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCódigo());
    }


    /* ---------------- */
    /* .::Comparador::. */
    /* ---------------- */
    // Principalmente utilizado como parâmetro de ordenação em árvores de mapas e/ou de conjuntos.

    @Override
    public int compareTo(Agência outraAgência) {
        return getCódigo().compareTo(outraAgência.getCódigo());
    }


    /* -------- */
    /* toString */
    /* -------- */
    // Dados do objeto em formato String.


    @Override
    public String toString() {
        return "Agência{" +
                "código='" + código + '\'' +
                ", listaDeFuncionários=" + listaDeFuncionários +
                ", listaDeClientesCPF=" + listaDeClientesPessoaFísica +
                ", listaDeClientesCNPj=" + listaDeClientesPessoaJurídica +
                '}';
    }
}
