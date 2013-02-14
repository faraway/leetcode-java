package leetcode;
import java.util.ArrayList;
/**
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *  For example:
 *  Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

	return

	[
   		[5,4,11,2],
   		[5,8,4,5]
	]

 * @author patrick
 *
 */

public class PathSumII {
    private ArrayList<ArrayList<Integer>> result;
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<ArrayList<Integer>> ();
        getSum(root,sum,0,new ArrayList<Integer>());
        return result;  
    }
    
    public void getSum(TreeNode root, int sum, int acc, ArrayList<Integer> pre){
        if(root!=null){
            //ArrayList<Integer> newArray = (ArrayList<Integer>)pre.clone();
            acc+=root.val;
            pre.add(new Integer(root.val));
            if(acc==sum && root.left==null && root.right==null){
                result.add(pre);
            }else{
            	//left child use the original array while the right child uses a brand new copy one.
            	//we can copy the pre first, and add root.val to it, pass to resucive function,
            	//in which they will clone a new one. But they will clone 2 times than this one.
            	//while clone may take relatively longer time, avoid cloning may be a good choise.
                ArrayList<Integer> preCopy = (ArrayList<Integer>)pre.clone();
                getSum(root.left,sum,acc,pre);
                getSum(root.right,sum,acc,preCopy);
            }
        }
    }
}
