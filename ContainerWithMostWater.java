package leetcode;

public class ContainerWithMostWater {
	/**
	 * basically, still O(n^2) algorithm, but much better than the pure O(n^2) algorithm
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
        int start = height[0];
        int end   = height[1];
        int threshold = start>end?end:start;
        int max = threshold * 1;
        for (int i = 2; i<height.length;i++){
            if(height[i]==0){
                continue;
            }
            int back = max/height[i];
            for(int j=0;j<i-back;j++){
                threshold = height[j]>height[i]?height[i]:height[j];
                if( (i-j)*threshold  > max ){
                    max =(i-j)*threshold ;
                }
            }
        }
        return max;
        
    }
	
	/**
	 * optimal
	 * key point:
	 * from outside to center ( x-axis distance max first)
	 * @param height
	 * @return
	 */
    public int maxAreaOptimal(int[] height) {
        int max=0;
        int a=0;
        int b=height.length-1;
        while(a!=b){
            int temp = height[a]>height[b]?height[b]:height[a];
            int x=(b-a)*temp;
            if(x>max)max=x;
            if(height[a]>height[b])--b;
            else ++a;
        }
        return max;
        
    }
}
