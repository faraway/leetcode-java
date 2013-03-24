/**
Given a collection of integers that might contain duplicates, S, return all possible subsets.
Note:


  * Elements in a subset must be in non-descending order.
	* The solution set must not contain duplicate subsets.

For example,
If S = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

**/

import java.util.HashMap;

public class SubsetsII {
    ArrayList<ArrayList<Integer>> result;
    
    int[] input;
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        result = new ArrayList<ArrayList<Integer>>();
        input=num;
        java.util.Arrays.sort(input);//to meet OJ restrictions
        generateSubsets(0,new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());//add one more empty set
        return result;
    }
    private void generateSubsets(int start,ArrayList<Integer> current){
        HashMap<Integer,Integer> unique = new HashMap<Integer,Integer>(); // to make sure no duplicates
        for(int i=start;i<input.length;i++){
            if(unique.get(input[i])==null){
                unique.put(input[i],1);
                ArrayList<Integer> temp = (ArrayList<Integer>)current.clone();
                temp.add(input[i]);
                result.add(temp);
                generateSubsets(i+1,temp);
            }
        }
    }
}

