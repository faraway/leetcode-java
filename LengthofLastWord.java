package leetcode;
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

	If the last word does not exist, return 0.

	Note: A word is defined as a character sequence consists of non-space characters only.

	For example,
	Given s = "Hello World",
	return 5. 
 * @author patrick
 *
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
        int length=0;
        boolean find =false;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '&& find){
                return length;
            }else{
                if(s.charAt(i)!=' '){
                    length++;
                    find=true;
                }
            }
            
        }
        if(find)
            return length;
        else
            return 0;
    }
	
	public int lengthOfLastWordAPI(String s){
		String[] list = s.split(" ");
        if(list!=null && list.length!=0){  //" ".split(" ") will return an array with length 0
            return list[list.length-1].length();
        }
        else
            return 0;
	}
	
	public static void main(String[] args){
		LengthofLastWord test = new LengthofLastWord();
		test.lengthOfLastWordAPI(" ");
	}
}
