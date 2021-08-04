import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdutoTest {
    @Test
    public void deveRetornarExcecaoNomeIndisponivel() {
        try {
            Produto produto = new Produto(null, 30, 100, 0, 50);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Não é possível utilizar esse nome!", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoEstoqueMinimoIndisponivel() {
        try {
            Produto produto = new Produto("Tênis Branco", 30, 100, -1, 50);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor de estoque mínimo indisponível!", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoEstoqueMaximoIndisponivel() {
        try {
            Produto produto = new Produto("Tênis Branco", 30, 100, 0, -20);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor de estoque máximo indisponível!", e.getMessage());
        }
    }

    @Test
    public void deveRetornarRegistroNoHistorico() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        Cliente cliente = new Cliente("Giovane Aguiar", "123456");
        Fornecedor fornecedor = new Fornecedor("Nike", "789");
        produto.vender("02/05/2000", cliente, 3);
        produto.comprar("02/05/2000", fornecedor, 3, 100);

        List<String> historico = Arrays.asList("Transacao: Vendido Tênis Branco", "Transacao: Comprado Tênis Branco", "02/05/2000", "3");
        // Arrays.asList()
        //Retorna uma lista de tamanho fixo suportada pela matriz especificada.
        assertEquals(historico, produto.exibirHistorico());
    }

    @Test
    public void deveRetornarSemValorNoHistorico() {
        try {
            Produto produto = new Produto("Tênis Branco", 30, 100, 0, 20);
            produto.exibirHistorico();

        } catch (NullPointerException e) {
            assertEquals("Sem valor no histórico", e.getMessage());
        }
    }

    @Test
    public void deveDebitarDoEstoque() {
        Produto produto = new Produto("Tênis Branco", 30 , 100, 0, 50);
        produto.debitarEstoque(8);

        assertEquals(22, produto.getQtdeEstoque());
    }

    @Test
    public void deveCreditarDoEstoque() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        produto.creditarEstoque(10);

        assertEquals(40, produto.getQtdeEstoque());
    }

    @Test
    public void deveRetornarDebitoInvalidoEstoque() {
        try {
            Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
            produto.debitarEstoque(100);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade não válida", e.getMessage());
        }
    }

    @Test
    public void deveRetornarEstoqueInsuficiente() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 5, 50);
        assertTrue(produto.verificarEstoqueInsuficiente(40));
    }

    @Test
    public void deveRetornarEstoqueBaixo() {
        Produto produto = new Produto("Tênis Branco", 10, 100, 12, 50);
        assertTrue(produto.verificarEstoqueBaixo());
    }

    @Test
    public void deveRetornarEstoqueExcedente() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 12, 50);
        assertTrue(produto.verificarEstoqueExcedente(30));
    }

    @Test
    public void deveRetornarValorVenda() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        assertEquals(500, produto.calculaValorVenda(5));
    }

    @Test
    public void deveRetornarValorVendaErrado() {
        try {
            Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
            produto.calculaValorVenda(-20);
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade errada!", e.getMessage());
        }
    }

    @Test
    public void deveRetornarHistoricoDaVenda() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        Cliente cliente = new Cliente("Giovane Aguiar", "123456");
        produto.vender("02/05/2000", cliente, 2);
        List<String> historico = Arrays.asList("Transacao: Vendido Tênis Branco");
        //Arrays.asList()
        //Retorna uma lista de tamanho fixo suportada pela matriz especificada.
        assertEquals(historico, produto.exibirHistorico());
    }

    @Test
    public void deveRetornarHistoricoDaCompra() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        Fornecedor fornecedor = new Fornecedor("Luciana de Sousa", "789000");
        produto.comprar("02/05/2000", fornecedor, 5, 1);
        List<String> historico = Arrays.asList("Transacao: Comprado Tênis Branco", "02/05/2000", "5");
        //Arrays.asList()
        //Retorna uma lista de tamanho fixo suportada pela matriz especificada.
        assertEquals(historico, produto.exibirHistorico());
    }

    @Test
    public void deveDebitarVendaEstoque() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        Cliente cliente = new Cliente("Giovane Aguiar", "123456");
        produto.vender("02/05/2000", cliente, 10);

        assertEquals(20, produto.getQtdeEstoque());
    }

    @Test
    public void deveRetornarEstoqueInsuficientePorUmaVenda() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        Cliente cliente = new Cliente("Giovane Aguiar", "123456");
        produto.vender("02/05/2000", cliente, 40);

        List<String> historico = Arrays.asList("Estoque insuficiente!");
        assertEquals(historico, produto.exibirHistorico());
    }

    @Test
    public void deveRetornarEstoqueExcedentePorUmaCompra() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
        Fornecedor fornecedor = new Fornecedor("Giovane Aguiar", "123456");
        produto.comprar("02/05/2000", fornecedor, 30, 100);
        List<String> historico = Arrays.asList("Excedente!");
        assertEquals(historico, produto.exibirHistorico());
    }

    @Test
    public void deveRetornarEstoqueBaixoPorUmaVenda() {
        Produto produto = new Produto("Tênis Branco", 30, 100, 10, 50);
        Cliente cliente = new Cliente("Giovane Aguiar", "123456");
        produto.vender("02/05/2000", cliente, 25);

        List<String> historico = Arrays.asList("Transacao: Vendido Tênis Branco", "Estoque baixo!", "02/05/2000", "25");
        assertEquals(historico, produto.exibirHistorico());
    }


}