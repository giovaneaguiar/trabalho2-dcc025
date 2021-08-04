import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    @Test
    void deveRetornarExcecaoCnpjNulo() {
        try {
            Fornecedor fornecedor = new Fornecedor("Giovane", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CNPJ Nulo!", e.getMessage());
        }
    }
}