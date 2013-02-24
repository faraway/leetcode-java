/**
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
**/

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
     
        ArrayList<Integer> list = new ArrayList<Integer>();

        int rows = matrix.length;
        if(rows==0)
            return list;
        int columns = matrix[0].length;

        //take the min of rows & columns to be limit
        int limit = (rows<columns? rows-1:columns-1)/2;
        
        for(int i=0;i<=limit;i++){
            //top
            for(int k=i;k<columns-i;k++)
                list.add(matrix[i][k]);
            //right
            for(int k=i+1;k<rows-i-1;k++)
                list.add(matrix[k][columns-i-1]);
            //bottom
            int row = rows-1-i;
            if(row>i){
                for(int k=columns-i-1;k>=i;k--)
                    list.add(matrix[row][k]);
            }
            //left
            int rightColumn = columns-i-1;
            if(i<rightColumn){
                for(int k = rows-i-2;k>i;k--)
                    list.add(matrix[k][i]);
            }
        }
        return list;
    }
}
