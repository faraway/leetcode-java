/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.
**/

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int cols=matrix[0].length;
        
        int row = findRow(matrix,target,0,matrix.length-1,cols);
        if(row<0)
            return false;
        return findElement(matrix[row],target,0,cols-1);
        
    }
    
    private int findRow(int[][] matrix, int target, int start, int end,int cols){
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(target==matrix[mid][cols-1])
            return mid;
        if(target<matrix[mid][cols-1]){
            if(mid==start || target>matrix[mid-1][cols-1])
                return mid;
            else
                return findRow(matrix,target,start,mid-1,cols);
        }else
            return findRow(matrix,target,mid+1,end,cols);
    }
    
    private boolean findElement(int[] row, int target, int start, int end){
        if(start>end)
            return false;
        int mid=(start+end)/2;
        
        if(row[mid]==target)
            return true;
        if(row[mid]>target)
            return findElement(row,target,start,mid-1);
        else
            return findElement(row,target,mid+1,end);
    }
}
