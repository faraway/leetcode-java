package leetcode;

import java.util.Stack;

/**
 * Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area. 
 * @author patrick
 *
 */
public class MaximalRectangle {
	Stack<Integer> heights;
	Stack<Integer> indices;
	
	/**
	 * @note:this functions iterate row by row.
	 * 		 for each row, it's a Largest Rectangle In Histogram PROBLEM 
	 * 		 so just use the findMaxRect function in that problem whose time cost is O(n), 
	 *       in which n is number of columns.
	 *       Therefore, total time cost is m * O(n) = O(mn) , m is number of rows
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length<1)
			return 0;
		
		int maxRectangle = 0;
		heights = new Stack<Integer>();
		indices = new Stack<Integer>();
		int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]=='0')
        			cache[i][j]=0;
        		else{
        			if(i>0)
        				cache[i][j]=cache[i-1][j]+1;
        			else
        				cache[i][j]=1;
        		}
        	}
        	int rowMax = findMaxRect(cache[i]);
        	if(rowMax>maxRectangle)
        		maxRectangle = rowMax;
        }
        return maxRectangle;
    }
	
	private int findMaxRect(int[] columes){
    	int max = 0;
    	int lastIndex = 0;
    	
    	for(int i=0;i<columes.length;i++){
    		if(heights.empty() || columes[i]>heights.peek()){ //current > top,just push in
    			heights.push(columes[i]);
    			indices.push(i);
    		}else if(columes[i]<heights.peek()){ //current < top
    			while(!heights.empty() && heights.peek()>columes[i]){
    				lastIndex=indices.pop();
    				int temp = heights.pop();
                    if((i-lastIndex)*temp > max)
            			max = (i-lastIndex)*temp;
    			}
    			
    			heights.push(columes[i]);
    			indices.push(lastIndex);
    		}
    		//note:if current = top , just ignore it.
    	}
    	/**
    	 * note: after processing, there still maybe elements in the stack.
    	 *       but they MUST BE in ascending order in the stack from bottom to top.
    	 */
    	while(!heights.empty()){
    		int temp = (columes.length-indices.pop())*heights.pop();
    		if(temp>max)
    			max = temp;
    	}
    	return max;
    	
    }
	
	/**
	 * Because that I just take advantage of the findMaxRect() method from Largest Rectangle In Histogram PROBLEM
	 * Therefore in each row, it actually traversal the columns twice. it's O(2mn) in total.
	 * In order to pass the leetcode OJ, we need to combine them, this time, the algorithm is real O(mn)
	 * @param matrix
	 * @return
	 */
	public int maximalRectangleCombine(char[][] matrix) {
		if(matrix.length<1)
			return 0;
		
		int maxRectangle = 0;
		heights = new Stack<Integer>();
		indices = new Stack<Integer>();
		int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
        	int lastIndex = 0;
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]=='0')
        			cache[i][j]=0;
        		else{
        			if(i>0)
        				cache[i][j]=cache[i-1][j]+1;
        			else
        				cache[i][j]=1;
        		}
        		//findmax() function part
        		if(heights.empty() || cache[i][j]>heights.peek()){ //current > top,just push in
        			heights.push(cache[i][j]);
        			indices.push(j);
        		}else if(cache[i][j]<heights.peek()){ //current < top
        			while(!heights.empty() && heights.peek()>cache[i][j]){
        				lastIndex=indices.pop();
        				int temp = heights.pop();
                        if((j-lastIndex)*temp > maxRectangle)
                        	maxRectangle = (j-lastIndex)*temp;
        			}
        			heights.push(cache[i][j]);
        			indices.push(lastIndex);
        		}
        		
        	}
        	while(!heights.empty()){
        		int temp = (cache[i].length-indices.pop())*heights.pop();
        		if(temp>maxRectangle)
        			maxRectangle = temp;
        	}
        }
        return maxRectangle;
    }
	
	/**
	 * TEST
	 * @param args
	 */
	public static void main(String[] args){
		MaximalRectangle test = new MaximalRectangle();
		char[][] data = new char[][]{{'0'}};
		test.maximalRectangle(data);
	}
}
