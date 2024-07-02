import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Pilha<T> {
    List<T> pilha = new ArrayList<>();
    int tam = 0;

    // Retornar o tamanho da pilha
    public int size() {
        return tam;
    }

    // Empilhar
    public void push(T item) {
        pilha.add(item);
        tam++;
    }

    // Pilha Vazia
    public boolean isVazia() {
        return (size() == 0);
    }

    // Desempilhar
    public T pop() {
        if (isVazia())
            throw new EmptyStackException();
        T item = pilha.remove(tam - 1);
        tam--;
        return item;
    }
}
