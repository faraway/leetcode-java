package leetcode;
/**
 *  Given a binary tree, flatten it to a linked list in-place.

	For example,
	Given

         1
        / \
       2   5
      / \   \
     3   4   6

	The flattened tree should look like:

    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6

 * @author patrick
 *
 */
public class FlattenBinaryTreetoLinkedList {
    TreeNode pre;
    
    public void flatten(TreeNode root) {
        preOrderTraversal(root);
        ajustTree(root);
    }
    /**
     * change to tree to left flatter tree.
     *                          1
     *                         /
     *                        2
     *                       /
     *                      3
     *                     /
     *                    4
     *                   ...
     * @note since root.right will be used in the future, so i can't build it at once.
     * @param root
     */
    private void preOrderTraversal(TreeNode root){
        if(root!=null){
            if(pre!=null){
                pre.left = root;
            }
            pre = root;
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    /**
     * change it to required tree.
     *  			1                1
     *                         /		  \
     *                        2                    2
     *                       /           =>         \
     *                      3                        3
     *                     /			      \
     *                    4                            4
     *                   ..                            ..
     * @param root
     */
    private void ajustTree(TreeNode root){
        while(root!=null){
            root.right=root.left;
            root.left=null;
            root = root.right;
        }
    }
}
