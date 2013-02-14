package leetcode;

public class MaximumSubarray {
	/**
	 * Regular Algorithm
	 * @param A
	 * @return
	 */
	public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<A.length;i++ ){
            if(A[i]>0){
                sum+=A[i];
                if(sum>max)
                    max = sum;
            }else{
                if(A[i]>max) 
                    max = A[i];
                /**
            	 * @note above if statement is to make sure that if all elements are negative.
            	 *       In this situation, the biggest negative number is the largest sub array sum.
            	 */
                if(sum+A[i]<0)
                    sum=0;
                else
                    sum+=A[i];
            }
        }
        return max;
    }
}
