package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        SmallGrid a = new SmallGrid();
        BigGrid b = new BigGrid();
        b.solveGrid();
        printSmallGrid(b.getPartialGrid());
        printGrid(b.getPartialGrid());
    }

    public static void printSmallGrid(int[][] smallGrid) {
        System.out.println("3x3 matrix: ");

        for(int i = 0; i <= 2; ++i) {
            System.out.println();

            for(int j = 0; j <= 2; ++j) {
                System.out.print(smallGrid[i][j]);
            }
        }

    }

    public static void printGrid(int[][] grid) {
        for(int i = 0; i <= 8; ++i) {

            System.out.println();

            if (i % 3 == 0) {
                System.out.println();
            }
            for(int j = 0; j <= 8; ++j) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(grid[i][j]);
            }
        }
        System.out.println();
    }
}
