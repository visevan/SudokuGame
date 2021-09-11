package com.company;

import java.util.LinkedList;

public class SmallGrid {

    public SmallGrid() {
    }

    /*  Create a 3x3 grid with random numbers.
    This is done like so: we have a bag with numbers from 1 to 9, and we randomly pull
    a number from the bag. Then the number that we pulled from the bag we put
    it in a 3x3 grid that is actually a 2D Array. */
    public int[][] createSmallGrid(){

        //Create a LinkedList with numbers from 1 to 9
        LinkedList<Integer> bagOfNumbers = new LinkedList<Integer>();
        for(int i = 1; i <= 9; i++){
            bagOfNumbers.add(i);
        }

        //Randomly select numbers from LinkedList and put them in a 2D Array
        int[][] smallGrid = new int[3][3];
        int k = 9;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int randomInt = (int) Math.floor(Math.random() * k);
                smallGrid[i][j] = bagOfNumbers.get(randomInt);
                bagOfNumbers.remove(randomInt);
                k--;
            }
        }
        return smallGrid;
    }
}
