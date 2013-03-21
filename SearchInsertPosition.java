/**
Search Insert PositionMar 3 '12

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
**/

public class SearchInsertPosition {
    
    public int searchInsert(int[] A, int target) {
        return searchInsert(A,target,0,A.length-1); 
    }
    
    private int searchInsert(int[] A, int target, int start, int end) {
        int mid=(start+end)/2;
        if(A[mid]==target)
            return mid;
        if(target<A[mid]){
            if(mid==start||target>A[mid-1])
                return mid;
            return searchInsert(A, target, start, mid-1);
        }else{
            if(mid==end||target<A[mid+1])
                return mid+1;
            return searchInsert(A, target, mid+1,end);
        }
    }
}
