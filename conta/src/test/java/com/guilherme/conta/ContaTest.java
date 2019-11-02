package com.guilherme.conta;

import com.guilherme.conta.contacorrente.ContaCorrente;
import com.guilherme.conta.exceptions.QuantiaNegativaException;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;
import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

import org.junit.*;

public class ContaTest {

    // Dado que...
    ContaCorrente contaCorrente;

    @Before
    public void setUp() {
        contaCorrente = new ContaCorrente( new PessoaFísica() );
    }

    @Test
    public void testGetSetTitular() {
        // quando...
        PessoaFísica pessoaFísica = new PessoaFísica();
        contaCorrente.setTitular(pessoaFísica);

        // certifique-se...
        Assert.assertEquals(pessoaFísica, contaCorrente.getTitular());
    }

    @Test
    public void testGetSetSaldo() {
        // Test default
        Assert.assertEquals(Conta.SALDO_INICIAL, contaCorrente.getSaldo(), 0);

        double quantiaVálida = 1000D;
        double quantiaInválida = -100D;

        // quando...
        contaCorrente.setSaldo(quantiaVálida);

        // evite...
        contaCorrente.setSaldo(quantiaInválida);

        // certifique-se...
        Assert.assertEquals(quantiaVálida, contaCorrente.getSaldo(), 0);
    }

    @Test(expected = QuantiaNegativaException.class)
    public void testServiçoDeSaque() {

        ContaCorrente contaCorrente2 = new ContaCorrente(new PessoaFísica());
        contaCorrente2.setSaldo(1500D);
        double saldoAnterior = contaCorrente2.getSaldo();

        // quando...
        double valorSacado = contaCorrente2.sacar(500D);

        // evite...
        double valorIlegal = contaCorrente2.sacar(-500D);

        // certifique-se...
        double saldoEsperado = saldoAnterior - (valorSacado + (contaCorrente2.getTaxaDeSaque() * valorSacado));
        Assert.assertEquals(saldoEsperado, contaCorrente2.getSaldo(), 0);
    }

    @Test
    public void testServiçoDeDepósito() {

        ContaCorrente contaCorrente3 = new ContaCorrente(new PessoaJurídica());

        double saldoAnterior = contaCorrente3.getSaldo();
        double quantia = 1000D;
        contaCorrente3.depositar(quantia);
        double saldoEsperado = saldoAnterior + quantia;

        Assert.assertEquals(saldoEsperado, contaCorrente3.getSaldo(), 0);
    }


//    @Test
//    public void testServiçoDeTransferência() {
//
//    }

//    @Test
//    public void testServiçoDeExtrato() {
//
//    }

}