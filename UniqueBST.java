package leetcode;
/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 * For example,
 * Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author Patrick Yao
 */
public class UniqueBST {
	
    public int solution(int n) {
    	/**
    	 * for this problem, total possible constructions is total trees chosen root as 1....n.
    	 */
        return getNumTrees(1,n);
    }
    
    /**
     * @Recursive Method
     * @param start  start of the array.
     * @param end    end of the array.
     * @return
     */
    public int getNumTrees(int start,int end){
        if(start==end){
            return 1;
        }
        int total=0;
        /**
         * pick each one of the array[start,end] as the root.
         */
        for(int i=start;i<=end;i++){
            int left=1;
            int right=1;
            if(i-1>=start){
            	//left subtree numbers
                left=getNumTrees(start,i-1);
            }
            if(i+1<=end){
            	//right subtree numbers
                right=getNumTrees(i+1,end);
            }
            //add all possible constructs with root as i.
            total+=left*right;
        }
        return total;
    }
    
    /**
     * @Iterative Method (DP)
     * @Note: array[i] = the number of different constructions with root as i
     * @param n
     * @return
     */
    public int getNumTreesInterative(int n){
    	int[] array = new int[n+1];
    	array[0] = 1;//no node counts as one structure.
    	for(int i=1;i<n+1;i++){//for each iteration, calculate all possible constructions with root as i.
    		int total=0;
    		int subNodes=i-1;//all the sub nodes(left or right)
    		for(int j=0;j<=subNodes;j++){
    			/**
    			 * e.g.three sub nodes, 1,2,3 or 4,5,6 they have same number of ways.
    			 * so,if total 4 sub nodes.
    			 * then all ways of subtree constructions will be 0,4 ; 1,3 ; 2,2 ; 3,1 ; 4,0
    			 * which will all be calculated before. 
    			 */
    			total+=array[j]*array[subNodes-j];
    		}
    		array[i] = total;
    	}
    	return array[n];
    }
}
