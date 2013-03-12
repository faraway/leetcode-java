/**
Permutation SequenceMar 28 '12

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
**/

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] array = new int[n+1];
        array[0]=1;
        for(int i=1;i<=n;i++){
            array[i]=i*array[i-1];
        }
        
        char[] result = new char[n];
        for(int i=0;i<n;i++)
            result[i]=(char)('0'+i+1);
            
        setPermutation(n,k-1,array,result,0);
        return new String(result);
    }
    
    private void setPermutation(int n, int k, int[] array, char[] result, int start){
        if(start==result.length-1||k==0)
            return;
        int base = array[n-start-1];
        int insertIndex = (k)/base+start;
        char temp = result[start];
        result[start]= result[insertIndex];
        result[insertIndex]=temp;
        ajustArray(result,start+1,insertIndex);
        setPermutation(n,k%base,array,result,start+1);
    }
    
    private void ajustArray(char[] result,int start, int insert){
        while(insert>start){
            if(result[insert]<result[insert-1]){
                char temp = result[insert];
                result[insert]=result[insert-1];
                result[insert-1]=temp;
                insert--;
            }else
            	break;
        }
    }
    
    public static void main(String[] args){
    	PermutationSequence test = new PermutationSequence();
    	test.getPermutation(3, 5);
    }
}
