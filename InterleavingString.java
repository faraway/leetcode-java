package leetcode;
/**
 *  Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

	For example,
	Given:
	s1 = "aabcc",
	s2 = "dbbca",

	When s3 = "aadbbcbcac", return true.
	When s3 = "aadbbbaccc", return false. 
	
 * @author patrick
 * @note goodjob
 */
public class InterleavingString {
    private String s1;
    private String s2;
    private String s3;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        if(s1.length()+s2.length()!=s3.length())
            return false;
        else
            return check(0,0,0);
        
    }
    /**
     * @Recursive method
     * @note when there's a lot of duplicated chars in each string,
     *       this method will be very slow. Time limit exceeds.
     * @param x1
     * @param x2
     * @param x3
     * @return
     */
    private boolean check(int x1,int x2, int x3){
        if(x1>=s1.length()){
            return s2.substring(x2).equals(s3.substring(x3));
        }
        if(x2>=s2.length()){
            return s1.substring(x1).equals(s3.substring(x3));
        }
        if(s1.charAt(x1)!=s2.charAt(x2)){
            if(s1.charAt(x1)==s3.charAt(x3))
                return check(x1+1,x2,x3+1);
            else if(s2.charAt(x2)==s3.charAt(x3))
                return check(x1,x2+1,x3+1);
            else //not match
                return false;
        }else{
            //not match
            if(s3.charAt(x3)!=s1.charAt(x1))
                return false;
            else //use char of s1 or s2
                return check(x1+1,x2,x3+1)||check(x1,x2+1,x3+1);
        }
    }
    /**
     * @DP method
     * check[i][j] states if s3(1...i+j+1) is the interleaving of s1(1...i) and s2(1...j)
     * 
     * e.g
     * s1 = "abad"
     * s2 = "aabc"
     * s3 = "aabacbad"
     *  
     *   - a a b c
     * - 1 1 1 1 0
     * a 1 1 0 1 1
     * b 0 1 1 0 1
     * a 0 1 0 0 1
     * d 0 0 0 0 1
     * 
     * return true;
     * 
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveDP(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        else{
            //initialization
            int[][] check = new int[s1.length()+1][s2.length()+1];
            //make 0,0=1 to handle the case when s1=s2=s3=""
            check[0][0]=1;
            for(int i=1;i<s1.length()+1;i++){
                check[i][0]= s1.charAt(i-1)==s3.charAt(i-1)?1:0;
            }
            for(int i=1;i<s2.length()+1;i++){
                check[0][i]= s2.charAt(i-1)==s3.charAt(i-1)?1:0;
            }
            //iteratively computing each cell
            for(int i=1;i<s1.length()+1;i++){
                for(int j=1;j<s2.length()+1;j++){
                    char c = s3.charAt(i+j-1);
                    if(check[i-1][j]==1&&s1.charAt(i-1)==c||check[i][j-1]==1&&s2.charAt(j-1)==c)
                        check[i][j]=1;
                }
            }
            return check[s1.length()][s2.length()]==1?true:false;
        }
        
    }
}
