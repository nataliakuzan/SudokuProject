/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.first.firstjava;

import static pl.first.firstjava.SudokuBoard.SIZE;
import static pl.first.firstjava.SudokuBoard.SQRT;

/**
 * Backtracking algorithm to solve sudoku.
 * @author Natalia
 */
public class BacktrackingSudokuSolver implements SudokuSolver {

    /**
     * This is class for solving sudoku.
     * @param inBoard sudoku board.
     */
    @Override
    public void solve(final SudokuBoard inBoard) {
       fillBoard(inBoard);
    }
    /**
     * Sudoku <b>board</b>.Filling sudoku board with numbers.
     * @param inBoard sudoku board.
     * @return boolean value.
     */
    
    private boolean fillBoard(SudokuBoard inBoard) {
           for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
               if (inBoard.get(row, col) == 0) {
                for (int number = 1; number <= SIZE; number++) {
                    if (canBePlaced(inBoard, row, col, number)) {
                        inBoard.set(row, col, number);
                        if (!fillBoard(inBoard)) {
                            inBoard.set(row, col, 0);
                        } else {
                            return true;
                        }
                    }
                }
                return false;
               }
            }
        }
        return true;
     }
    
     private boolean canBePlaced(final SudokuBoard inBoard, final int row,
                final int col, final int number) {
         for (int i = 0; i < SIZE; i++) {
          if (inBoard.get(row, i) == number) {
             return false;
          }
        }
        for (int j = 0; j < SIZE; j++) {
            if (inBoard.get(j, col) == number) {
               return false;
            }
        }
         int r = (row / SQRT) * SQRT;
         int c = (col / SQRT) * SQRT;
         for (int i = r; i < r + SQRT; i++) {
           for (int j = c; j < c + SQRT; j++) {
             if (inBoard.get(i, j) == number) {
                return false;
             }
           }
        }
        return true;
}  
    
}
