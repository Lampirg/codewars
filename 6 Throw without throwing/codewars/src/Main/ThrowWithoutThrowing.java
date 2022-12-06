package Main;

import java.util.HashSet;

public class ThrowWithoutThrowing {
    public static void arrayIndexOutOfBound() {
        Object array[] = new Object[0];
        array[2].equals(null);
    }

    public static void negativeArraySize() {
        Object array[] = new Object[0];
        array[-1].equals(null);
    }

    public static void noSuchElement() {
        new HashSet().iterator().next();
    }

    public static void arithmetic() {
        int x = 4 / 0;
    }

    public static void classCast() {
    }

    public static void stackOverflow() {
    }

    public static void nullPointer() {
    }

    public static void numberFormat() {
    }

    public static void illegalArgument() {
    }

    public static void emptyStack() {
    }

    public static void bufferOverflow() {
    }

    public static void arrayStore() {
    }

    public static void unsupportedOperation() {
    }

    public static void illegalState() {
    }
}

