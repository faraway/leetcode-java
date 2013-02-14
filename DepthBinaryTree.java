package leetcode;
/**
 * Given a binary tree, find its depth (maximum height).
 * @author patrick
 * @date   2012.10.1
 */

public class DepthBinaryTree {
    public int maxHeight(TreeNode root) {
        return dfs(root,0);    
    }
    
    int dfs(TreeNode root,int rootLevel){
        if(root==null){
            return rootLevel;
        }else{
            rootLevel++;
            int leftDepth = dfs(root.left,rootLevel);
            int rightDepth = dfs(root.right,rootLevel);
            return leftDepth>rightDepth ? leftDepth:rightDepth;
        }
    }
    
}
/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
