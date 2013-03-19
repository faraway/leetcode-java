/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
**/


public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        return search(A, target, 0, A.length-1);
    }
    
    private int search(int[] A, int target, int start, int end){
        if(start>end || (start==end && A[start]!=target))
            return -1;
        int mid=(start+end)/2;
        
        if(A[mid]==target)
            return mid;
        
        if(A[start]<A[mid]){
            if(target>=A[start] && target< A[mid])
                return search(A, target, start, mid-1);
            else
                return search(A, target, mid+1,end);
        }else{ //mid+1....end is in order. can't go mid..end, because mid | mid+1 might be the boundry
            if(target>=A[mid+1] && target<= A[end])
                return search(A, target, mid+1, end);
            else
                return search(A, target, start,mid-1);
        }
    }
}
