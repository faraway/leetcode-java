
/**
Palindrome PartitioningFeb 28

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
**/

public class PalindromePartitioning {
    ArrayList<ArrayList<String>> result;
    
    public ArrayList<ArrayList<String>> partition(String s) {
        result = new ArrayList<ArrayList<String>>();
        generatePalindromes(s,0,new ArrayList<String>());
        return result;
    }
    
    public void generatePalindromes(String s,int start,ArrayList<String> pre){
        int end=start;
        while(end<s.length()){
            if(validPalindrome(s,start,end)){
                ArrayList<String> temp=(ArrayList<String>)pre.clone();
                temp.add(s.substring(start,end+1));
                if(end==s.length()-1)
                    result.add(temp);
                else
                    generatePalindromes(s,end+1,temp);
            }
            end++;
        }
    }

    private boolean validPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
