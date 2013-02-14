package leetcode;

import java.util.Stack;

/**
 *  Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


	Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


	The largest rectangle is shown in the shaded area, which has area = 10 unit.

	For example,
	Given height = [2,1,5,6,2,3],
	return 10. 
 * @author patrick
 *
 */
public class LargestRectangleInHistogram {
	private int max;
    
    private int[] height;
    
    public int largestRectangleArea(int[] height) {
        this.height=height;
        max=0;
        findMax(0,height.length-1);
        return max;
    }
    /**
     * like partition, average time complexity is O(nlogn)
     * but when applied to sorted array, may degrade to O(n^2),and stack overflow error may happen
     * O(n) solutions exists. see below
     * @param start
     * @param end
     * @return
     */
    private boolean findMax(int start,int end){
        if(start>end)
            return false;
        int min=height[start];
        int minIdx=start;
        for(int i=start;i<=end;i++){
            if(height[i]<min){
                min=height[i];
                minIdx=i;
            }
        }
        if ((end-start+1)*min > max)
            max = (end-start+1)*min;
        findMax(start,minIdx-1);
        findMax(minIdx+1,end);
        return true;
    }
    /**
     * using stack to track the status O(n) solutions
     * KEY:
     * the height in the stack is always in ascending order in the stack from bottom to top.
     * if a new height is less than top
     * -1.pop out all the height bigger than the new height
     * -2.calculate these part of max areas (not including current)
     * -3.make current as height[i] and index=lastIndex(last element bigger than current popped)
     * @param height
     * @return
     */
    private int findMaxUsingStack(int[] height){
    	Stack<Integer> heights = new Stack<Integer>();
    	Stack<Integer> indices = new Stack<Integer>();
    	int max = 0;
    	int lastIndex = 0;
    	
    	for(int i=0;i<height.length;i++){
    		if(heights.empty() || height[i]>heights.peek()){ //current > top,just push in
    			heights.push(height[i]);
    			indices.push(i);
    		}else if(height[i]<heights.peek()){ //current < top
    			while(!heights.empty() && heights.peek()>height[i]){
    				lastIndex=indices.pop();
    				int temp = heights.pop();
                    if((i-lastIndex)*temp > max)
            			max = (i-lastIndex)*temp;
    			}
    			
    			heights.push(height[i]);
    			indices.push(lastIndex);
    		}
    		//note:if current = top , just ignore it.
    	}
    	/**
    	 * note: after processing, there still maybe elements in the stack.
    	 *       but they MUST BE in ascending order in the stack from bottom to top.
    	 */
    	while(!heights.empty()){
    		int temp = (height.length-indices.pop())*heights.pop();
    		if(temp>max)
    			max = temp;
    	}
    	return max;
    	
    }
    
    
    /**test Method**/
    public static void main(String[] args){
    	LargestRectangleInHistogram l = new LargestRectangleInHistogram();
    	int[] array = new int[20000];
    	for(int i=0;i<20000;i++){
    		array[i]=i;
    	}
    	// l.largestRectangleArea(array);   //STACK OVERFLOW EXCEPTION
    	System.out.println(l.findMaxUsingStack(array));
    }
}
