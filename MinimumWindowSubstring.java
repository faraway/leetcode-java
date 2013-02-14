package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Given a string S and a string T, 
 *  find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, 
you are guaranteed that there will always be only one unique minimum window in S. 

 * @author patrick
 *
 */
public class MinimumWindowSubstring {
	
	public String minWindow(String S, String T) {
        Queue<Integer> q = new LinkedList<Integer>();
        /**
         * chars from 'A' (65)  to 'z' (122) including '_' etc.
         */
    	int[] t = new int[58];
    	int[] check = new int[58];
    	//last index inserted into the queue
    	int lastIndex = 0;
    	//total characters found for T.  characters==T.length() means at least we found a window.
        int totalChar = 0;
        //start index of the minWindow
        int start=0;
        //end index of the minWindow
        int end=S.length();
    	//initialize target string T array.
    	for(int i=0;i<T.length();i++){
    		t[T.charAt(i)-'A']+=1;
    	}
    	
    	for(int i=0;i<S.length();i++){
    		int index = S.charAt(i)-'A';
    		if(t[index]!=0){
    			q.offer(i);
    			lastIndex=i;
    			check[index]+=1;
    			if(check[index]>t[index]){//if find more than we need.
    				//try to move the window
    				while(!q.isEmpty()){
    					int head = S.charAt(q.peek())-'A';
    					if(check[head]>t[head]){
    						q.poll();
    						check[head]--;
    					}else
    						break;
    				}
    			}else{
    				totalChar++;
    			}
    			if(totalChar==T.length()){//all found in window
    				if(lastIndex-q.peek()<(end-start)){
    					start = q.peek();
    					end=lastIndex;
    				}
    			}
    		}
    	}
    	if(totalChar<T.length())//not found
    		return "";
    	else
    		return S.substring(start,end+1);
        
    }
	
	
	public static void main(String[] args){
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		//expected : BANC
		System.out.println(test.minWindow("ADOBECODEBANC", "ABC")); 
		//expected: sk_not_what_your_c
		System.out.println(test.minWindow("ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", "ask_country"));
	}
}
