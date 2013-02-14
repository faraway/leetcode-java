package leetcode;
/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Your goal is to reach the last index in the minimum number of jumps.

	For example:
	Given array A = [2,3,1,1,4]

	The minimum number of jumps to reach the last index is 2. 
	(Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
 * @author patrick
 *
 */
public class JumpGameII {
	/**
	 * Similar to JumpGame,iterating from end to start.
	 * check[i] indicates the minimum number of jumps from A[i] to A[end].
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {
        int[] check = new int[A.length];
        for(int i=0;i<A.length;i++){
            check[i]=Integer.MAX_VALUE;
        }
        check[A.length-1]=0;
        for(int i = A.length-2;i>=0;i--){
            int limit = A[i]+i>A.length-1?A.length-1:A[i]+i;
            for(int j=i+1;j<=limit;j++){
                if(check[i]>check[j]){
                    check[i]=check[j];
                }
            }
            if(check[i]!=Integer.MAX_VALUE)
                check[i]+=1;
        }
        return check[0];
    }
}
