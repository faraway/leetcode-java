package leetcode;
import java.util.ArrayList;

/**
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	Each number in C may only be used once in the combination.

	Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

	For example, given candidate set 10,1,2,7,6,1,5 and target 8,
	A solution set is:
	[1, 7]
	[1, 2, 5]
	[2, 6]
	[1, 1, 6] 
 * @author patrick
 * @goodjob :)
 */
public class CombinationSumII {
    private ArrayList<ArrayList<Integer>> result;
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        
        result = new ArrayList<ArrayList<Integer>>();
        java.util.Arrays.sort(candidates);
        findCombinations(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    
    private void findCombinations(int[] candidates,int target,int index,ArrayList<Integer> pre){
        if(index>=candidates.length||target<candidates[index]){
            return;
        }
        /**find one combination**/
        if(candidates[index]==target){
            pre.add(candidates[index]);
            result.add(pre);
            return;
        }
        if(candidates[index]<target){
            int current = candidates[index];
            index++;
            /**if take current element**/
            ArrayList<Integer> copy = (ArrayList<Integer>)pre.clone();//make a copy to use seperately as not taking this element
            copy.add(current);
            findCombinations(candidates,target-current,index,copy);
            
            /**if not take current element
             * the while loop is helping to jump to the nearest element which is not duplicated as current 
             * This is used to eliminate duplicated results.
             * If we are taking current , then take it in the above step
             * Otherwise, don't take it next step if next is same as current.
             * e.g. 2,2,2,2,3 target=7
             * then 1st, take 2, or not (jump to 3)
             * 2nd, take 2(accumu 4), or not(jump to 3)
             * 3rd, take 2(accumu 6), or not(jump to 3,which is answer[2,2,3])
             * .....
             */
            while(index<candidates.length){
                if(current == candidates[index])
                    index++;
                else
                    break;
            }
            findCombinations(candidates,target,index,pre);
        }
    }
}
