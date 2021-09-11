package com.company;

/*Purpose of this class is to create a random 9x9 Sudoku grid that respects the rules of Sudoku.
Solution:
- create a 9x9 empty grid only with 0s
- complete the main diagonal 3x3 grids with grids generated from the SmallGrid class
(because for these grids we don't have to check for sudoku rules)
- fill the rest 9x9 grid with numbers such that it respect rule of the game
*/

public class BigGrid {
    //Initialize and create the 3 diagonal grids in a Sudoku 9x9 grid
    private SmallGrid smallGrid;
    private int[][] diagonalGrid1;
    private int[][] diagonalGrid2;
    private int[][] diagonalGrid3;
    private int[][] partialGrid;

    public BigGrid() {
        this.smallGrid = new SmallGrid();
        this.diagonalGrid1 = smallGrid.createSmallGrid();
        this.diagonalGrid2 = smallGrid.createSmallGrid();
        this.diagonalGrid3 = smallGrid.createSmallGrid();
        this.partialGrid = addGrid();
    }

    //Add the random 3x3 diagonals to an empty 9x9 grid
    public int[][] addGrid(){
        int[][] partialGrid = new int[9][9];
        for(int i = 0; i <= 2; ++i) {
            for(int j = 0; j <= 2; ++j) {
                partialGrid[i][j] = this.diagonalGrid1[i][j];
                partialGrid[i + 3][j + 3] = this.diagonalGrid2[i][j];
                partialGrid[i + 6][j + 6] = this.diagonalGrid3[i][j];
            }
        }

        return partialGrid;
    }

    //Search and return row and column where a 0 is found in the grid
    public int[] searchEmptyCell(int[][] partialGrid){
        int[] temp = new int[2];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(partialGrid[i][j] == 0){
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }
        return null;
    }

    public boolean solveGrid(){
        int[] temp = searchEmptyCell(partialGrid);
        if(temp != null){
            int row = temp[0];
            int column = temp[1];

            for(int num = 1; num <= 9; num++){
                if(checkConditions(partialGrid, row, column, num)){
                    partialGrid[row][column] = num;
                    if(solveGrid()){
                        return true;
                    }
                    partialGrid[row][column] = 0;
                }
            }
            return false;
        }else return true;
    }

    /*Check if numbers repeats itself on row or column or in 3x3 grid.
            If a condition is TRUE it means the number repeats itself so it's not good
            checkConditions method should return TRUE if the number does not repeat and FALSE if it repeats(already exists)
         */
    public boolean checkConditions(int[][] partialGrid, int row, int column, int num){
        boolean checkRow = false;
        boolean checkColumn = false;
        boolean check3x3Grid = false;
        for(int i = 0; i < 9; i++) {
            if(partialGrid[row][i] == num){
                checkRow = true;
            }
            if(partialGrid[i][column] == num){
                checkColumn = true;
            }
        }

        row -= row % 3;
        column -= column % 3;
        for(int i = 0; i <= 2; ++i) {
            for(int j = 0; j <= 2; ++j) {
                if (partialGrid[i + row][j + column] == num) {
                    check3x3Grid = true;
                    break;
                }
            }
        }

        return !checkRow && !checkColumn && !check3x3Grid;
    }

    public SmallGrid getSmallGrid() {
        return smallGrid;
    }

    public void setSmallGrid(SmallGrid smallGrid) {
        this.smallGrid = smallGrid;
    }

    public int[][] getDiagonalGrid1() {
        return diagonalGrid1;
    }

    public void setDiagonalGrid1(int[][] diagonalGrid1) {
        this.diagonalGrid1 = diagonalGrid1;
    }

    public int[][] getDiagonalGrid2() {
        return diagonalGrid2;
    }

    public void setDiagonalGrid2(int[][] diagonalGrid2) {
        this.diagonalGrid2 = diagonalGrid2;
    }

    public int[][] getDiagonalGrid3() {
        return diagonalGrid3;
    }

    public void setDiagonalGrid3(int[][] diagonalGrid3) {
        this.diagonalGrid3 = diagonalGrid3;
    }

    public int[][] getPartialGrid() {
        return partialGrid;
    }

    public void setPartialGrid(int[][] partialGrid) {
        this.partialGrid = partialGrid;
    }
}
