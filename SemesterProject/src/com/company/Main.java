package com.company;

    public class Main {

        public static void main(String[] args) {

            DumbBST exampleTree = new DumbBST();

            exampleTree.runInsert(20);
            exampleTree.runInsert(5);
            exampleTree.runInsert(17);
            exampleTree.runInsert(12);
            exampleTree.runInsert(33);
            exampleTree.runInsert(39);
            exampleTree.runInsert(2);
            exampleTree.runInsert(24);
            exampleTree.runInsert(26);

            exampleTree.runInOrder();
            exampleTree.runPreOrder();
            exampleTree.runPostOrder();

            exampleTree.breadthSearch(exampleTree.root);

            exampleTree.Delete(12);
            exampleTree.Delete(24);
            exampleTree.Delete(5);
        }
    }