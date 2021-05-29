package com.company;

class Node {
    int value;
    Node leftChild;
    Node rightChild;
    Node parent;

    public Node(int value) {
        this.value = value;
        rightChild = null;
        leftChild = null;
        parent = null;
    }

    @Override
    public String toString() {
        return " " + value;
    }
}
