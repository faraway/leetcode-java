package leetcode;
/**
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26

	Given an encoded message containing digits, determine the total number of ways to decode it.

	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

	The number of ways decoding "12" is 2. 
 * @author patrick
 *
 */
public class DecodeWays {
	
	public int numDecodings(String s) {
        if(s!=null && s.length() !=0){
            return getDecode(s,0);   
        }else{
            return 0;
        }
        
    }
    //brute force recursive. a lot of duplicated computation
    public int getDecode(String s,int start){
        if(start==s.length()){
            return 1;
        }
        if(start==s.length()-1 && s.charAt(start)!='0'){//digi
            return 1;
        }
        if(s.charAt(start)=='0'){
            return 0;
        }
        if(s.charAt(start)=='1'&&s.charAt(start+1)=='0' || s.charAt(start) =='2' && s.charAt(start+1) == '0'){
            return getDecode(s,start+2);
        }
        if(s.charAt(start)=='1' || s.charAt(start) =='2' && s.charAt(start+1) < '7'){
            return getDecode(s,start+1) + getDecode(s,start+2);
        }
        return getDecode(s,start+1);
    }
    
    /**
     * Optimal Algorithm
     * Dynamic Programming O(n) 
     * @param s
     * @return
     */
    public int numDecodingsOptimal(String s) {
        if(s==null || s.length() ==0){
            return 0;
        }
        if(s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;
        
        //length >=2, Initialization
        String head;
        int[] array = new int[s.length()];
        array[0] = 1;
        if(s.length()==2){
            head = s;
        }else{
            head = s.substring(0,2);
        }
        int temp = Integer.parseInt(head);
        if(temp>26 && temp%10==0){
            return 0;
        }else if(temp>26||temp==20||temp==10)
            array[1]=1;
        else 
            array[1]=2;
        //length>2
        char pre;
        char curr;
        for(int i = 2; i<s.length();i++){
            pre = s.charAt(i-1);
            curr = s.charAt(i);
            if(pre=='0'){
                if(curr=='0') 
                    return 0;
                else
                    array[i]=array[i-2];
                    continue;
            }else{
                if(curr=='0'){ //current 0
                    if(pre<'3'){
                        array[i]=array[i-2];
                        continue;
                    }else{
                        return 0;
                    }
                }else{ //most common case, pre !=0, current!=0
                    if(pre=='1'||pre=='2'&&curr<'7'){
                        array[i]=array[i-1]+array[i-2];
                    }else{
                        array[i]=array[i-1];
                    }
                }
            }
        }
        return array[s.length()-1];
        
    }
}
