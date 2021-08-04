import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class VendaTest {

    @Test
    public void ExcecaoParaUmClienteNulo() {
        try {
            Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
            Venda venda = new Venda("02/05/2000", null, produto, 20);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Cliente indisponível!", e.getMessage());
        }
    }

}

