// Kata submit checker prohibits using BigInteger(
public class Kata {

    private final static int RADIX = 10;

    public static String add(String a, String b) {
        a = removeLeadingZeroes(a);
        b = removeLeadingZeroes(b);
        StringBuilder sum;
        String min;
        if (a.length() > b.length()) {
            sum = new StringBuilder(a);
            min = b;
        }
        else {
            sum = new StringBuilder(b);
            min = a;
        }
        min = fillZeroes(min, sum.length());
        for (int i = min.length() - 1; i >= 0; i--) {
            sum(sum, i, Character.digit(min.charAt(i), RADIX));
        }
        return sum.toString();
    }

    private static String removeLeadingZeroes(String string) {
        int i = 0;
        while (string.charAt(i) == '0')
            i++;
        return string.substring(i);
    }

    private static String fillZeroes(String min, int upTo) {
        StringBuilder filler = new StringBuilder(min);
        while (filler.length() < upTo)
            filler.insert(0, '0');
        return filler.toString();
    }

    private static void addPower(StringBuilder string, int index) {
        if (index < 0) {
            string.insert(0, '1');
            return;
        }
        sum(string, index, 1);
    }

    private static void sum(StringBuilder string, int index, int x) {
        int digitSum = Character.digit(string.charAt(index), RADIX) + x;
        string.setCharAt(index, Character.forDigit(digitSum % 10, RADIX));
        if (digitSum >= 10)
            addPower(string, index - 1);
    }
}