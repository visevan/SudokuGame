package com.sudokugame;

public class Main {

    public static void main(String[] args) {
        SmallGrid a = new SmallGrid();
        BigGrid b = new BigGrid();
        b.solveGrid();
        Print.printGrid(b.getPartialGrid());
    }
}
