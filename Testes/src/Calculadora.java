import java.math.BigDecimal;

public class Calculadora {
    public double soma(double a, double b) {
        return a + b;
    }

    public double somaDecimal(double a, double b) {
        BigDecimal soma = BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
        return soma.doubleValue();
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double div(double a, double b) {
        if (b == 0)
            throw new ArithmeticException();
        return a / b;
    }
}
