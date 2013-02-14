package leetcode;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * 
 * @note simplest DP
 * @author patrick
 *
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
        int[] stairs = new int[n];
        if(n==1)
            return 1;
        stairs[0]=1;
        if(n==2)
            return 2;
        stairs[1]=2;
        
        for(int i=2;i<n;i++){
            stairs[i]=stairs[i-1]+stairs[i-2];
        }
        
        return stairs[n-1];
    }
}
