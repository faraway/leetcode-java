package leetcode;
/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author patrick
 * @date 2012.10.3 PASS
 *
 */
public class ConstructBinaryTreePreorderInorder {
	
	    public TreeNode buildTree(int[] inorder, int[] preorder) {
	    	//empty input check
	    	if(inorder==null||inorder.length==0){
	    		return null;
	    	}
	        return recursiveBuild(inorder, preorder, 0, inorder.length, 0);
	    }	

	    /**
	     * recursive build function
	     * @param in           array of inorder seq.
	     * @param pre          array of preorder seq.
	     * @param in_start     start index of inorder array 
	     * @param in_end       end   index (not included) of inorder array 
	     * @param pre_start    start index of preorder array 
	     *       *pre_end      this tends to be proven not necessary.
	     * @return
	     */
	    TreeNode recursiveBuild(int[] in, int[] pre, int in_start, int in_end, int pre_start){
	    	if(in_start>=in_end){ //out of bounds
	    		return null;
	    	}
	    	int data = pre[pre_start];
	    	TreeNode root = new TreeNode(data);
	    	
	    	int in_index=in_start;
	    	
	    	for(int i=in_start;i<in_end;i++){
	    		if(in[i]==data){
	    			in_index = i;
	    			break;
	    		}
	    	}
	    	root.left = recursiveBuild(in,pre,in_start,in_index,pre_start+1);
	    	root.right = recursiveBuild(in,pre,in_index+1,in_end,in_index-in_start+pre_start+1);
	    	return root;
	   }
}


 
