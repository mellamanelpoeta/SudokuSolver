
package sudokusolver;

/**
 *
 * @author Gerardo Guerrero <gguerr21@itam.mx>
 */
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] sudoku = {
            {0,0,1,0,0,5,0,9,0},
            {0,8,5,7,0,0,0,0,0},
            {0,0,0,0,0,8,0,0,0},
            {0,7,0,0,0,0,0,6,0},
            {3,0,0,6,4,0,0,0,0},
            {9,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,8,1,5},
            {0,0,0,0,7,3,0,0,9},
            {0,0,0,0,2,0,0,0,7}
        };
        
        Solver miSolver;
        
        miSolver=new Solver(sudoku);
        
        
        if(miSolver.solve())
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(sudoku[i][j]);
                }
                System.out.println("");
            }
    }
    
}
