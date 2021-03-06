

public class sudoku {
 
    public static boolean constraintChecker(int board[][],int row,int col,int num){

        for(int i=0;i<9;i++){
            if(board[row][i]==num){
                return false;
            }
            
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }

        int x=row-row%3;
        int y=col-col%3;

        for(int i=x;i<=x+2;i++){
            for(int j=y;j<=y+2;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokusolver(int board[][],int row,int col){

        if(row==8 && col==9){
            
            return true;
        }

        if(col==9){
            row=row+1;
            col=0;
        }

        if(board[row][col]!=0){
            return sudokusolver(board,row,col+1);
        }

        for(int i=1;i<=9;i++){

            if( constraintChecker(board,row,col,i)==true){
                board[row][col]=i;

                if(sudokusolver(board, row, col+1)==false){
                    board[row][col]=0;
                }
                else{
                    return true;
                }
            }
        }

        return false;

    }
    public static void main(String []args){
        int board[][]={
                    {5,3,0,0,7,0,0,0,0},
                    {6,0,0,1,9,5,0,0,0},
                    {0,9,8,0,0,0,0,6,0},
                    {8,0,0,0,6,0,0,0,3},
                    {4,0,0,8,0,3,0,0,1},
                    {7,0,0,0,2,0,0,0,6},
                    {0,6,0,0,0,0,2,8,0},
                    {0,0,0,4,1,9,0,0,5},
                    {0,0,0,0,8,0,0,7,9}
        };


        if(sudokusolver(board,0,0)==true){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }

        }
        else{
            System.out.println("no valid solution");
        }
    }
}