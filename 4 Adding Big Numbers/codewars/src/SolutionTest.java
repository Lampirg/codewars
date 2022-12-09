import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class SolutionTest {
    @Test
    void basicTests() {
        assertEquals("2", Kata.add("1", "1"));
        assertEquals("579", Kata.add("123", "456"));
        assertEquals("1110", Kata.add("888", "222"));
        assertEquals("1441", Kata.add("1372", "69"));
        assertEquals("468", Kata.add("12", "456"));
        assertEquals("201", Kata.add("100", "101"));
        assertEquals("91002328220491911630239667963", Kata.add("63829983432984289347293874", "90938498237058927340892374089"));
        assertEquals("186622317460599456384", Kata.add("0186622310843435702041", "6617163754343"));
    }
}
