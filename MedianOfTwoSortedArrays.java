package leetcode;
/**
 * TODO NOT complete
 * SEE:
 * http://www.leetcode.com/2011/03/median-of-two-sorted-arrays.html
 * @author patrick
 *
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length==0||B.length==0)
            return -2;
        int length = A.length + B.length;
        if(length%2==1){//odd
            if (A.length>B.length)
                return findMedian(A,B,0,length/2,0);
            else
                return findMedian(B,A,0,length/2,0);
        }else{
            return -1;
        }
        
    }
    
    private int findMedian(int[] A,int[] B,int aStart,int aEnd, int bIndex){
        if(aStart==aEnd||aStart==aEnd-1)
            return A[aStart];
        int mid =(aStart+aEnd)/2;
        if(bIndex>=B.length){
            return findMedian(A,B,mid,aEnd,bIndex-(mid-aStart));
        }
        if(bIndex<0){
            return findMedian(A,B,aStart,mid,bIndex+(aEnd-mid));
        }
        if(A[aEnd]==B[bIndex]){
            return A[aEnd];
        }
        
        if(A[aEnd]>B[bIndex]){
            return findMedian(A,B,mid,aEnd,bIndex+(aEnd-mid));
        }else{
            return findMedian(A,B,aStart,mid,bIndex-(mid-aStart));
        }
    }
    
    public static void main(String[] args){
    	int A[] = new int[]{1,2};
    	int B[] = new int[]{1,2,3};
    	MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
    	System.out.println(test.findMedianSortedArrays(A, B));
    }
}
