public class knighttour {
    
    static boolean constraincheck(int board[][],int x, int y){
        if(x>=0&&x<=7 && y>=0 && y<=7 && board[x][y]==0){
            return true;
        }
        return false;
    }
    
    public static boolean knighttourfunc(int board[][],int movement , int row,int col){
      if(movement==63)
      return true;
    
        int xoptions[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yoptions[] = { 1, 2, 2,   1, -1, -2, -2, -1 };
        
    for(int i=0;i<8;i++){
        int nx=row+xoptions[i];
        int ny=col+yoptions[i];
    
        if(constraincheck(board,nx,ny)==true){
    board[row][col]=movement;
    
    knighttourfunc(board, movement+1, row, col);
    board[row][col]=0;
        }
    }
    return false;
    }
    
    
        public static void main(String[] args) {
            int board[][]={{0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0}};
                             
            board[0][0]=1;
            if(knighttourfunc(board,2,0,0)==true){
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        System.out.print(board[i][j]+" ");
                    }
                System.out.println();
                }
                System.out.println();
            }
        else
        System.out.println("no valid configration");
        }
    }
    