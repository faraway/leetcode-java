package leetcode;
/**
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * @author patrick
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int index = -1;
        outer:for(int i=0;;i++){
            char c;
            if(i<strs[0].length()){
                c=strs[0].charAt(i);
            }else{
                break;
            }
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length()||strs[j].charAt(i)!=c){
                    break outer;
                }
            }
            index=i;
        }
        return strs[0].substring(0,index+1);
        
    }
}
