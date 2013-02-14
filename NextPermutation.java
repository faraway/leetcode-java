package leetcode;

/**
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

	The replacement must be in-place, do not allocate extra memory.

	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
	
	//TODO to be tested ; OJ runtime error;
 * @author patrick
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if(num.length<2)
			return;
		
		int lastIndex = -1;
		for(int i=num.length-2;i>=0;i--){
			if(num[i]<num[i+1]){
				lastIndex=i;
				break;
			}
		}
		if(lastIndex==-1)
			java.util.Arrays.sort(num);
		else{
			int temp = num[lastIndex];
			int next = num.length-1;
			while(num[lastIndex]>=num[next])
				next--;
			num[lastIndex] = num[next];
			num[next]=temp;
			java.util.Arrays.sort(num,lastIndex+1,num.length);
		}
    }
	
	public static void main(String[] args){
		NextPermutation test = new NextPermutation();
		int[] data = new int[]{2,2,7,5,4,3,2,2,1};
		test.nextPermutation(data);
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]+"");
		}
	}
}
