package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Given an array of strings, return all groups of strings that are anagrams.

   Note: All inputs will be in lower-case.
   e.g. Input:
   		["tea","and","ate","eat","dan","dans","pig"]
   		Expected output:
   		["tea","ate","eat","and","dan"]
 * @author patrick
 *
 */

public class Anagrams {
    /**
     * use a hashmap to record all the previous strings (after sort)
     * key: sorted string
     * value: index of the string if it first comes into the hash map
     *        -1 if already found at least one which they are anagrams.
     * @param strs
     * @return
     */
    public ArrayList<String> anagrams(String[] strs) {
        
        ArrayList<String> result = new ArrayList<String>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i=0;i<strs.length;i++){
            char[] content = strs[i].toCharArray();
            java.util.Arrays.sort(content);
            String sorted = new String(content);
            Integer flag = map.get(sorted);
            if(flag==null){
                map.put(sorted,i);
            }else{
                if(flag!=-1){
                    result.add(strs[flag]);
                    map.put(sorted,-1);
                }
                result.add(strs[i]);        
            }
        }
        
        return result;
        
    }
}