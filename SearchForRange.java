/**
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
**/

public class SearchForRange {
    
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        int start = findStart(A, target, 0, A.length-1);
        int end = -1;
        if(start!=-1)
            end = findEnd(A, target, start, A.length-1);
        result[0]=start;
        result[1]=end;
        return result;   
    }
    
    private int findStart(int[] A, int target, int start, int end){
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        
        if(A[mid]==target){
            if(mid-1>=0 && A[mid-1]==A[mid])
                return findStart(A, target, start, mid-1);
            else
                return mid;
        }
        if(target<A[mid])
            return findStart(A, target, start, mid-1);
        else
            return findStart(A, target, mid+1, end);
    }
    
    private int findEnd(int[] A, int target, int start, int end){
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        
        if(A[mid]==target){
            if(mid+1<A.length && A[mid+1]==A[mid])
                return findEnd(A, target, mid+1, end);
            else
                return mid;
        }
        if(target<A[mid])
            return findEnd(A, target, start, mid-1);
        else
            return findEnd(A, target, mid+1, end);
    }
}
