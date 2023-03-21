public class BinaryTree {

    private Node root;

    public void addWord(String other, String spanish) {
        if (root == null) {
            root = new Node(other, spanish);
        } else {
            addWord(root, other, spanish);
        }
    }

    private void addWord(Node node, String other, String spanish) {
        if (other.compareTo(node.other) < 0) {
            if (node.left == null) {
                node.left = new Node(other, spanish);
            } else {
                addWord(node.left, other, spanish);
            }
        } else if (other.compareTo(node.other) > 0) {
            if (node.right == null) {
                node.right = new Node(other, spanish);
            } else {
                addWord(node.right, other, spanish);
            }
        } else {
            node.spanish = spanish;
        }
    }

    public String translate(String other) {
        Node node = find(root, other);
        if (node == null) {
            return null;
        } else {
            return node.spanish;
        }
    }

    private Node find(Node node, String other) {
        if (node == null) {
            return null;
        } else if (other.compareTo(node.other) == 0) {
            return node;
        } else if (other.compareTo(node.other) < 0) {
            return find(node.left, other);
        } else {
            return find(node.right, other);
        }
    }

}