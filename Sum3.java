package leetcode;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * There could be duplicated elements in the array.
 * 
 * @author patrick
 * @date   2012.7.11
 */
public class Sum3 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	
         ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
         java.util.Arrays.sort(num);
         
         for(int i=0;i<num.length;i++){
             if(i!=0 && num[i]==num[i-1])
                continue;
             int first = num[i];
             
             int start = i+1;
             int end = num.length-1;
             while(start<end){
                 //avoid duplicates
                 if(start!=i+1 && num[start]==num[start-1]){
                     start++;
                     continue;
                 } 
                 if(first+num[start]+num[end]>0)
                    end--;
                 else if(first+num[start]+num[end]<0)
                    start++;
                 else{//triplets found
                     ArrayList<Integer> list = new ArrayList<Integer>();
                     list.add(first);
                     list.add(num[start]);
                     list.add(num[end]);
                     result.add(list);
                     start++;
                 }
             }
         }
         return result;
    }
}

