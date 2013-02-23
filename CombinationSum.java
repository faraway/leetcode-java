package leetcode;
import java.util.ArrayList;
/**
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.

	Note:

    	All numbers (including target) will be positive integers.
    	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    	The solution set must not contain duplicate combinations.

	For example, given candidate set 2,3,6,7 and target 7,
	A solution set is:
	[7]
	[2, 2, 3] 
 * @author patrick
 * @goodjob :)
 *
 */

public class CombinationSum {
	private ArrayList<ArrayList<Integer>> result;
    	/**entry function**/
    	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<ArrayList<Integer>>();
        java.util.Arrays.sort(candidates);
        findCombinations(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    /**
     * recursive function.
     * @param candidates
     * @param target
     * @param index
     * @param pre
     * @return
     */
    private boolean findCombinations(int[] candidates,int target,int index,ArrayList<Integer> pre){
        if(index>=candidates.length){
            return false;
        }
        /**don't include current candidate at position [index]**/
        findCombinations(candidates,target,index+1,pre);
        /**include current candidate at position [index] at least once**/
        while(candidates[index]<=target){
            ArrayList<Integer> copy = (ArrayList<Integer>)pre.clone();
            pre=copy;
            copy.add(candidates[index]);//add current element in
            
            if(candidates[index]==target){
                result.add(copy);//add to result set
            }
            if(candidates[index]<target){//otherwise keep digging
                findCombinations(candidates,target-candidates[index],index+1,copy);
            }
            target-=candidates[index];
        }
        return true;
    }
}
