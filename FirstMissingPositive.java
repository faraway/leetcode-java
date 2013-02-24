package leetcode;

/**
 *  Given an unsorted integer array, find the first missing positive integer.

	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.

	Your algorithm should run in O(n) time and uses constant space. 
 * @author patrick
 * TODO Not constant space.
 *
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int[] check = new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i]<=0||A[i]>A.length){
                continue;
            }else{
                check[A[i]-1]=1;
            }
        }
        for(int i=0;i<check.length;i++){
            if(check[i]==0){
                return i+1;
            }
        }
        return check.length+1;
    }
    /**
     * solution from http://haixiaoyang.wordpress.com/2012/08/04/leetcode-find-the-first-missing-positive/
     * @param A
     * @param n
     * @return
     */
    int firstMissingPositive(int A[], int n){
    	    //set the array if array[i]==i+1
    	    for (int i = 0; i < n; i++){
    	        if (A[i] == i+1) continue;
    	 
    	        while (A[i] >= 1 && A[i] <= n && A[i] != i+1 && A[A[i]-1] != A[i]){
    	        	//swap A[i] and A[A[i]-1]
    	        	A[i]=A[i]^A[A[i]-1];
    	        	A[A[i]-1]=A[i]^A[A[i]-1];
    	        	A[i]=A[i]^A[A[i]-1]
    	        }
    	    }
    	    //go through the array, find the first array[i]!=i+1, is our answer
    	    for (int i = 0; i < n; i++)
    	        if (A[i] != i+1) return i+1;
    	    //if the array are all set, then answer is n+1
    	    return n+1;
   }
}
