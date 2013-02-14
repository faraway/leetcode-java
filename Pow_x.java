package leetcode;

public class Pow_x {
	//brute force solution
	public class Solution {
	    public double pow(double x, int n) {
	        if(n==0)
	            return 1;
	        double result = x;
	        for(int i=0;i<Math.abs(n)-1;i++){
	            result*=x;
	        }
	        return n<0? 1.0/result:result;
	    }
	}
}
