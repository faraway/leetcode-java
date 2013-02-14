package leetcode;

/**
 *  Given a binary tree

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a PERFECT binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 * @author patrick
 *
 */
public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        connect(root.left,root.right);
    }
	
	private void connect(TreeLinkNode n1,TreeLinkNode n2){
		if(n1==null||n2==null)
			return;
		n1.next=n2;
		connect(n1.left,n1.right);
		connect(n1.right,n2.left);
		connect(n2.left,n2.right);
	}
	
}

class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
 }