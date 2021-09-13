package com.sudokugame;

public class Print {

    public Print() {
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
        char[] topBottomLocator = {'A','B','C','D','E','F','G','H','I'};

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
