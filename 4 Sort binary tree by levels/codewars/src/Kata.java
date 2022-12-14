import java.util.*;

class Kata {
    public static List<Integer> treeByLevels(Node root) {
        if (root == null)
            return List.of();
        List<Integer> widthNodes = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            widthNodes.add(node.value);
            if (node.left != null)
                queue.offerLast(node.left);
            if (node.right != null)
                queue.offerLast(node.right);
        }
        return List.copyOf(widthNodes);
    }
}