package com.sudokugame;

public class Main {

    public static void main(String[] args) {
        //initialize grid with solution and print it
        BigGrid bigGrid = new BigGrid();
        int[][] solvedGrid = bigGrid.solvedGrid();
        System.out.println("Solution of the grid : ");
        Print.printGrid(solvedGrid);

        //copy of base grid in another 2D Array in order to remove numbers from the grid
        int[][] copyMatrix = new int[9][9];
        for(int i = 0; i <= 8; i++ ){
            for(int j = 0; j <= 8; j++){
                copyMatrix[i][j] = solvedGrid[i][j];
            }
        }

        //we define a new array to hold the matrix solution
        //int[][] tempMatrix = Arrays.copyOf(baseMatrix, 9);

        //create unsolved grid with easy/normal/hard/demo difficulty
        Difficulty difficulty = new Difficulty();
        int[][] unsolvedMatrix = difficulty.demo(copyMatrix);
        System.out.println("Matrix to be completed");
        Print.printGrid(unsolvedMatrix);

        //solve grid with input from user
        InputOutput inputOutput = new InputOutput();
        int[][] alias = inputOutput.input(unsolvedMatrix);
        inputOutput.output(solvedGrid,alias);

    }
}
