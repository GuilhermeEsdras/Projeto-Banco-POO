package com.guilherme.agência;

// Outros módulos
import com.guilherme.agência.exceptions.CódigoAgênciaInválidoException;
import com.guilherme.cliente.ClientePessoaFísica;
import com.guilherme.cliente.ClientePessoaJurídica;
import com.guilherme.funcionário.Funcionário;
import com.guilherme.funcionário.caixa.Caixa;
import com.guilherme.pessoa.pessoafísica.PessoaFísica;
import com.guilherme.pessoa.pessoajurídica.PessoaJurídica;

// Hamcrest
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

// JUnit
import org.junit.*;


public class AgênciaTest {

    /* Agência de teste */
    private Agência agência = new Agência();


    /* Clientes de teste */

    // Pessoas Físicas
    private static final ClientePessoaFísica clientePF1 = new ClientePessoaFísica( new PessoaFísica( "10220440567" ));
    private static final ClientePessoaFísica clientePF2 = new ClientePessoaFísica( new PessoaFísica( "20350948750" ));
    private static final ClientePessoaFísica clientePF3 = new ClientePessoaFísica( new PessoaFísica( "30541069025" ));
    private static final ClientePessoaFísica clientePF3_duplicado = new ClientePessoaFísica( new PessoaFísica( "30541069025" ));

    // Pessoas Jurídicas
    private static final ClientePessoaJurídica clientePJ1 = new ClientePessoaJurídica( new PessoaJurídica("11421546000132" ));
    private static final ClientePessoaJurídica clientePJ2 = new ClientePessoaJurídica( new PessoaJurídica("98774173000161" ));
    private static final ClientePessoaJurídica clientePJ3 = new ClientePessoaJurídica( new PessoaJurídica("80194210000105" ));
    private static final ClientePessoaJurídica clientePJ3_duplicado = new ClientePessoaJurídica( new PessoaJurídica("80194210000105" ));


    /* Funcionários de teste */
    private static final Funcionário caixa = new Caixa( "11452263378", 15 );
    private static final Funcionário caixa_duplicado = new Caixa( "11452263378", 15 );


    @Test(expected = CódigoAgênciaInválidoException.class)
    public void testGetSetCódigoAgência()
    {
        // Test default
        Assert.assertEquals(Agência.AGÊNCIA_SEM_CÓDIGO, agência.getCódigo());

        // Dado que...
        String códigoVálido   = "1234";

        // quando...
        agência.setCódigo(códigoVálido);

        // evite...
        agência.setCódigo( "05510" );
        agência.setCódigo( "abcd" );
        agência.setCódigo( "@2c8" );
        agência.setCódigo( "91" );

        // certifique-se...
        Assert.assertEquals(códigoVálido, agência.getCódigo());
    }

    @Test
    public void testDeveCadastrarClientes()
    {
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF1 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF2 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF3 ) );

        assertThat( agência.getListaDeClientesPessoaFísica(), containsInAnyOrder( clientePF1, clientePF2, clientePF3 ));
        assertThat( agência.getQuantidadeDeClientesPessoaFísica(), is( 3 ));


        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ1 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ2 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ3 ) );

        assertThat( agência.getListaDeClientesPessoaJurídica(), containsInAnyOrder( clientePJ1, clientePJ2, clientePJ3 ));
        assertThat( agência.getQuantidadeDeClientesPessoaJurídica(), is( 3 ));
    }

    @Test
    public void testDeveRemoverClientes()
    {
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF1 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF2 ) );
        Assert.assertTrue( agência.removerClientePessoaFísica( clientePF1 ) );
        Assert.assertTrue( agência.removerClientePessoaFísica( clientePF2 ) );

        assertThat( agência.getListaDeClientesPessoaFísica(), not( containsInAnyOrder( clientePF1, clientePF2 )));
        assertThat( agência.getQuantidadeDeClientesPessoaFísica(), is( 0 ));


        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ1 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ2 ) );
        Assert.assertTrue( agência.removerClientePessoaJurídica( clientePJ1 ));
        Assert.assertTrue( agência.removerClientePessoaJurídica( clientePJ2 ));

        assertThat( agência.getListaDeClientesPessoaJurídica(), not( containsInAnyOrder( clientePJ1, clientePJ2 )));
        assertThat( agência.getQuantidadeDeClientesPessoaJurídica(), is( 0 ));
    }

    @Test
    public void testNãoDeveCadastrarClientesDuplicados()
    {
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF1 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF2 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaFísica( clientePF3 ) );
        Assert.assertFalse( agência.cadastrarClientePessoaFísica( clientePF3_duplicado ) );

        assertThat( agência.getListaDeClientesPessoaFísica(), not( containsInAnyOrder( clientePF3_duplicado )));
        assertThat( agência.getQuantidadeDeClientesPessoaFísica(), is( 3 ));


        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ1 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ2 ) );
        Assert.assertTrue( agência.cadastrarClientePessoaJurídica( clientePJ3 ) );
        Assert.assertFalse( agência.cadastrarClientePessoaJurídica( clientePJ3_duplicado ) );

        assertThat( agência.getListaDeClientesPessoaJurídica(), not( containsInAnyOrder( clientePJ3_duplicado )));
        assertThat( agência.getQuantidadeDeClientesPessoaJurídica(), is( 3 ));
    }


    @Test
    public void testDeveCadastrarFuncionários() {
        Assert.assertTrue( agência.cadastrarFuncionário( caixa ));

        assertThat( agência.getListaDeFuncionários(), containsInAnyOrder( caixa ));
        assertThat( agência.getQuantidadeDeFuncionários(), is ( 1 ));
    }

    @Test
    public void testDeveRemoverFuncionários() {
        Assert.assertTrue( agência.cadastrarFuncionário( caixa ));
        Assert.assertTrue( agência.removerFuncionário( caixa ));

        assertThat( agência.getListaDeFuncionários(), not( containsInAnyOrder( caixa )) );
        assertThat( agência.getQuantidadeDeFuncionários(), is ( 0 ));
    }

}