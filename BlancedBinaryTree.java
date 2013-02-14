package leetcode;
/**
 * Given a binary tree, determine if it is height-balanced.

   For this problem, a height-balanced binary tree is defined as a binary tree 
   in which the depth of the two subtrees of every node never differ by more than 1. 
 * @author patrick
 *
 */
public class BlancedBinaryTree {
	boolean flag;
    
    public boolean isBalanced(TreeNode root) {
        flag=true;
        visitTree(root,0);
        return flag;
    }
    
    public int visitTree(TreeNode root,int level){
        if(root!=null){
            level++;
            int left = visitTree(root.left,level);
            int right = visitTree(root.right,level);
            if(Math.abs(left-right)>1){
                flag=false;
            }
            return left>right?left:right;    
            
        }else{
            return level;
        }
    }
}
