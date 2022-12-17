import java.math.BigInteger;
import java.util.stream.IntStream;

public class KataSolution {

    private record Input(int a, String x, int b, int n) {}

    public static String expand(String expr) {
        Input input = parseExpression(expr);
        return expand(input);
    }

    private static Input parseExpression(String expression) {
        int i = 1;

        StringBuilder a = new StringBuilder();
        if (expression.charAt(i) == '-')
            a.append(expression.charAt(i++));
        if (!Character.isDigit(expression.charAt(i)))
            a.append('1');
        while (Character.isDigit(expression.charAt(i)))
            a.append(expression.charAt(i++));

        StringBuilder x = new StringBuilder();
        while (Character.isAlphabetic(expression.charAt(i)))
            x.append(expression.charAt(i++));

        StringBuilder b = new StringBuilder();
        b.append(expression.charAt(i++));
        while (Character.isDigit(expression.charAt(i)))
            b.append(expression.charAt(i++));

        while (!Character.isDigit(expression.charAt(i)))
            i++;
        StringBuilder n = new StringBuilder();
        while (i < expression.length())
            n.append(expression.charAt(i++));

        return new Input(
                Integer.parseInt(a.toString()),
                x.toString(),
                Integer.parseInt(b.toString()),
                Integer.parseInt(n.toString())
        );
    }

    private static String expand(Input input) {
        return expand(input.a, input.x, input.b, input.n);
    }

    public static String expand(int a, String x, int b, int n) {
        if (n == 0)
            return "1";
        if (b == 0)
            return (long)Math.pow(a, n) + x + "^" + n;

        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < n; k++) {
            long coefficient = (long)(combinations(n, k) * Math.pow(a, n - k)*Math.pow(b, k));
            removeIfNegative(builder, coefficient);
            if (coefficient != 1 && coefficient != -1)
                builder.append(coefficient);
            if (coefficient == -1 && builder.length() == 0)
                builder.append('-');
            builder.append(x);
            if (n - k != 1)
                builder.append("^").append(n - k);
            builder.append("+");
        }
        long coefficient = (long) (combinations(n, n) * Math.pow(a, 0) * Math.pow(b, n));
        removeIfNegative(builder, coefficient);
        builder.append(coefficient);
        return builder.toString();
    }

    private static void removeIfNegative(StringBuilder builder, long res) {
        if (res < 0 && builder.length() != 0)
            builder.deleteCharAt(builder.length() - 1);
    }

    private static int combinations(int base, int group) {
        BigInteger result = factorial(base)
                .divide(
                        factorial(group).multiply(factorial(base-group))
                );
        return result.intValueExact();
    }

    private static BigInteger factorial(int number) {
        return IntStream.rangeClosed(1, number).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }
}