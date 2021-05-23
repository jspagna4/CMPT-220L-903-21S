public class DumbBST {

    Node root;
    public DumbBST() {
        this.root = null;
    }

    // Recursive method for inserting elements into the BST.
    // If the inserted value is less than the current node, insert in left child.
    // If the inserted value is greater than the current node, insert in right child.
    // If the inserted value already exists, do not add it to the tree.

    private Node Insert(Node current, int value) {
        if (value < current.value) {
            current.leftChild = Insert(current.leftChild, value);
        } else if (value > current.value) {
            current.rightChild = Insert(current.rightChild, value);
        } else {
            return current;
        }

        if (current == null) {
            return new Node(value);
        }

        return current;
    }

    // Run recursive method beginning with root node.
    public void runInsert(int value) {
        root = Insert(root, value);
    }

}
