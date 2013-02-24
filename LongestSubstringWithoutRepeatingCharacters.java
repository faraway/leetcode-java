package leetcode;
/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @note: although there're 3 levels of loops, the actual runtime is at most O(2n)=>O(n)
 * @author patrick
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
	       char[] list = s.toCharArray();
	       /**
	        * flag array, the value is used to record the index of appearance of the corresponding letter
	        * of current substring.
	        */
	       int[] array = new int[26];
	       for(int i=0;i<26;i++){
	           array[i]=-1; //if no corresponding letter, it's -1.
	       }
	       
	       int max=0;//max length
	       int start=0;//next start index to check substring
	       int actualStart=0;//the actual start of the current substring.
	       int current=0;//current substring length
	       
	       loop:while(start<list.length){
	           for(int i=start;i<list.length;i++){
	               if(array[(int)list[i]-'a']!=-1){
	            	   int repeatIndex=array[(int)list[i]-'a'];
	            	   /**
	            	    * reset the flags of letters from actual start of current substring
	            	    * to the first index of repeat letter we just found.
	            	    */
	                   for(int x =actualStart;x<=repeatIndex;x++){
	                       array[(int)list[x]-'a']=-1;
	                   }
	                   //next start = i+1
	                   start=i+1;
	                   actualStart=repeatIndex+1;
	                   if(current>max)
	                        max=current;
	                   //next no. of existing letters equal to current-first index of repeated letter 
	                   current=i-repeatIndex;
	                   array[(int)list[i]-'a']=i;
	                   continue loop;
	               }else{
	                  array[(int)list[i]-'a']=i;
	                  current++;
	               }
	           }
	           /**
	            * if we goes here, means we have checked the whole array of chars
	            * without "continue" the loop
	            * so it's done, check current,break while
	            */
	           if(current>max){
	        	   max=current;
	           }
	           break;
	       }
	       
	       return max;
	}
	
	/**simplified version. similar idea with <Minimum Window Substring> | Feb.23rd,2013**/
	public int lengthOfLongestSubstring_revised(String s) {
        	if(s.length()==0)
            		return 0;
            		
        	int[] check = new int[26];
        	Queue<Integer> q = new LinkedList<Integer>();
        
        	int max=0;
        	int current=0;
        
        	for(int i=0;i<s.length();i++){
            		q.offer(i);
            		int x = s.charAt(i)-'a';
            		if(check[x]==0){
                	    check[x]=1;  
                	    current++;
            		}else{
                 	    if(current>max)
                    		max=current;
                	    int idx = q.poll();
                	    while(s.charAt(idx)!=s.charAt(i)){
                    	    	check[s.charAt(idx)-'a']=0;
                    		current--;
                    		idx=q.poll();
               		    }
            	        }
        	}
        	if(current>max)
             	    max=current;
        	return max;
        }
}
