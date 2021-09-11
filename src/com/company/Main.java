package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        SmallGrid a = new SmallGrid();
        BigGrid b = new BigGrid();
        printMini(b.addGrid());

    }

    public static void printMini(int[][] miniMatrix) {
        for (int i = 0; i <= 8; ++i) {
            System.out.println();
            if (i % 3 == 0) {
                System.out.println();
            }

            for (int j = 0; j <= 8; ++j) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }

                System.out.print(miniMatrix[i][j]);
            }
        }
    }
}
