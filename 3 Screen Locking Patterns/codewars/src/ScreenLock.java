import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScreenLock {

    public int calculateCombinations(char startPosition, int patternLength) {
        if (startPosition < 'A' || startPosition > 'I')
            throw new IllegalArgumentException("Wrong starting letter");
        if (patternLength > 9 || patternLength < 1)
            return 0;
        if (patternLength == 1)
            return 1;
        Node startNode = null;
        for (Node node : Node.values()) {
            if (node.toString().equals(Character.toString(startPosition))) {
                startNode = node;
                break;
            }
        }
        List<List<Node>> routes = new ArrayList<>();
        for (Node node : availableNodes(List.of(Objects.requireNonNull(startNode)))) {
            routes.add(List.of(startNode, node));
        }
        for (int i = 2; i < patternLength; i++) {
            List<List<Node>> lists = new ArrayList<>();
            for (List<Node> list : routes) {
                lists.addAll(getPaths(list));
            }
            routes = lists;
        }
        return routes.size();
    }

    private static List<List<Node>> getPaths(List<Node> path) {
        List<List<Node>> lists = new ArrayList<>();
        for (Node node : availableNodes(path)) {
            List<Node> list = new ArrayList<>(path);
            list.add(node);
            lists.add(list);
        }
        return lists;
    }

    private static List<Node> availableNodes(List<Node> path) {
        List<Node> available = new ArrayList<>();

        List<Optional<Node>> probablyAvailable = new ArrayList<>();
        probablyAvailable.add(checkForDirection(path, i -> ++i, j -> j));
        probablyAvailable.add(checkForDirection(path, i -> --i, j -> j));
        probablyAvailable.add(checkForDirection(path, i -> i, j -> ++j));
        probablyAvailable.add(checkForDirection(path, i -> i, j -> --j));

        probablyAvailable.add(checkForDirection(path, i -> ++i, j -> ++j));
        probablyAvailable.add(checkForDirection(path, i -> --i, j -> --j));
        probablyAvailable.add(checkForDirection(path, i -> ++i, j -> --j));
        probablyAvailable.add(checkForDirection(path, i -> --i, j -> ++j));

        probablyAvailable.add(checkForDirection(path, i -> i + 2, j -> ++j));
        probablyAvailable.add(checkForDirection(path, i -> i + 2, j -> --j));
        probablyAvailable.add(checkForDirection(path, i -> i - 2, j -> ++j));
        probablyAvailable.add(checkForDirection(path, i -> i - 2, j -> --j));
        probablyAvailable.add(checkForDirection(path, i -> ++i, j -> j + 2));
        probablyAvailable.add(checkForDirection(path, i -> --i, j -> j + 2));
        probablyAvailable.add(checkForDirection(path, i -> ++i, j -> j - 2));
        probablyAvailable.add(checkForDirection(path, i -> --i, j -> j - 2));

        for (Optional<Node> node : probablyAvailable)
            node.ifPresent(available::add);
        return available;
    }

    private static Optional<Node> checkForDirection(List<Node> path, UnaryOperator<Integer> iFunction, UnaryOperator<Integer> jFunction) {
        Node last = path.get(path.size() - 1);
        for (int i = last.x, j = last.y;
             i < Node.SIZE && i >= 0 && j < Node.SIZE && j >= 0;
             i = iFunction.apply(i), j = jFunction.apply(j)
        ) {
            Node node = Node.nodeAt(i, j);
            if (!path.contains(node))
                return Optional.of(node);
        }
        return Optional.empty();
    }


    private enum Node {
        A(0, 0),
        B(0, 1),
        C(0, 2),
        D(1, 0),
        E(1, 1),
        F(1, 2),
        G(2, 0),
        H(2, 1),
        I(2, 2);

        public static final int SIZE = 3;

        private final int x;
        private final int y;

        public static Node nodeAt(int x, int y) {
            for (Node node : Node.values())
                if (node.x == x && node.y == y)
                    return node;
            throw new IllegalArgumentException("Either x or y is out of range");
        }

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}