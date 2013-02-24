package leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Personal thought, converting the list to an array first makes the problem much easier.
 * And also, more efficient than go through the list again and again.  
 * @author patrick
 *
 */
public class ConvertSortedListToBST {
	
	    public TreeNode sortedListToBST(ListNode head) {
	        List<ListNode> list = new ArrayList<ListNode>(); 
	        while(head!=null){
	            list.add(head);
	            head=head.next;
	        }
	        return constructTree(0,list.size()-1,list); 
	    }
	    
	    private TreeNode constructTree(int start,int end,List<ListNode> num){
	        if(start>end){
	            return null;
	        }
	        int mid = (start+end)/2;
	        TreeNode root = new TreeNode(num.get(mid).val);
	        root.left=constructTree(start,mid-1,num);
	        root.right=constructTree(mid+1,end,num);
	        return root;
	    }
	        
}
