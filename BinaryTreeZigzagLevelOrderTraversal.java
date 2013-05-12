package leetcode;
import java.util.ArrayList;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

	return its zigzag level order traversal as:

	[
  		[3],
  		[20,9],
  		[15,7]
	]

 * @author patrick
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return result;
        }
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        current.add(root);
        int count = 1;
        while(current.size()!=0){
            ArrayList<Integer> level = new ArrayList<Integer>();
            //add note to next level
            for(TreeNode n : current){
                if(count%2==1)
                    level.add(n.val);
                if(n.left!=null)
                    next.add(n.left);
                if(n.right!=null)
                    next.add(n.right);
            }
            //if even level, reverse the values
            if(count%2==0){
                for(int i=current.size()-1;i>=0;i--){
                    level.add(current.get(i).val);
                }
            }
            
            result.add(level);
            ArrayList<TreeNode> temp = current;
            current = next;
            temp.clear();
            next = temp;
            count++;
        }
        return result;
    }
}
