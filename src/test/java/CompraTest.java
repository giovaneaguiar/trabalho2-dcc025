import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CompraTest {

    @Test
    public void deveRetornarExcecaoPrecoUnitarioIndisponivel()
    {
        try {
            Fornecedor fornecedor = new Fornecedor("Nike","123456");
            Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
            Compra compra = new Compra("02/05/2000", produto,fornecedor,78,-20);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Preço unitário indisponível", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoFornecedorIndisponivel()
    {
        try {
            Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
            Compra compra = new Compra("02/05/2000", produto,null,2,100);
            fail();
        }
        catch (NullPointerException e)
        {
            assertEquals("Valor de fornecedor indisponível", e.getMessage());
        }
    }

}