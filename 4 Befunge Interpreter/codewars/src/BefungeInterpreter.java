import java.util.*;

public class BefungeInterpreter {

    Deque<Integer> stack = new ArrayDeque<>();

    private char[][] matrix;

    private int xCoordinate;
    private int yCoordinate;



    private Direction direction;

    private boolean hasEnded;
    private boolean stringWriting;

    private StringBuilder output;
    private boolean trampoline;

    public String interpret(String code) {
        matrix = createMatrix(code);
        fillMatrix(code);
        clear();
        runProgram();
        return new String(output);
    }

    private void runProgram() {
        char current;
        while (true) {
            if (trampoline) {
                trampoline = false;
                move();
                continue;
            }
            current = matrix[yCoordinate][xCoordinate];
            if (stringWriting)
                pushChar(current);
            else if (Character.isDigit(current))
                pushNumber(current);
            else switch (current) {
                case '+' -> addition();
                case '-' -> subtraction();
                case '*' -> multiplication();
                case '/' -> division();
                case '%' -> modulo();
                case '!' -> logicalNot();
                case '`' -> greaterThan();
                case '>' -> direction = Direction.RIGHT;
                case '<' -> direction = Direction.LEFT;
                case '^' -> direction = Direction.UP;
                case 'v' -> direction = Direction.DOWN;
                case '?' -> direction = Direction.random();
                case '_' -> rightOrLeft();
                case '|' -> downOrUp();
                case '"' -> stringWriting = true;
                case ':' -> duplicate();
                case '\\' -> swap();
                case '$' -> stack.pop();
                case '.' -> output.append(stack.pop());
                case ',' -> output.append((char)stack.pop().intValue());
                case '#' -> trampoline = true;
                case 'p' -> put();
                case 'g' -> get();
                case '@' -> hasEnded = true;
                case ' ' -> {}
                default -> throw new AssertionError();
            }
            if (hasEnded)
                return;
            move();
        }
    }

    private void get() {
        int y = stack.pop();
        int x = stack.pop();
        stack.push((int) matrix[y][x]);
    }

    private void put() {
        int y = stack.pop();
        int x = stack.pop();
        int v = stack.pop();
        matrix[y][x] = (char) v;
    }

    private void swap() {
        int higher = stack.pop();
        int lower;
        if (stack.peek() == null)
            lower = 0;
        else
            lower = stack.pop();
        stack.push(higher);
        stack.push(lower);
    }

    private void duplicate() {
        if (stack.peek() == null)
            stack.push(0);
        else
            stack.push(stack.peek());
    }

    private void downOrUp() {
        if (stack.pop() == 0)
            direction = Direction.DOWN;
        else
            direction = Direction.UP;
    }

    private void rightOrLeft() {
        if (stack.pop() == 0)
            direction = Direction.RIGHT;
        else
            direction = Direction.LEFT;
    }

    private void move() {
        xCoordinate += direction.x;
        yCoordinate += direction.y;
    }

    private void pushChar(char current) {
        if (current == '"') {
            stringWriting = false;
            return;
        }
        stack.push((int) current);
    }

    private void pushNumber(char current) {
        stack.push(Character.digit(current, 10));
    }

    private void addition() {
        stack.push(stack.pop() + stack.pop());
    }

    private void subtraction() {
        int subtrahend = stack.pop();
        int minuend = stack.pop();
        stack.push(minuend - subtrahend);
    }

    private void multiplication() {
        stack.push(stack.pop() * stack.pop());
    }

    private void division() {
        int divider = stack.pop();
        int dividend = stack.pop();
        if (divider == 0)
            stack.push(0);
        else
            stack.push(dividend / divider);
    }

    private void modulo() {
        int divider = stack.pop();
        int dividend = stack.pop();
        if (divider == 0)
            stack.push(0);
        else
            stack.push(dividend % divider);
    }

    private void logicalNot() {
        if (stack.pop() == 0)
            stack.push(1);
        else
            stack.push(0);
    }

    private void greaterThan() {
        int a = stack.pop();
        int b = stack.pop();
        if (b > a)
            stack.push(1);
        else
            stack.push(0);
    }

    private char[][] createMatrix(String code) {
        int maxYSize = 1;
        List<Integer> xSizes = new ArrayList<>();
        int thisXSize = 0;
        for (char character : code.toCharArray()) {
            if (character == '\n') {
                xSizes.add(thisXSize);
                thisXSize = 0;
                maxYSize++;
                continue;
            }
            thisXSize++;
        }
        xSizes.add(thisXSize);
        char[][] chars = new char[maxYSize][];
        for (int i = 0; i < maxYSize; i++) {
            chars[i] = new char[xSizes.get(i)];
        }
        return chars;
    }

    private void fillMatrix(String code) {
        int i = 0, j = 0;
        for (char character : code.toCharArray()) {
            if (character == '\n') {
                i++;
                j = 0;
                continue;
            }
            matrix[i][j++] = character;
        }
    }

    private void clear() {
        xCoordinate = 0;
        yCoordinate = 0;
        direction = Direction.RIGHT;
        hasEnded = false;
        stringWriting = false;
        trampoline = false;
        output = new StringBuilder();
    }

    private enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private int x;
        private int y;
        private static final Random RANDOM = new Random();

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Direction random() {
            Direction[] directions = values();
            return directions[RANDOM.nextInt(directions.length)];
        }
    }

}