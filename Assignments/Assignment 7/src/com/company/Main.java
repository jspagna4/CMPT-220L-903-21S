package com.company;

public class Main {

    public static void main(String[] args) {
	int[] unsorted = {12, 9, 7, 2, 0, 4, 6};
	bubbleSort(unsorted);
    }

    static void bubbleSort(int[] numList) {
        int n = numList.length;
        int i;
        int j;
        boolean swap;

        for (i = 0; i < n-1; i++) {
            swap = false;
            for (j = 0; j < n-i-1; j++) {
                if (numList[j] > numList[j+1]) {
                    int original1 = numList[j];
                    int original2 = numList[j+1];
                    numList[j] = original2;
                    numList[j+1] = original1;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        for(int k = 0; k < numList.length; k++)
        System.out.println(numList[k]);
    }
}
