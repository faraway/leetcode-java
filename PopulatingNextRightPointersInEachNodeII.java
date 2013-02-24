package leetcode;
/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

 * @author patrick
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        /**
         * current rightmost node
         */
        TreeLinkNode rightmost = null;
        /**
         * nextHead is the head node which is not null in next level
         *               1                 ----1
         *              / \ 
         *             2   3               ----2
         *            / \ / \
         *           6  7 8  9             ----3
         *             /   \  \
         *            10   11 12           ----4
         *            
         * e.g. node 10, it's the head of level 4 but not the left child of 6.
         */ 
        TreeLinkNode nextHead = null;
        TreeLinkNode temp = root;
        //connect next level of current root node level
        while(temp!=null){
            if(temp.left!=null){
            	if(rightmost==null){
            		rightmost=temp.left;
            		nextHead=temp.left;
            	}
            	else{
            		rightmost.next = temp.left;
            		rightmost = rightmost.next;
            	}
            }
            if(temp.right!=null){
            	if(rightmost==null){
            		rightmost=temp.right;
            		nextHead=temp.right;
            	}
            	else{
            		rightmost.next = temp.right;
            		rightmost = rightmost.next;
            	}
            }
            temp=temp.next;
        }
        //head in next level
        connect(nextHead);
    }
}
