package leetcode;

/**
 * Follow up for "Unique Paths":

	Now consider if some obstacles are added to the grids. How many unique paths would there be?

	An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	For example,

	There is one obstacle in the middle of a 3x3 grid as illustrated below.

	[
  		[0,0,0],
  		[0,1,0],
  		[0,0,0]
	]

	The total number of unique paths is 2.
 * @author patrick
 *
 */
public class UniquePathII {
	/**
	 * basically same as the PathI problem.
	 * set array[x][y]=0 where obstacleGrid[x][y]=1 (blocked)
	 * @param obstacleGrid
	 * @return
	 */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        //initialization
        int[][] array = new int[m][n];
        boolean blocked = false;
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1){
                array[0][i]=0;
                blocked = true;
            }
            if(blocked){
                array[0][i]=0;
            }else{
                array[0][i]=1;
            }
        }
        blocked=false;
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                array[i][0]=0;
                blocked = true;
            }
            if(blocked){
                array[i][0]=0;
            }else{
                array[i][0]=1;
            }
        }
        //iteratively computing
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    array[i][j]=0;
                }else{
                    array[i][j]+=array[i-1][j]+array[i][j-1];
                } 
            }
        }
        return array[m-1][n-1];
        
    }
}
