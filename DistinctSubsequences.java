package leetcode;
/**
 *  Given a string S and a string T, count the number of distinct subsequences of T in S.

	A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
	(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

	Here is an example:
	S = "rabbbit", T = "rabbit"
	Return 3. 
	
 * @author patrick
 *
 */
public class DistinctSubsequences {
	 public int numDistinct(String S, String T) {
	        
	        return Subsequences(0,0,S,T);
	        
	 }
	 /**
	  * @recursive method, time limits exceeded....:(   
	  * @param s, the start index of S
	  * @param t, the start index of T
	  * @param S
	  * @param T
	  * @return
	  */
	 private int Subsequences (int s,int t, String S, String T){
	        if(s>=S.length()||t>=T.length()||(S.length()-s)<(T.length()-t))
	            return 0;
	        int total = 0;
	        if(S.charAt(s)==T.charAt(t)){//current match, take it
	            if(t==T.length()-1)
	                total+=1;//if is last char of T, get match.
	            else
	                total+= Subsequences(s+1,t+1,S,T);//otherwise, keep digging    
	        }
	        total+=Subsequences(s+1,t,S,T);//no matter current match or not, don't take current.go next.
	        return total;
	 }
	 /**
	  * DP way.
	  * Example:(construct from column 0 -> n, for each column, construct from top to bottom)
	  *      C A T
	  *    1 0 0 0
	  * C  1 1 0 0
	  * B  1 1 0 0
	  * A  1 1 1 0
	  * Z  1 1 1 0
	  * T  1 1 1 1
	  * A  1 1 2 1
	  * A  1 1 3 1
	  * A  1 1 4 1
	  * B  1 1 4 1
	  * B  1 1 4 1
	  * C  1 2 4 1
	  * T  1 2 4 5
	  * A  1 2 6 5
	  * 
	  * array[i][j] means total distinct subsequences for T(0....i-1) in S(0....j-1)
	  * @param S
	  * @param T
	  * @return
	  */
	 public int numDistinctDP(String S, String T) {
	        
	        int[][] array = new int[S.length()+1][T.length()+1];
	        if(S==null||T==null||S.length()==0||T.length()==0){
	            return 0;
	        }
	        //set first column all 1
	        for(int i=0;i<S.length()+1;i++){
	            array[i][0]=1;
	        }
	        for(int i = 1;i<T.length()+1;i++){
	            for(int j=1;j<S.length()+1;j++){
	            	//make current as pre, no matter the current new char in S queals T[i] or not.
	                array[j][i] = array[j-1][i];
	                /**if current T[i] equal that in S[j]
	                 *Then we have two possible selections:
	                 *1.Don't use this match, use previous. that is array[j][i] = array[j-1][i] above
	                 *2.Use this match, then possible ways = array[j-1][i-1], as in the if statement
	                 *so the total will be 1+2;
	                 */
	                if(T.charAt(i-1)==S.charAt(j-1)){
	                    array[j][i] += array[j-1][i-1];
	                }
	            }
	        }
	        return array[S.length()][T.length()];
	    }
}
