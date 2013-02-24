package leetcode;
/**
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

	For example,
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
	
   @note: Similar to google's "Container With Most Water" problem
 * @author patrick
 *
 */
public class TrappingRainWater {
    public int trap(int[] A) {
	if(A.length<3)
		return 0;
		
	int sum=0;
        int min=A[0]<A[A.length-1]? A[0]:A[A.length-1];
        
        int start = 0;
        int end = A.length-1;
        
        while(start<=end){
        	if(A[start]<=A[end]){
        		if(A[start]<min)
        			sum+=min-A[start];
        		else
        			min=A[start];
        		start++;
        	}else{
        		if(A[end]<min)
        			sum+=min-A[end];
        		else
        			min=A[end];
        		end--;
        	}
        }
        return sum;
    }
}
