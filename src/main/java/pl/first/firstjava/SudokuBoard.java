/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.first.firstjava;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class for sudoku board.
 * @author Natalia
 */
public class SudokuBoard {
    /**
    * Sudoku <b>board</b>.
    * @see Class
    */
    private final int[][] board;
    /**
    * Sudoku <b>board</b> size.
    * @see Size
    */
    public static final int SIZE = 9;
    /**
    * Sudoku <b>board</b> sqrt(SIZE).
    * @see Sqrt
    */
    public static final int SQRT = 3;

    /**
     * Constructor of sudoku board.
     */
    public SudokuBoard() {
        board = new int[SIZE][SIZE];
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rnd = ThreadLocalRandom.current();
    for (int i = array.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
        System.arraycopy(array, 0, board[0], 0, SIZE);
    }

    /**
     * Sudoku <b>board</b>.Return board array.
     * @param x row.
     * @param y column.
     * @return number from board at given place.
     */
    public final int get(int x, int y) {
        return board[x][y];
    }
    /**
     * Sudoku <b>board</b>.Return board array.
     * @param x row.
     * @param y column.
     * @param value given number.
     */
    
    public final void set(int x, int y, int value) {
        board[x][y] = value;
    }
/**
    * Sudoku <b>board</b> method.
    * @see IfNumberCanBePlaced
    * @param row - board row
    * @param col - board column
    * @param number - given number
    * @return bool if number can be placed.
    */
    
private boolean checkBoard(int x, int y, int[][] currentBoard) {
        int currentElement = currentBoard[x][y];
        if (currentElement == 0) {
            return true;
        }
        //in row
        for (int i = 0; i < 9; i++) {
            if (i != x && currentBoard[i][y] == currentElement) {
                 return false;
            }
        }
        //in column
        for (int i = 0; i < 9; i++) {
            if (i != y && currentBoard[x][i] == currentElement) {
                 return false;
            }
        }
        //in 3×3 box
        int currentSqareX = (x / 3) * 3;
        int currentSqareY = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((currentSqareX + i != x) && (currentSqareY + j != y) 
&& (currentBoard[currentSqareX + i][currentSqareY + j]) == currentElement) {
                     return false;
                }
            }
        }

        return true;
}

}
