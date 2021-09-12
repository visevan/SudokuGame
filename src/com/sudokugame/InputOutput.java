package com.sudokugame;

import java.util.Scanner;
import java.util.Arrays;

public class InputOutput {
    private Scanner user_input = new Scanner (System.in);
    //input from the user and prints matrix with input
    public int[][] input(int[][] unsolvedGrid){
        int row,column,number;

        System.out.print("Introduce row location: ");
        row = user_input.nextInt();
        System.out.print("Introduce column location: ");
        column = user_input.nextInt();
        System.out.print("Introduce the number: ");
        number = user_input.nextInt();

        unsolvedGrid[row][column] = number;
        Print.printGrid(unsolvedGrid);

        return unsolvedGrid;
    }
    //check if solution is good or not
    public void output(int[][] originalGrid, int[][] solvedGrid){
        if(Arrays.deepEquals(originalGrid,solvedGrid))
            System.out.println("Congratulations");
        else System.out.println("TryAgain");
    }
}