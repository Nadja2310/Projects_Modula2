package telran;

public class Node {
    Node left;
    Node right;
    String name;

    public Node(String name,Node left, Node right) {
        this.left = left;
        this.right = right;
        this.name = name;
    }
}
