package com.company;

public class Main {

    public static void main(String[] args) {
        Plant p1 = new Plant(false, "Rhamnaceae", "California lilac");
        p1.wateringInstructions();
        p1.sunlightRequirements();

        Plant p2 = new Plant(true, "Rosaceae", "Rose");
        p2.wateringInstructions();
        p2.sunlightRequirements();
    }
}
