package leetcode;
/**
 *  Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

	For example,
	Given board =

	[
  		["ABCE"],
  		["SFCS"],
  		["ADEE"]
	]

	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
 * @author patrick
 * TODO DP method?
 */
public class WordSearch {
    private int[][] boardCheck;
    
    private char[][] board;
    
    private String word;
    
    /**
     * @Recursive method.
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board == null){
            return false;
        }
        this.board=board;
        this.word=word;
        boardCheck = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(searchWord(i,j,0)){
                    return true;
                }
            }
        }
        return false;
         
    }
    /**
     * Try to match the word from beginning, chosen board[x][y] as the start point.
     * @param x
     * @param y
     * @param index
     * @return
     */
    private boolean searchWord(int x, int y, int index){
        if(x<0||x>=board.length||y<0||y>=board[0].length||boardCheck[x][y]==1){
            return false;
        }
        if(board[x][y]!=word.charAt(index)){//current char doesn't match
            return false;
        }
        if(index==word.length()-1){//current char match && it's the last char of the word
            return true;
        }
        boardCheck[x][y]=1;
        index++;
        boolean result = false;
        result = searchWord(x+1,y,index)||searchWord(x-1,y,index)||searchWord(x,y+1,index)||searchWord(x,y-1,index);
        if(result){
            return true;
        }else{
        	//reset the flag to 0, since this is not the path, this cell won't be occupied by this call.
            boardCheck[x][y]=0;
            return false;
        }
        
    }
    
    
    public static void main(String[] args){
    	WordSearch w = new WordSearch();
    	char[][] board = {{'a','a'}};
    	w.exist(board, "a");
    }
}