package leetcode;
/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author patrick
 *
 */
public class ConverteSortedArrayToBST {
	
    public TreeNode sortedArrayToBST(int[] num) {
        return constructTree(0,num.length-1,num);  
    }
    
    private TreeNode constructTree(int start,int end,int[] num){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left=constructTree(start,mid-1,num);
        root.right=constructTree(mid+1,end,num);
        return root;
    }
}
