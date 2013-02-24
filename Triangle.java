package leetcode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle. 
 * @author patrick
 *
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	
        ArrayList<Integer> pre = new ArrayList<Integer>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        
        if(triangle.size()==1){
        	return triangle.get(0).get(0);
        }
        
        pre = triangle.get(0);
        for(int i=1;i<triangle.size();i++){
        	ArrayList<Integer> layer = triangle.get(i);
        	current.add(pre.get(0)+layer.get(0));
        	for(int j=1;j<layer.size()-1;j++){
        		int temp=pre.get(j-1)<pre.get(j)?pre.get(j-1):pre.get(j);
        		current.add(temp+layer.get(j));
        	}
        	current.add(pre.get(layer.size()-2)+layer.get(layer.size()-1));
        	ArrayList<Integer> temp = pre;
        	pre=current;
        	current=temp;
        	current.clear();
        }
        
        int min=Integer.MAX_VALUE;
        for(Integer i:pre){
        	if (i<min)
        		min = i;
        }
        return min;
    }
}
