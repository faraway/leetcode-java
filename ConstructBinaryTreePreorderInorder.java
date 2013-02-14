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
	    	
//          codes below may reduce some function calls, but not necessary.
//          since if in_start == in_end -1, 
//          then right :	   in_index+1 [start]  will = in_end [end]
//          and  left  :       in_start   [start]  will = in_index [end]
//          which will both equal null by function call again. and results exactly same as below codes.
	    	
//	    	if(in_start==in_end-1){
//	    		root.left=null;
//	    		root.right=null;
//	    		return root;
//	    	}
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
	    
	    public static void main(String[] args){
	    	int[] pre = {1,2};
	    	int[] in  = {2,1};
	        new ConstructBinaryTreePreorderInorder().buildTree(pre,in);
	    }
}


 