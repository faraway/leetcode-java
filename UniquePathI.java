package leetcode;
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


 * @author patrick
 *
 */
public class UniquePathI {
    public int uniquePaths(int m, int n) {
    	//initialization
        int[][] array = new int[m][n];
        for(int i=0;i<n;i++){
            array[0][i]=1;
        }
        for(int i=0;i<m;i++){
            array[i][0]=1;
        }
        //iteratively computing
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                array[i][j]+=array[i-1][j]+array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }
}