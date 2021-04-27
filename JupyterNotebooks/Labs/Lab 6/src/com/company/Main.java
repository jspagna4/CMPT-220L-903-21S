package com.company;

public class Main {

    public static void main(String[] args) {
        listItem one = new listItem(1);
        listItem two = new listItem(2);
        listItem three = new listItem(3);
        listItem four = new listItem(4);

        one.nextItem = two;
        two.nextItem = three;
        three.nextItem = four;
    }
}
