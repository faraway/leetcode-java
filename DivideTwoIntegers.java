package leetcode;
/**
 * Divide two integers without using multiplication, division and mod operator. 
 * @author patrick
 * Ox1000 is -2147483648 (not 0 !)
 */
public class DivideTwoIntegers {
	/**
	 * The general idea is like this, but this function can't handle the situation 
	 * when dividend is -2147483648, which can't be presented in positive number.
	 * see updated method @divideUseNegative
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor) {
        if(divisor==1){
            return dividend;
        }
        
        int sign = 1;
        if(dividend<0){
            dividend=-dividend;
            sign = -sign;
        }
        if(divisor <0){
            divisor = -divisor;
            sign = -sign;
        }
        
        if(dividend<divisor){
            return 0;
        }
        int result =0;
        int temp_pre;
        int temp_divisor = divisor;
        int temp_count = 1;
        while(temp_divisor<=dividend){
            inner:while(true){  
            	//when temp_divisor moves 1 bit to left, it may become negative 
            	//in this case, we cant't move it 1 bit right to recovery.
            	//because sign bit won't change. So use a pre to keep the original value.
            	temp_pre = temp_divisor;
                temp_divisor<<=1;
                if(temp_divisor<=dividend && temp_divisor>0){
                	temp_count<<=1;
                	//System.out.println("divisor:"+temp_divisor+",count:"+temp_count);
                }else{
                	temp_divisor=temp_pre;
                	break inner;
                }
            }
            result|=temp_count;
            //reset
            temp_count=1;
            dividend-=temp_divisor;
            temp_divisor = divisor;
        }
        if(sign<0){
            result=-result;
        }
        return result;
        
    }
	/**
	 * To handle the case which dividend is -2147483648 , which can not be present as an positive integer
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divideUseNegative(int dividend, int divisor) {
        if(divisor==1){
            return dividend;
        }
        
        int sign = 1;
        if(dividend>0){
            dividend=-dividend;
            sign = -sign;
        }
        if(divisor == Integer.MIN_VALUE){
        	if(dividend == Integer.MIN_VALUE){
        		return 1;
        	}else{
        		return 0;
        	}
        }
        if(divisor < 0){
            divisor = -divisor;
        }else{
        	sign = -sign;
        }
        
        if(dividend+divisor>0){
            return 0;
        }
        int result =0;
        int temp_pre;
        int temp_divisor = divisor;
        int temp_count = 1;
        while(temp_divisor+dividend<=0){
            inner:while(true){  
            	//when temp_divisor moves 1 bit to left, it may become negative 
            	//in this case, we cant't move it 1 bit right to recovery.
            	//because sign bit won't change. So use a pre to keep the original value.
            	temp_pre = temp_divisor;
                temp_divisor<<=1;
                if(temp_divisor+dividend<=0 && temp_divisor>0){ // divisor can't overflow, make it positive
                	temp_count<<=1;
                }else{
                	temp_divisor=temp_pre;
                	break inner;
                }
            }
            //can also use result|=temp_count
            //but in case of -2147483648/2 , which divisor can't be 2147483648,there's will be duplicated 1 at same bit.
            //so safer to use +
            result+=temp_count;
            //reset
            temp_count=1;
            dividend+=temp_divisor;
            temp_divisor = divisor;
        }
        if(sign<0){
            result=-result;
        }
        return result;
        
    }
	
	
	//test function
	public static void main(String[] args){
		//1073741824
		//2147483632
		int i = -2147483648;
		i>>=1;
		System.out.println(divideUseNegative(2147483647,2)+","+2147483647/2);
		
	}
}
