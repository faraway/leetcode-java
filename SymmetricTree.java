package leetcode;
import java.util.ArrayList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

	For example, this binary tree is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3

	But the following is not:

        1
       / \
      2   2
       \   \
       3    3

 * @author patrick
 *
 */
public class SymmetricTree {
	    public boolean isSymmetric(TreeNode root) {
	        if(root==null){
	            return true;
	        }else{
	            return checkSymmetric(root.left,root.right);
	        }
	        
	    }
	    /**
	     * @Recursive method
	     * @param left
	     * @param right
	     * @return
	     */
	    public boolean checkSymmetric(TreeNode left, TreeNode right){
	        if(left==null && right==null){
	            return true;
	        }
	        if(left==null || right==null){
	            return false;
	        }
	        if(left.val==right.val){
	        	/**
	        	 * only both left&right && left&right is symmetric, the subtree is symmetric.
	        	 */
	            return checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
	        }else{
	            return false;
	        }
	    }
	    /**
	     * @Iterative method,basically BFS
	     * @param root
	     * @return
	     */
	    public boolean checkSymmetricIteratively(TreeNode root){
	    	//Queue<TreeNode> q = new LinkedList<TreeNode>();
	    	boolean result = true;
	    	
	    	if(root==null){
	    		return result;
	    	}
	    	else{
		    	ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		    	ArrayList<TreeNode> next = new ArrayList<TreeNode>();
	    		current.add(root);
	    		outer:while(current.size()!=0){
	    			//check current
	    			int mid=current.size()/2;
	    			for(int i=0;i<mid;i++){
	    				if(current.get(i)==null && current.get(current.size()-1-i)==null){
	    					continue;
	    				}
	    				if(current.get(i)==null || current.get(current.size()-1-i)==null){
	    					result = false;
	    					break outer;
	    				}
	    				if(current.get(i).val!=current.get(current.size()-1-i).val){
	    					result = false;
	    					break outer;
	    				}
	    			}
	    			for(int i=0;i<current.size();i++){
	    				if(current.get(i)!=null){
	    					next.add(current.get(i).left);
	    					next.add(current.get(i).right);
	    				}
	    			}
	    			/**
	    			 * set next loop
	    			 * reuse the current & next two arrays again and again.
	    			 */
	    			ArrayList<TreeNode> temp = current;
	    			current = next;
	    			temp.clear();
	    			next = temp;	
	    		}
	    		
	    		return result;
	    	}
	    }
}
