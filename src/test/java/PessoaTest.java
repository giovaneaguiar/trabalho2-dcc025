import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void deveRetornarExcecaoNomePessoaNulo() {
        try {
            Pessoa pessoa = new Pessoa(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome nulo!", e.getMessage());
        }
    }
}