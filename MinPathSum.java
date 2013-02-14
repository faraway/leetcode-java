package leetcode;
/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.
 * @author patrick
 *
 */
public class MinPathSum {
	public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] result = new int[m][n];
        
        
        //init
        result[0][0]=grid[0][0];
        for(int i = 1;i< m; i++){
            result[i][0] = result[i-1][0]+grid[i][0];
        }
        for(int i = 1;i< n; i++){
        	result[0][i] = result[0][i-1]+grid[0][i];
        }
        /**key point, the current route can from top or left, chose the smaller one.**/
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int choice = result[i-1][j]<result[i][j-1]?result[i-1][j]:result[i][j-1];
                result[i][j] = choice + grid[i][j];
            }
        }
        
        return result[m-1][n-1];
    }
	
	public static void main(String[] args){
		int[][] test = {{1,2},{5,6},{1,1}};
		minPathSum(test);
	}

}
