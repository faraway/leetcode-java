/**

 Given a binary tree, return the inorder traversal of its nodes' values.
 Recursion is trivial. This is iterative solution.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(root==null)
            return list;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true){
            if(root.left!=null){
                stack.push(root);
                root=root.left;
                continue;
            }
            if(root.right!=null){
                list.add(root.val);
                root=root.right;
                continue;
            }
            list.add(root.val);
            if(stack.isEmpty())
                break;
            else{
                root=stack.pop();
                /**
                 * Warning: This will destroy the input tree.
                 *          An alternative way is to set some sort of flag
                 *          to mark this node is popped of stack,
                 *          which means its left subtree has been visited
                 * */
                root.left=null;
            } 
        }
        return list;   
    }
}
