
public class SearchInRotatedSortedArrayII {

    public int search(int[] A, int target) {
        return search(A, target, 0, A.length-1);
    }
    
    private int search(int[] A, int target, int start, int end){
        if(start>end || (start==end && A[start]!=target))
            return -1;
        int mid=(start+end)/2;
        
        if(A[mid]==target)
            return mid;
        
        if(A[start]<A[mid]){ // start..mid part is in order
            if(target>=A[start] && target< A[mid])
                return search(A, target, start, mid-1);
            else
                return search(A, target, mid+1,end);
        }else if(A[start]>A[mid]){ //mid+1....end is in order. can't go mid..end, because mid | mid+1 might be the boundry
            if(target>=A[mid+1] && target<= A[end])
                return search(A, target, mid+1, end);
            else
                return search(A, target, start,mid-1);
        }else{ // A[start]=A[mid], target can be in both halves. e.g.target=4, 34512333333, 3333345123
            /**
             * one possible improvement is that check if A[mid] == A[end]
             * if A[mid]!=A[end], than start..mid must be all duplicates, just search mid->end half is enough.
             **/
            int temp = search(A, target, start,mid-1);
            if(temp!=-1)
                return temp;
            else
                return search(A, target, mid+1,end);
        }
    }
}
