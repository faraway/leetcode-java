package leetcode;


public class ZigZagConversion {
	/**
	 * @wrong method
	 * misunderstand it...
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
        int size = s.length()*2+1;
        char[] array = new char[size];
        int index = 0;
        int strIndex = 0;
        int columns = -1;
        
        outer: while(strIndex<s.length()){
            columns++;
            if(columns%2==0){
                for(int i=0;i<nRows;i++){
                    if(strIndex<s.length()){
                        array[index]=s.charAt(strIndex);
                        index++;
                        strIndex++;
                    }else{
                        break outer;
                    }
                }
            }else{
                for(int i=0;i<nRows;i++){
                    if(i%2==0){
                        array[index]=' ';
                        index++;
                        continue;
                    }
                    if(strIndex<s.length()){
                        array[index]=s.charAt(strIndex);
                        index++;
                        strIndex++;
                    }else{
                        break outer;
                    }
                }
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<nRows;i++){
            for(int j=0;j<=columns;j++){
                int k = nRows*j+i;
                if(k<index && array[k]!=' '){
                    sb.append(array[k]);
                }
            }
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args){
		ZigZagConversion zz = new ZigZagConversion();
		zz.convert("PAYPALISHIRING", 2);
	}
}
