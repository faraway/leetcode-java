package leetcode;
/**
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 * @author patrick
 *
 */
public class SortColors {
    int[] A;
    public void sortColors(int[] A) {
		this.A=A;
        int red=0; //0s
        int white=0; //1s
        int blue=A.length-1;//2s
        
        while(blue>=0&&A[blue]==2  ){
        	blue--;
        }
        while(white<=blue){
        	if(A[white]==0){//red
        		swap(red,white);
        		red++;
        		white++;
        	}else if(A[white]==1){//white
        		white++;
        	}else{//blue
        		swap(white,blue);
        		if(A[white]==0){
        			swap(red,white);
        			red++;
        		}
        		white++;
        		while(blue>=white && A[blue]==2 ){
        			blue--;
        		}
        	}
        }
    }
	
    private void swap(int i,int j){
		int temp = A[i];
		A[i]=A[j];
		A[j]=temp;
    }
}
