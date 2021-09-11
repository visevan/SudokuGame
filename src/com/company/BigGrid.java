package com.company;

/*Purpose of this class is to create a random 9x9 Sudoku grid
that respects the rules of Sudoku.
Solution:
- create a 9x9 empty grid only with 0s
- complete the main diagonal 3x3 grids with  grids generated from the SmallGrid class
(because for these grids we don't have to check for sudoku rules)
- fill the rest of the 9x9 with numbers such that it respect rule of the game
*/

public class BigGrid {
    //Initialize and create the 3 diagonal grids in a Sudoku 9x9 grid
    private SmallGrid smallGrid;
    private int[][] diagonalGrid1;
    private int[][] diagonalGrid2;
    private int[][] diagonalGrid3;

    //initialize the 9x9 empty grid
    private int[][] bigGrid;

    public BigGrid() {
        this.smallGrid = new SmallGrid();
        this.diagonalGrid1 = smallGrid.createSmallGrid();
        this.diagonalGrid2 = smallGrid.createSmallGrid();
        this.diagonalGrid3 = smallGrid.createSmallGrid();
        this.bigGrid = new int[9][9];
    }

    //Add the random 3x3 diagonals to the 9x9 grid
    public int[][] addGrid(){

        for(int i = 0; i <= 2; ++i) {
            for(int j = 0; j <= 2; ++j) {
                this.bigGrid[i][j] = this.diagonalGrid1[i][j];
                this.bigGrid[i + 3][j + 3] = this.diagonalGrid2[i][j];
                this.bigGrid[i + 6][j + 6] = this.diagonalGrid3[i][j];
            }
        }

        return bigGrid;
    }






    public int[][] getBigGrid() {
        return bigGrid;
    }

    public void setBigGrid(int[][] bigGrid) {
        this.bigGrid = bigGrid;
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
}
