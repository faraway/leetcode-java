/**
Palindrome Partitioning IIMar 1

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
**/

public class PalindromePartitioningII {
    
    //note: this won't pass the last test case in large dataset.
    public int minCut(String s) {
        //array[i] means min cut of s.substring(0,i)
        int[] array = new int[s.length()+1];
        array[0]=-1;
        
        for(int i=1;i<s.length();i++){
            int temp = array[i];
            for(int start=i-1;start>-1;start--){
                if(array[start]<temp && validPalindrome(s,start,i))
                    temp = array[start];
            }
            array[i+1]=temp+1;
        }
        return array[s.length()];
    }
    
    //DP approach, still, can't pass the last test case. 
    //NOTE:This can be regarded as a viriation of Matrix Chain Production Problem
    public int minCutDP(String s){
        int n= s.length();
        int[][] matrix= new int[n][n];
        boolean[][] palindrome = new boolean[n][n];
        
        for(int i=0;i<n;i++)
            palindrome[i][i]=true;
    	
    	for(int len=2;len<=n;len++){//when len=1,it's zero cut.
    	    for(int i=0;i<n-len+1;i++){
    		int j=i+len-1;
		//calculate matrix[i,j],check if s[i..j] is palindrome
		if(len==2)
                    palindrome[i][j]=s.charAt(i)==s.charAt(j);
                else
                    palindrome[i][j]=s.charAt(i)==s.charAt(j)&&palindrome[i+1][j-1];
                    
                if(palindrome[i][j])
                    continue;
                //if not, calculate min cut
    		int min=Integer.MAX_VALUE;
    		for(int k=i;k<j;k++){
    		    int temp = matrix[i][k]+matrix[k+1][j]+1;
    		    if(temp<min)
    			min=temp;
    		}
    		matrix[i][j]=min;
    	    }
    	}
    	return matrix[0][n-1];
    }
    

    private boolean validPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
