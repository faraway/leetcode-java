package leetcode;
/**
 * Determine whether an integer is a palindrome. Do this without extra space.
	Some hints:

	Could negative integers be palindromes? (ie, -1)

	If you are thinking of converting the integer to string, note the restriction of using extra space.

	You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
	you know that the reversed integer might overflow. How would you handle such case?

	There is a more generic way of solving this problem.

 * @author patrick
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else
            return checkPalindrome(x,new IntPointer(x));
        
    }
    
    private boolean checkPalindrome(int x, IntPointer xx){
        if(x/10<1){
            int tail = xx.val%10;
            xx.val/=10;
            return tail == x;
        }else{
            if(!checkPalindrome(x/10,xx))
                return false;
            else{
                int tail = xx.val%10;
                xx.val/=10;
                return tail == x%10;
            }
        }
        
    }
    
    public static void main(String[] args){
    	PalindromeNumber test = new PalindromeNumber();
    	System.out.println(test.isPalindrome(12321)); //true
    	System.out.println(test.isPalindrome(123321)); //true
    	System.out.println(test.isPalindrome(124321)); //false
    }
}

class IntPointer{
	int val;
	IntPointer(int i){
		val=i;
	}
}
