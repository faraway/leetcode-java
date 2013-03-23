/**
Remove ElementFeb 16 '12

Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
**/

public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int start=0;
        int end = A.length-1;
        int len = A.length;
        while(start<=end){
            if(A[start]==elem){
                A[start]=A[end--];
                len--;
            }else
                start++;
        }
        return len;
        
    }
}
