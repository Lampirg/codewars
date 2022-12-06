package Main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfDivided {
    public static String sumOfDivided(int[] l) {
        int max = Arrays.stream(l).map(Math::abs).max().orElseThrow(IllegalArgumentException::new);
        List<Integer> primes = primeNumbersTill(max);
        return primes.stream()
                .filter(x -> (Arrays.stream(l).filter(e -> e % x == 0).findAny()).isPresent())
                .map(x -> String.format("(%d %d)",
                        x,
                        Arrays.stream(l).filter(e -> e % x == 0).sum()
                        ))
                .collect(Collectors.joining());
    }

    private static List<Integer> primeNumbersTill(int number) {
        return IntStream.rangeClosed(2, number)
                .filter(SumOfDivided::isPrime)
                .filter(x -> number / x >= 2 || number / x == 1)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number)).allMatch(x -> number % x != 0);
    }
}
