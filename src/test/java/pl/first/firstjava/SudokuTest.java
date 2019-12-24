/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.first.firstjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Natalia
 */
public class SudokuTest {
    
    public SudokuTest() {
    }
    
   @Test
     public void SudokuBoardTest() {
     
     SudokuBoard sudoku = new SudokuBoard();
     SudokuSolver solver = new BacktrackingSudokuSolver();
     solver.solve(sudoku);

//sudoku was solved
	 
     }
}
