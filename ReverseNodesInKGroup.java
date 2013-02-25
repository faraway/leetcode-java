/**


Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //check size >=k
        ListNode p=head;
        int i=0;
        while(i<k){
            if(p==null)//tail
                return head;
            p=p.next;
            i++;
        }
        ListNode nextGroup = p;
        //reverse this group
        ListNode p1=head;
        ListNode p2=null;
        ListNode temp=null;
        i=0;
        while(i<k){
            temp=p1;
            p1=p1.next;
            temp.next=p2;
            p2=temp;
            i++;
        }
        // head is the tail of reversed list.
        head.next = reverseKGroup(nextGroup,k);
        return p2;
       
    }
}
