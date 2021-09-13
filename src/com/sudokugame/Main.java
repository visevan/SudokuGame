package com.sudokugame;

import java.awt.*;
import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        gameApp();

        /*
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
        */
    }

    public static void gameApp(){
        boolean chk = false;
        //if user doesn't select an input from the screen the input will reaper
        while(!chk){
            int menuSelect = menu();
            if(menuSelect == 1){
                chk = true;
            }else if(menuSelect == 2){
                chk = true;
            }
        }
        //if user doesn't select an input from the difficulty screen the input will reaper
        boolean chk2 = false;
        int difficultySelect = 0;
        while(!chk2) {
            difficultySelect = difficultyScreen();
            if(difficultySelect >= 1 && difficultySelect <= 5){
                chk2 = true;
            }
        }

        //create object with solved grid
        BigGrid bigGrid = new BigGrid();
        int[][] solvedGrid = bigGrid.solvedGrid();

        //copy of base grid in another 2D Array in order to remove numbers from the grid
        int[][] copyMatrix = new int[9][9];
        for(int i = 0; i <= 8; i++ ){
            for(int j = 0; j <= 8; j++){
                copyMatrix[i][j] = solvedGrid[i][j];
            }
        }

        //create unsolved grid with easy/normal/hard/demo difficulty
        Difficulty difficulty = new Difficulty();
        int[][] unsolvedMatrix = new int[9][9];
        switch (difficultySelect){
            case 1: unsolvedMatrix = difficulty.demo(copyMatrix);
                break;
            case 2: unsolvedMatrix = difficulty.easy(copyMatrix);
                break;
            case 3: unsolvedMatrix = difficulty.medium(copyMatrix);
                break;
            case 4: unsolvedMatrix = difficulty.hard(copyMatrix);
                break;
            case 5: System.exit(0);
                break;
        }

        //print the grid to be solved
        Print.printGrid(unsolvedMatrix);

        InputOutput inputOutput = new InputOutput();
        int[][] alias = inputOutput.input(unsolvedMatrix);
        inputOutput.output(solvedGrid,alias);

    }

    //Game menu and user selection
    public static int menu(){
        int selection = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Unlimited Sudoku");
        System.out.println("-------------------------");
        System.out.println("1 - New Game");
        System.out.println("2 - Quit");

        try {
            selection = input.nextInt();
        } catch (Exception ignored){}

        return selection;
    }
    //run all the other methods here


    public static int difficultyScreen(){
        int selection = 0;
        Scanner input = new Scanner(System.in);

        //supposed to clean console ??
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Welcome to Unlimited Sudoku");
        System.out.println("-------------------------\n");
        System.out.println("Difficulty");
        System.out.println("1 - Demo");
        System.out.println("2 - Easy");
        System.out.println("3 - Normal");
        System.out.println("4 - Hard");
        System.out.println("5 - Exit");

        try {
            selection = input.nextInt();
        } catch (Exception ignored){}

        return selection;
    }

}
