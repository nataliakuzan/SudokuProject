/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.first.firstjava;

/**
 * Interface of sudoku solver.
 * @author Natalia
 */
public interface SudokuSolver {
   
    /**
     * This is function for solving sudoku.
     * @param inBoard sudoku board.
     */
    void solve(SudokuBoard inBoard);   
}
