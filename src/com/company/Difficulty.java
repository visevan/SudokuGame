package com.company;



/*
 In order to create different levels of difficulty for a Sudoku puzzle we do this:
 - take a solved grid
 - remove a number of tiles (in our case we will overwrite random tiles with 0)
 The difficulty is given by the amount of empty tiles. The more empty tiles there are the harder the Sudoku puzzle.
 */
public class Difficulty {

    public Difficulty() {
    }

    public int[][] easy(int[][] solvedGrid){
        for(int i = 0; i <= 15; i++){

            int row = (int) Math.floor(Math.random() * 9);
            int column = (int) Math.floor(Math.random() * 9);

            if(solvedGrid[row][column] == 0){
                i--;
            }

            solvedGrid[row][column] = 0;
        }

        return solvedGrid;
    }

    public int[][] medium(int[][] solvedGrid){
        for(int i = 0; i <= 30; i++){

            int row = (int) Math.floor(Math.random() * 9);
            int column = (int) Math.floor(Math.random() * 9);

            if(solvedGrid[row][column] == 0){
                i--;
            }

            solvedGrid[row][column] = 0;
        }

        return solvedGrid;
    }

    public int[][] hard(int[][] solvedGrid){
        for(int i = 0; i <= 45; i++){

            int row = (int) Math.floor(Math.random() * 9);
            int column = (int) Math.floor(Math.random() * 9);

            if(solvedGrid[row][column] == 0){
                i--;
            }

            solvedGrid[row][column] = 0;
        }

        return solvedGrid;
    }

}
