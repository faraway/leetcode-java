package leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

	For "(()", the longest valid parentheses substring is "()", which has length = 2.

	Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 * @author patrick
 *
 */
public class LongestValidParentheses {
	int max=0;
	/**
	 * @note solution 1
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		max = 0;
        int left=0;
        int right=0;
        //left>=right
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='(')
        		left++;
        	else
        		right++;
        	if(left==right && left+right>max)
        		max=left+right;
        	if(right>left){
        		left=0;
        		right=0;
        	}
        }
        //right>left
        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--){
        	if(s.charAt(i)=='(')
        		left++;
        	else
        		right++;
        	if(left==right && left+right>max)
        		max=left+right;
        	if(left>right){
        		left=0;
        		right=0;
        	}
        }
        return max;
        
    }
	
	/**
	 * @note solution2
	 * @key point:
	 *    if ')' is more, use (1) to cut the link between current and previous
	 *    if '(' is more, use (2) to calculate the current length
	 * @param s
	 * @return
	 */
	public int longestValidParenthesesUsingStack(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;//max length
		int sum = 0;//accumulated length
		
		for(int i=0;i<s.length();i++){
			//it's '('
			if(s.charAt(i)=='('){
				stack.push(i);
				continue;
			}
			//it's ')'
			if(stack.empty()){
				sum=0; //more ')', previous sub can't be extended  (1)
			}else{
				int pair = stack.pop();
				int len = i-pair+1;
				if(stack.empty()){//all are coupled, add current(i-pair+1) and previous sum
					sum+=len;
					len=sum;
				}else{//more '(', only current sub can be counted
					len = i-stack.peek(); //(2)
				}
				if(len>max)
					max=len;
			}
		}
		return max;
	}
}
