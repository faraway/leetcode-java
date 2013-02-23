package leetcode;
import java.util.ArrayList;
/**
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

	For example,
	If n = 4 and k = 2, a solution is:

	[
  		[2,4],
  		[3,4],
  		[2,3],
  		[1,2],
  		[1,3],
  		[1,4],
	]

 * @author patrick
 *
 */

public class Combinations {
    private ArrayList<ArrayList<Integer>> result;
    /**
     * entry method
     * @param n
     * @param k
     * @return
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        result = new ArrayList<ArrayList<Integer>>();
        if(k>n){
            return result;
        }
        
        findCombinations(n,k,1,new ArrayList<Integer>());
        return result;
    }
    /**
     * @recursive way
     * @param n
     * @param k
     * @param start
     * @param pre
     * @return
     */
    private void findCombinations(int n, int k, int start,ArrayList<Integer> pre){
    	
        if(n-start+1==k){//left elements = k, so they should all be added to the list.
            for(int i=start;i<=n;i++){
                pre.add(i);
            }
            result.add(pre);
            return;
        }else{//we can choose add current integer or not.
            //add current one.
            ArrayList<Integer> temp = (ArrayList<Integer>)pre.clone();
            temp.add(start);
            if(k-1==0){//the last one.
                result.add(temp);
                return;
            }else{
                findCombinations(n,k-1,start+1,temp);
            }
            //don't add current one, jump to next int.
            findCombinations(n,k,start+1,pre);
        }
    }
}
