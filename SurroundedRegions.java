/**
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
**/

public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length==0)
            return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && checkArea(i,j,board))
                    captureArea(i,j,board);
                if(board[i][j]=='.')
                    board[i][j]='O';
            }
        }
       
    }
   
    private boolean checkArea(int i,int j, char[][] board){
        if(i<0||i>=board.length||j<0||j>=board[0].length)
            return false;
        if(board[i][j]=='O'){
            board[i][j]='.';
            boolean bot=checkArea(i+1,j,board);
            boolean top=checkArea(i-1,j,board);
            boolean right=checkArea(i,j+1,board);
            boolean left=checkArea(i,j-1,board);
            /**
             * return checkArea(i+1,j,board)&&checkArea(i-1,j,board)&&checkArea(i,j+1,board)&&checkArea(i,j-1,board);
             * is wrong, we need to get all the result and finish all the recursion
             * The returan statement is wrong because if first item is false,
             * the following function call won't be excuted.
             * */
            return bot&&top&&right&&left;
        }else
            return true;
    }
   
    private void captureArea(int i,int j, char[][]board){
        if(board[i][j]!='.')
            return;
        board[i][j]='X';
        captureArea(i+1,j,board);
        captureArea(i-1,j,board);
        captureArea(i,j-1,board);
        captureArea(i,j+1,board);
    }
}
