import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TransacaoTest {

    @Test
    public void deveRetornarExcecaoParaUmaDataIndisponivel() {
        try {

            Produto produto = new Produto("Tênis Branco", 30, 100, 0, 50);
            Transacao transacao = new Transacao(null, produto, 20);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Esta data de transação não é válida", e.getMessage());
        }
    }

}