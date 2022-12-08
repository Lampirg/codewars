import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BefungeInterpreterTests {
    @Test
    public void tests() {
        assertEquals(
                "123456789",
                new BefungeInterpreter().interpret(">987v>.v\nv456<  :\n>321 ^ _@"));
        assertEquals("Hello World!\n", new BefungeInterpreter().interpret(
                ">              v\n" +
                "v  ,,,,,\"Hello\"<\n" +
                ">48*,          v\n" +
                "v,,,,,,\"World!\"<\n" +
                ">25*,@"));
        assertEquals("Hello, world!\n", new BefungeInterpreter().interpret(
                " >25*\"!dlrow ,olleH\":v\n" +
                        "                  v:,_@\n" +
                        "                  >  ^"));
    }


}
