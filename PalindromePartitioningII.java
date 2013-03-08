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
    
    

    private boolean validPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
