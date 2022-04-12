
package sudokusolver;

/**
 * @author Gerardo Guerrero <gguerr21@itam.mx>
 * 203214
 * Apr 12, 2022
 */
public class Solver {
    private int[][] board;
    private final int SIZE=9;

    public Solver(int[][] board){
        this.board=board;
    }
    
    private boolean checkRow(int i, int num){
       return checkRow(0,i,num);
    }
    
    private boolean checkRow(int index, int i, int num) {
        if(board[i][index] == num)
            return true;
        else
            if(index<SIZE-1)
                return checkRow(index+1,i,num);
            else
                return false;
    }  
    
    private boolean checkColumn(int j, int num){
        return checkColumn(0,j,num);
    }
    
    private boolean checkColumn(int index, int j, int num) {
        if(board[index][j] == num)
            return true;
        else
            if(index<SIZE-1)
                return checkColumn(index+1,j,num);
            else
                return false;
    } 
    
    private boolean checkInnerBox(int i, int j, int num){
        int row= i - i % 3, column = j - j % 3;
        
        for(int k = row; k < row + 3; k++){
            for(int l = column; l < column + 3; l++)
                if(board[k][l] == num)
                    return true;
        }
        return false;     
    }
    
    private boolean checkNum(int i,int j,int num){
        return (!checkRow(i,num) && !checkColumn(j,num) && !checkInnerBox(i,j,num));
    } 
    
    public boolean solve(){
      int i,j,num;
      
      for(i=0;i<SIZE;i++){
          for(j=0;j<SIZE;j++){ //ciclamos en toda la matriz
             if(board[i][j] == 0){ //nos interesa modificar aquellas entradas que están en blanco
                 for(num=1;num<=SIZE;num++){ //los numeros a intentar están entre 1 y 9
                     if(checkNum(i,j,num)){ //en caso de que nuestro verificador de numeros garantice que dicho numero puede ir
                         board[i][j] = num; //colocamos dicho numero en la casilla
                         if(solve()){ //hacemos el llamado recursivo donde en caso de que todo funcione bien, siemplemente regresa un true
                             return true;
                         }
                         else //si se alcanza un false es porque la decision de num estaba mal
                            board[i][j] = 0;
                     }           
                 }
                 return false; //si nunca entro a nuestro if, regresamos false lo que implica que habia algo mal con el num escogido
             } 
          }
      }
      return true;
    }
}
