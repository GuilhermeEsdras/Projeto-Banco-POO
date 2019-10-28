package com.guilherme.agência;

// Outros módulos
import com.guilherme.funcionário.Funcionário;
import com.guilherme.funcionário.caixa.Caixa;
import com.guilherme.funcionário.gerente.Gerente;
import com.guilherme.pessoa.Endereço;
import com.guilherme.pessoa.enums.Estado;

// Hamcrest
import org.hamcrest.*;

// JUnit
import org.junit.*;


public class AgênciaTest {

    static final Funcionário caixa = new Caixa();

    @Test
    public void testDeveCadastrarFuncionário() {

    }

    @Test
    public void testNãoDeveCadastrarFuncionárioDuplicado() {

    }

    @Test
    public void testDeveCadastrarCliente() {

    }

    @Test
    public void testNãoDeveCadastrarClienteDuplicado() {

    }


}