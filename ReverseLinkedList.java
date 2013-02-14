package leetcode;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
/**
 * Memory Limit Exceeded
 * @author patrick
 *
 */
public class ReverseLinkedList {
	int m = 0;
    int n = 0;
    ListNode last;
    ListNode conti;
    ListNode newHead;
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.m=m;
        this.n=n;
        if(m==n){ //same node, no need to reverse
            return head;
        }
        if(m==1){
            recursiveReverse(head,1);
            newHead=last;
            head.next = conti;
            return newHead;
        }else{
            ListNode begin = head;
            for(int i=2;i<m;i++){
                begin=begin.next;
            }
            ListNode start = begin.next;
            recursiveReverse(start,1);
            begin.next=last;
            start.next = conti;
            return head;
        }
        
        
    }
    /**
     * recursive function.
     * @param parent
     * @param count
     */
    private void recursiveReverse(ListNode parent,int count){
        count++;
        ListNode current = parent.next;
        if(count==(n-m+1)){
            last = current;
            conti= current.next;
            current.next=parent;
        }else{
            recursiveReverse(current,count);
            current.next = parent;
        }
    }
    
    
    public ListNode reverseBetweenIterative(ListNode head, int m, int n) {
    	if(m==n)
            return head;
        //last node of the reversed ones  
        ListNode last = head;
        //the node just before the reversed ones
        ListNode first = head;
        //temperory head
        ListNode temphead = head;
        
        int i=0;
        if(m==1){
            first = new ListNode(1);
            first.next = head;
        }
        else{
            for(i=1;i<m-1;i++)
                first = first.next;
        }
        
        temphead=first;  
        last = temphead.next;
        
        ListNode next = temphead.next;
        while(i<n){
             ListNode temp = next.next;
             next.next=temphead;
             temphead=next;
             next=temp;
             i++;
        }
        last.next = next;
        first.next = temphead;
        return m==1?temphead:head;
        
    }
    
    public static void main(String[] args){
    	ReverseLinkedList test = new ReverseLinkedList();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	a.next=b;
    	b.next=c;
    	ListNode head = test.reverseBetweenIterative(a, 2, 3);
    	while(head!=null){
    		System.out.println("node:"+head.val);
    		head=head.next;
    	}
    	
    }
}