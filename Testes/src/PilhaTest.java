import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class PilhaTest {
    Pilha pilha;

    @Before // Método executado antes de cada teste
    public void setUp() {
        pilha = new Pilha();
    }

    @Test
    public void testSize() {
        pilha.push(100);
        pilha.push(200);
        assertEquals(2, pilha.size());
    }

    @Test
    public void testPilhaVazia() {
        assertThrows(EmptyStackException.class, () -> pilha.pop());
    }

    @Test
    public void testEmpilharDesempilhar() {
        pilha.push(100);
        pilha.push(200);
        pilha.push(300);
        pilha.pop();
        pilha.pop();
        pilha.pop();
        assertEquals(0, pilha.size());
    }

}
