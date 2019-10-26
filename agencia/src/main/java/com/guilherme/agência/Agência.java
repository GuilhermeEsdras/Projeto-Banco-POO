package com.guilherme.agência;

// Outros módulos
import com.guilherme.cliente.ClientePessoaFísica;
import com.guilherme.cliente.ClientePessoaJurídica;
import com.guilherme.funcionário.Funcionário;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java utils
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Classe que modelo objeto do tipo Agência.</p>
 * <p>Possui um código de 4 dígitos para fins de autenticação, uma lista de Funcionários, uma lista de Clientes do
 * tipo PessoaFísica e outra do tipo PessoaJurídica.</p>
 * <p>Fica responsável por cadastrar e armazenar os Clientes e Funcionários de seu Banco.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public class Agência extends PessoaJurídica implements Comparable<Agência> {

    /* Atributos de um Banco */
    private String código;
    private Set<Funcionário> listaDeFuncionários;
    private Set<ClientePessoaFísica> listaDeClientesCPF;
    private Set<ClientePessoaJurídica> listaDeClientesCNPj;


    /* .::Construtores::. */

    {
        this.setListaDeFuncionários(new TreeSet<>());
        this.setListaDeClientesCPF(new TreeSet<>());
        this.setListaDeClientesCNPj(new TreeSet<>());
    }

    public Agência(Endereço endereço, String telefone, // Construtor de Pessoa
                   String CNPj, String nomeFantasia, String razãoSocial, // Construtor de PessoaJurídica
                   String código)
    {
        super(endereço, telefone, CNPj, nomeFantasia, razãoSocial);
        this.setCódigo(código);
    }

    // <editor-fold defaultstate="collapsed" desc=".::Getters e Setters do Código::.">
    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        if (StringUtils.isNumeric(código)) {
            if (código.length() > 0 && código.length() <= 4) {
                this.código = código;
            }
        }
    }
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc=".::Métodos referentes a Funcionários::.">
    public Set<Funcionário> getListaDeFuncionários() {
        return listaDeFuncionários;
    }

    public void setListaDeFuncionários(Set<Funcionário> listaDeFuncionários) {
        this.listaDeFuncionários = listaDeFuncionários;
    }

    public boolean cadastrarFuncionário(Funcionário funcionário) {
        return true;
    }

    public int getQuantidadeDeFuncionários() {
        return this.getListaDeFuncionários().size();
    }
    // </editor-fold>


    /* .::Métodos referentes a Clientes (PessoaFísica)::. */

    public Set<ClientePessoaFísica> getListaDeClientesCPF() {
        return listaDeClientesCPF;
    }

    public void setListaDeClientesCPF(Set<ClientePessoaFísica> listaDeClientesCPF) {
        this.listaDeClientesCPF = listaDeClientesCPF;
    }

    public boolean cadastrarClientePessoaFísica(ClientePessoaFísica cliente) {
        return true;
    }

    public int getQuantidadeDeClientesPessoaFísica() {
        return this.getListaDeClientesCPF().size();
    }


    /* .::Métodos referentes a Clientes (PessoaJurídica)::. */

    public Set<ClientePessoaJurídica> getListaDeClientesCNPj() {
        return listaDeClientesCNPj;
    }

    public void setListaDeClientesCNPj(Set<ClientePessoaJurídica> listaDeClientesCNPj) {
        this.listaDeClientesCNPj = listaDeClientesCNPj;
    }

    public boolean cadastrarClientePessoaJurídica(ClientePessoaJurídica cliente) {
        return true;
    }

    public int getQuantidadeDeClientesPessoaJurídica() {
        return this.getListaDeClientesCNPj().size();
    }

    /* .::Métodos referentes a Clientes (Genérico) */

    public int getQuantidadeDeClientesTotal() {
        return this.getQuantidadeDeClientesPessoaFísica() + this.getQuantidadeDeClientesPessoaJurídica();
    }


    /* .::Equals e Hashcode (para evitar duplicatas em Sets)::. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agência agência = (Agência) o;

        return getCódigo() == agência.getCódigo();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCódigo());
    }


    /* .::Comparador da interface Comparable (necessário para o ordenador do TreeSet)::. */
    @Override
    public int compareTo(Agência outraAgência) {
        return getCódigo().compareTo(outraAgência.getCódigo());
    }
}
