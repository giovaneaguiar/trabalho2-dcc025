import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveRetornarExcecaoCpfNulo() {
        try {
            Cliente cliente = new Cliente("Giovane", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CPF Nulo!", e.getMessage());
        }
    }
}