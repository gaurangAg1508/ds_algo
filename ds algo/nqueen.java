public class nqueen{
    
    public static boolean constraincheck(int board[][],int row, int col){
        for(int i=0;i<=row;i++){
            if(board[i][col]==1)
            return false;
        }
       for(int i=row,j=col;i>=0 && j>=0;--i,j--){
           if(board[i][j]==1)
           return false;
        }
       for(int i=row,j=col;i>=0 && j<4;i--,j++){
        if(board[i][j]==1)
        return false;
       }
    return true;
    }
    
    
    
   public static  void placequeen(int board[][], int row){
    
    if(row==4){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(board[i][j]);
            }
        System.out.println();
        }
        System.out.println();
        return;  
    }
    
    
    for(int i=0;i<4;i++){
         if(constraincheck(board,row,i)==true){
         board[row][i]=1;
          
         placequeen(board, row+1);
          board[row][i]=0;
     }
   } 
} 
    public static void main(String[] args) {
    int board[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}  ;
    placequeen(board,0); 
    }
}