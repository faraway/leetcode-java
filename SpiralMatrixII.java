/**
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
**/

public class SprialMatrixII {
    public int[][] generateMatrix(int n) {
       int[][] matrix = new int[n][n];
       if(n<1)
            return matrix;
       int val=1;
       for(int i=0;i<=n/2;i++){
            //top elements
            for(int j=i;j<n-i-1;j++)
                matrix[i][j]=val++;
            //right elements
            for(int j=i;j<n-i-1;j++)
                matrix[j][n-1-i]=val++;
            //bottom elements
            for(int j=n-1-i;j>i;j--)
                matrix[n-1-i][j]=val++;
            //left elements
            for(int j=n-i-1;j>i;j--)
                matrix[j][i]=val++;
        }
        if((n&1)==1)
            matrix[n/2][n/2]=val;
        return matrix;
        
    }
}
