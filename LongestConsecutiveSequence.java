/**
Longest Consecutive
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
**/

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int max=1 ;
        HashMap<Integer ,Integer > map = new HashMap<Integer ,Integer >();
        for(int i=0;i<num. length;i++){
            if(map.containsKey(num[i]))
                continue;
            map.put(num[i], 1);
            if(map.containsKey(num[i]-1 ))
                max= Math.max(max,merge(map,num[i]- 1,num[i]));
            if(map.containsKey(num[i]+1 ))
                max= Math.max(max,merge(map,num[i],num[i]+ 1));
              
        }
        return max;
    }
  
    private int merge(HashMap <Integer,Integer> map, int left, int right){
        int len = 1 ;
        int upper = left+map.get(right);
        int lower = right-map.get(left);
        len = upper-lower+ 1;
        map.put(upper,len);
        map.put(lower,len);
        return len;
    }
}
