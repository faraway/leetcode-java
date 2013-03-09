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

/**
 * BFS solution
 * But it is slow than DFS one, more improvements can be made
 * */
 class SurroundedRegionsBFS {
    
    Queue<Point> q;
    
    public void solve(char[][] board) {
        int m=board.length;
        if(m==0)
            return;
        int n=board[0].length;
        
        q = new LinkedList<Point>();
        //top
        for(int i=0;i<n;i++){
            if(board[0][i]=='O')
                bfs(0,i,board);
        }
        //right
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O')
                bfs(i,n-1,board);
        }
        //bot
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O')
                bfs(m-1,i,board);
        }
        //left
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                bfs(i,0,board);
        }
        //final traveral of the board
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //unsurrounded Os
                if(board[i][j]=='.')
                    board[i][j]='O';
                //surrounded Os
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
        
    }
    
    private void bfs(int i,int j, char[][] board){
        q.offer(new Point(i,j));
        while(!q.isEmpty()){
            Point p = q.poll();
            board[p.i][p.j]='.';
            if(valid(p.i+1,p.j,board))
                q.offer(new Point(p.i+1,p.j));
            if(valid(p.i-1,p.j,board))
                q.offer(new Point(p.i-1,p.j));
            if(valid(p.i,p.j+1,board))
                q.offer(new Point(p.i,p.j+1));
            if(valid(p.i,p.j-1,board))
                q.offer(new Point(p.i,p.j-1));
        }
    }
    
    private boolean valid(int i, int j, char[][] board){
        if(i<0||i>=board.length||j<0||j>=board[0].length)
            return false;
        if(board[i][j]=='O')
            return true;
        return false;
    }
}

class Point{
    int i,j;
    Point(int i,int j){
        this.i=i;
        this.j=j;
    }
}
