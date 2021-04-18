package com.company;

public class Plant {
    boolean needsWatering;
    String plantFamily;
    String Name;

    public Plant(boolean needsWatering, String plantFamily, String Name){
        this.plantFamily = plantFamily;
        this.needsWatering = needsWatering;
        this.Name = Name;
    }

    public void wateringInstructions() {
        if (needsWatering == true) {
            System.out.println("Apply 1 inch of water per week or as needed.");
        }
        else {
            System.out.println("No watering required.");
        }
    }

    public void sunlightRequirements() {
        if (Name == "California lilac") {
            System.out.println("6-8 hours of sunlight per day.");
        }
        else if (Name == "Rose") {
            System.out.println("6 hours of sunlight per day. Morning sun preferred over afternoon sun.");
        }
        else {
            System.out.println("All pants need sunlight in order to perform photosynthesis. All plants should get a bare minimum of 4 hours of sunlight per day, though many plants need more. ");
        }
    }
}