import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RectanglesUnion {
    public static int calculateSpace(int[][] arrayRectangles) {
        if (arrayRectangles == null || arrayRectangles.length == 0)
            return 0;
        List<Rectangle> rectangles = new ArrayList<>();
        for (int[] rectangle : arrayRectangles) {
            rectangles.add(new Rectangle(rectangle));
        }
        int square = 0;
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= squares.size(); i++) {
            List<List<Integer>> combinationsOfSquares = combination(squares, i);
            int sum = i % 2 != 0 ? 1 : -1;
            sum *= combinationsOfSquares.stream().flatMap(List::stream).mapToInt(Integer::intValue).sum();
            square += sum;
        }
        return square;
    }

    // Took from here: https://stackoverflow.com/questions/5162254/all-possible-combinations-of-an-array
    public static List<Integer> combination(List<List<Integer>> rectangles, int size) {

        if (0 == size) {
            return Collections.emptyList();
        }

        if (rectangles.size() == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> combination = new ArrayList<>();

        List<Integer> actual = rectangles.iterator().next();

        List<T> subSet = new ArrayList<>(rectangles);
        subSet.remove(actual);

        List<List<T>> subSetCombination = combination(subSet, size - 1);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new ArrayList<>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(combination(subSet, size));

        return combination;
    }
}

class Rectangle {
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle(int[] rectangle) {
        this.x1 = rectangle[0];
        this.y1 = rectangle[1];
        this.x2 = rectangle[2];
        this.y2 = rectangle[3];
    }

    public int getSquare() {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}