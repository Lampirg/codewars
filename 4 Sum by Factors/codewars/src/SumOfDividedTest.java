import static org.junit.Assert.*;

import Main.SumOfDivided;
import org.junit.Test;

public class SumOfDividedTest {

    @Test
    public void testOne() {
        int[] lst = new int[] {12, 15};
        assertEquals("(2 12)(3 27)(5 15)", SumOfDivided.sumOfDivided(lst));
    }

    @Test
    public void testTwo() {
        int[] lst = new int[] {107, 158, 204, 100, 118, 123, 126, 110, 116, 100};
        assertEquals("(2 1032)(3 453)(5 310)(7 126)(11 110)" +
                                "(17 204)(29 116)(41 123)(59 118)(79 158)(107 107)",
                        SumOfDivided.sumOfDivided(lst));
    }

    @Test
    public void testThree() {
        int[] lst = new int[] {17, -17, 51, -51};
        assertEquals("(3 0)(17 0)", SumOfDivided.sumOfDivided(lst));
    }
}
