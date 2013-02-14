package leetcode;
/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Determine if you are able to reach the last index.

	For example:
	A = [2,3,1,1,4], return true.

	A = [3,2,1,0,4], return false. 
 * @author patrick
 *
 */
public class JumpGame {
	 /**
	  * Kind of a DP method, calculate from end to start.
	  * 
	  * check[i] indicates from A[i] can reach A[end] or not.
	  * 
	  * A=[2,3,1,1,4]
	  * check = [0,0,0,0,1]
	  * then compute check[3]: A[3] can reach A[4],which check[4]=1, so check[3]=1
	  *              check[2]: A[2] can reach A[3],which check[3]=1, so check[2]=1
	  *              check[1]: A[1] can reach A[2],A[3],A[4], one of check[2],check[3],check[4]=1, so A[1]=1
	  *              check[0]: similarly, check[0]=1;
	  * @param A
	  * @return
	  */
	 public boolean canJump(int[] A) {
	        int[] check = new int[A.length];
	        check[A.length-1]=1;
	        outer:for(int i = A.length-2;i>=0;i--){
	            int limit = A[i]+i>A.length-1?A.length-1:A[i]+i;
	            for(int j=i+1;j<=limit;j++){
	                if(check[j]==1){
	                    check[i]=1;
	                    continue outer;
	                }
	            }
	            check[i]=0;
	        }
	        return check[0]==1?true:false;
	        
	 }
}
