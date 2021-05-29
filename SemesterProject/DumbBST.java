package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class DumbBST {

    Node root;

    // Function for inserting values into the tree
    // We traverse through the tree, checking where there are nulls, starting with the root.
    public void runInsert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        }
        Insert(root, newNode);
    }
    // The inputted value will be inserted as either the left child or right child of a given node.
    private void Insert(Node exampleNode, Node newNode) {
        if (newNode.value < exampleNode.value) {
            if (exampleNode.leftChild == null) {
                newNode.parent = exampleNode;
                exampleNode.leftChild = newNode;
            } else {
                Insert(exampleNode.leftChild, newNode);
            }
        } else if (newNode.value > exampleNode.value) {
            if (exampleNode.rightChild == null) {
                newNode.parent = exampleNode;
                exampleNode.rightChild = newNode;
            } else {
                Insert(exampleNode.rightChild, newNode);
            }
        }
    }

    // Each of the following tree traversals (in order, pre order, post order) constitute a depth first search.

    // Recursive, in order traversal function
    // We check to see if the current node has children.
    // If not, we can simply print the element.
    // If so, we must traverse the tree, doing the left and right sides seperately.
    public void runInOrder() {
        System.out.println("In Order Traversal:");
        if (root != null) {
            Node InOrderNode = root;
            if (InOrderNode.leftChild == null && InOrderNode.rightChild == null) {
                System.out.println(InOrderNode.value);
            } else {
                if (InOrderNode.leftChild != null) {
                    InOrder(InOrderNode.leftChild);
                }
                System.out.println(InOrderNode.value);
                if (InOrderNode.rightChild != null) {
                    InOrder(InOrderNode.rightChild);
                }
            }
        }
    }
    // Traverse left side, print root, then traverse left side.
    private void InOrder(Node traverseNode) {
        if (traverseNode.leftChild != null) {
            InOrder(traverseNode.leftChild);
        }
        System.out.println(traverseNode.value);
        if (traverseNode.rightChild != null) {
            InOrder(traverseNode.rightChild);
        }
    }

    // Recursive, post order traversal function
    // Here, we do not have to differentiate between whether the child of the current node is left or right
    // based on the nature of a pre order traversal.
    public void runPreOrder() {
        System.out.println("Pre Order Traversal:");
        if (root != null) {
            Node PreOrderNode = root;
            if (PreOrderNode.leftChild == null && PreOrderNode.rightChild == null) {
                System.out.println(PreOrderNode.value);
            } else {
                PreOrder(PreOrderNode);
            }
        }
    }
    // Print root, traverse left side, then traverse right side
    private void PreOrder(Node traverseNode) {
        System.out.println(traverseNode.value);
        if (traverseNode.leftChild != null) {
            PreOrder(traverseNode.leftChild);
        }
        if (traverseNode.rightChild != null) {
            PreOrder(traverseNode.rightChild);
        }
    }

    // Recursive, post order traversal function
    // Our post order function is fundamentally the same as pre order.
    public void runPostOrder() {
        System.out.println("Post Order Traversal:");
        if (root != null) {
            Node PostOrderNode = root;
            if (PostOrderNode.leftChild == null && PostOrderNode.rightChild == null) {
                System.out.println(PostOrderNode.value);
            } else {
                PostOrder(PostOrderNode);
            }
        }
    }
    // Traverse left side, traverse right side, then print root
    private void PostOrder(Node traverseNode) {
        if (traverseNode.leftChild != null) {
            PostOrder(traverseNode.leftChild);
        }
        if (traverseNode.rightChild != null) {
            PostOrder(traverseNode.rightChild);
        }
        System.out.println(traverseNode.value);
    }

    // Our function for deleting elements from the tree consists of calling three functions
    // Each function corresponds with the number of children the desired node to be deleted has.
    public boolean Delete(int value) {
        Node deleteNode = runFindNode(value);
        if (deleteNode != null) {
            if (deleteNode.leftChild == null && deleteNode.rightChild == null) {
                noChildrenDelete(deleteNode);
            } else if (deleteNode.leftChild != null && deleteNode.rightChild == null) {
                oneChildDelete(deleteNode);
            } else if (deleteNode.rightChild != null && deleteNode.leftChild == null) {
                oneChildDelete(deleteNode);
            } else {
                twoChildrenDelete(deleteNode);
            }
        System.out.println("The value " + value + " has been successfully deleted.");
        }
        return false;
    }
    // Our first case is when the selected node has no children.
    // We reference the node as its parent's child and set it to null.
    private void noChildrenDelete(Node deleteNode) {
        if (deleteNode.parent.leftChild == deleteNode) {
            deleteNode.parent.leftChild = null;
        } else if (deleteNode.parent.leftChild == deleteNode) {
            deleteNode.parent.rightChild = null;
        }
    }

    // Our second case is when the selected node has one child.
    // We must check whether the child is left or right and then replace the deleted node with the child.
    private void oneChildDelete(Node deleteNode) {
        if (deleteNode.parent.leftChild == deleteNode) {
            if (deleteNode.leftChild != null) {
                deleteNode.parent.leftChild = deleteNode.leftChild;
            } else if (deleteNode.rightChild != null) {
                deleteNode.parent.leftChild = deleteNode.rightChild;
            }
        } else if (deleteNode.parent.rightChild == deleteNode) {
            if (deleteNode.leftChild != null) {
                deleteNode.parent.rightChild = deleteNode.leftChild;
            } else if (deleteNode.rightChild != null) {
                deleteNode.parent.rightChild = deleteNode.rightChild;
            }
        }
    }

    // Our third case is when the selected node has two children.
    // To delete a node with two children, we call upon a "getlowestLeft" function defined below.
    // We can use the left most grandchild of the deleted node in order to determine how to re-structure
    // the left and right children of the deleted node.
    private void twoChildrenDelete(Node deleteNode) {
        Node lowestLeft = getLowestLeft(deleteNode.rightChild);
        oneChildDelete(lowestLeft);
        lowestLeft.leftChild = deleteNode.leftChild;
        lowestLeft.rightChild = deleteNode.rightChild;
        lowestLeft.parent = deleteNode.parent;
        if (deleteNode.parent.leftChild == deleteNode) {
            deleteNode.parent.rightChild = lowestLeft;
        } else if (deleteNode.parent.rightChild == deleteNode) {
            deleteNode.parent.rightChild = lowestLeft;
        }
    }

    // Simple function for finding the left grandchild of the deleted node.
    private Node getLowestLeft(Node llNode) {
        if (llNode.leftChild == null) {
            return llNode;
        }
        return getLowestLeft(llNode.leftChild);
    }

    // Our finding elements function involves checking whether or not the inputted value is equal to
    // the value of the current node. We start traversing the tree with the root, checking each node as we go.
    public Node runFindNode(int value) {
        if (root != null) {
            return FindNode(root, new Node(value));
        }
        return null;
    }
    // We continue to traverse the tree until the inputted value matches the value of a node in the tree
    // or until the entire tree has been traversed.
    private Node FindNode(Node searchNode, Node desiredNode) {
        if (searchNode == null) {
            return null;
        }
        if (searchNode.value == desiredNode.value) {
            return searchNode;
        } else {
            Node returnNode = FindNode(searchNode.leftChild, desiredNode);
            if (returnNode == null) {
                returnNode = FindNode(searchNode.rightChild, desiredNode);
            }
            return returnNode;
        }
    }

    // Our breadth based search involves using a queue.
    // We must keep all elements in memory because we have to loop around every element of each level,
    // meaning that we can't drop a given node until we've looked at all of its children, unlike
    // a depth first search.
    public Node breadthSearch(Node root) {
        System.out.println("Breadth First Search:");
        if (root == null) {
            return root;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(node.value);
            if (node.leftChild != null) {
                nodes.add(node.leftChild);
            }
            if (node.rightChild != null) {
                nodes.add(node.rightChild);
            }
        }
    return root;
    }

}