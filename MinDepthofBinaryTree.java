package leetcode;
/**
 * Given a binary tree, find its minimum depth.
 * @author patrick
 *
 */
public class MinDepthofBinaryTree {
	public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return 0;
        }else{
            return minTreeDepth(root,1); // root is level 1 !!!
        }
    }
	/**
	 * recursive function
	 * @param root
	 * @param level
	 * @return
	 */
	public int minTreeDepth(TreeNode root, int level){
		if(root==null){
			return Integer.MAX_VALUE;
		}
		int left = minTreeDepth(root.left,level+1);
		int right = minTreeDepth(root.right,level+1);
		if(left ==Integer.MAX_VALUE && right ==Integer.MAX_VALUE){
			return level;
		}else{
			return left<right?left:right;
		}
	}

}
