package com.company;

public class Main {

    public static int summation(int[] numList) {
        int sum = 0;
        for(int i = 0; i < numList.length; i++)
            sum += numList[i];
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(summation(nums));
    }
}
