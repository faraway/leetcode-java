package leetcode;
import java.util.ArrayList;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

	For example:
	Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

	return its level order traversal as:

	[
  		[3],
  		[9,20],
  		[15,7]
	]

 * @author patrick
 *
 */

public class BinaryTreeLevelOrderTraversal {
	/**
	 * use current and next two arrays to traversal the tree like BFS
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return result;
        }
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        current.add(root);
        while(current.size()!=0){
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(TreeNode n : current){
                level.add(n.val);
                if(n.left!=null)
                    next.add(n.left);
                if(n.right!=null)
                    next.add(n.right);
            }
            result.add(level);
            ArrayList<TreeNode> temp = current;
            current = next;
            temp.clear();
            next = temp;
        }
        /**
         * @note
         * if it is Binary Tree Level Order Traversal II, then same thing, just reverse the result.
         */
        java.util.Collections.reverse(result);
        
        return result;
    }
}
