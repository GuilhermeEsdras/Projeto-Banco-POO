package com.guilherme.banco;

// Outros módulos
import com.guilherme.agência.Agência;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java utils
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


/**
 * <p>Classe que modela um objeto do tipo Banco.</p>
 * <p>Contém um código de 3 dígitos para fins de autenticação e uma lista de Agências.</p>
 * <p>Fica responsável por cadastrar e armazenar Agências, que, por sua vez, cadastram e armazenam os Clientes e
 * Funcionários do Banco.</p>
 *
 * @since 1.0
 * @author Guilherme Esdras
 * @version 1.0
 */
public class Banco extends PessoaJurídica {

    private String código;
    private Set<Agência> listaDeAgências;

    {
        this.setListaDeAgências(new TreeSet<>());
    }

    public Banco(Endereço endereço, String telefone,
                 String CNPj, String nomeFantasia, String razãoSocial,
                 String código)
    {
        super(endereço, telefone, CNPj, nomeFantasia, razãoSocial);
        this.setCódigo(código);
    }

    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        if (StringUtils.isNumeric(código)) {
            if (código.length() > 0 && código.length() <= 3) {
                this.código = código;
            }
        }
    }

    public Set<Agência> getListaDeAgências() {
        return listaDeAgências;
    }

    public void setListaDeAgências(Set<Agência> listaDeAgências) {
        this.listaDeAgências = listaDeAgências;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banco banco = (Banco) o;

        return getCódigo().equals(banco.getCódigo());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCódigo());
    }

    @Override
    public String toString() {
        return "Banco{" +
                "código=" + getCódigo() +
                ", listaDeAgências=" + listaDeAgências +
                '}';
    }
}
