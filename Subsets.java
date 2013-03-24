import java.util.HashMap;
/**
 Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
**/

public class Subsets {
    ArrayList<ArrayList<Integer>> result;
    
    int[] input;
    
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        result = new ArrayList<ArrayList<Integer>>();
        input=num;
        java.util.Arrays.sort(input);//to meet OJ restrictions
        generateSubsets(0,new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());//add one more empty set
        return result;
    }
    private void generateSubsets(int start,ArrayList<Integer> current){
        for(int i=start;i<input.length;i++){
            ArrayList<Integer> temp = (ArrayList<Integer>)current.clone();
            temp.add(input[i]);
            result.add(temp);
            generateSubsets(i+1,temp);
            
        }
    }
}

