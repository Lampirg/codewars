import java.util.HashSet;
import java.util.Random;
import java.util.Stack;
import java.nio.CharBuffer;
import java.util.List;

public class ThrowWithoutThrowing {
    public static void arrayIndexOutOfBound() {
        Object array[] = new Object[0];
        array[2].equals(null);
    }

    public static void negativeArraySize() {
        Object array[] = new Object[-1];
    }

    public static void noSuchElement() {
        new HashSet<Object>().iterator().next();
    }

    public static void arithmetic() {
        int x = 4 / 0;
    }

    public static void classCast() {
        Integer number = ((Integer) new Object());
    }

    public static void stackOverflow() {
        while (true)
            stackOverflow();
    }

    public static void nullPointer() {
        Object object = null;
        object.hashCode();
    }

    public static void numberFormat() {
        Integer.parseInt("av");
    }

    public static void illegalArgument() {
        new Random().nextInt(0);
    }

    public static void emptyStack() {
        new Stack().pop();
    }

    public static void bufferOverflow() {
        CharBuffer buf = CharBuffer.allocate(0);
        buf.put("text");
    }

    public static void arrayStore() {
        Object x[] = new String[1];
        x[0] = new Integer(0);
    }

    public static void unsupportedOperation() {
        List<Object> list = List.of();
        list.add(null);
    }

    public static void illegalState() {
        new HashSet<Object>().iterator().remove();
    }
}
