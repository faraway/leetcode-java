package leetcode;
/**
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

	You have the following 3 operations permitted on a word:

	a) Insert a character
	b) Delete a character
	c) Replace a character
	
 * @note classic DP problem
 * @author patrick
 *
 */
public class EditDistance {
	
	public int minDistance(String word1, String word2) {
        if(word1==null||word1.length()==0){
            return word2.length();
        }
        if(word2==null||word2.length()==0){
            return word1.length();
        }
        int[][] array = new int[word2.length()+1][word1.length()+1];
        //init the array
        for(int i=0;i<word1.length()+1;i++){
            array[0][i]=i;
        }
        for(int i=0;i<word2.length()+1;i++){
            array[i][0]=i;
        }
        for(int i=1;i<word2.length()+1;i++){
            for(int j=1;j<word1.length()+1;j++){
                int same = 1;
                if(word1.charAt(j-1)==word2.charAt(i-1)){
                    same = 0;
                }
                /**
                 * KEY POINT
                 * min of the three situation
                 * 1.word1[1...j-1] turn word2[1...i], then + word1[j] (1)
                 * 2.word1[1....j ] turn word2[1...i-1], then + word2[i] (1)
                 * 3.word1[1...j-1] turn word2[1...i-1], then + word1[i]->word2[j] (0 if same, 1 if not)
                 */
                array[i][j]=min(array[i-1][j]+1,array[i][j-1]+1,array[i-1][j-1]+same);
            }
        }
        return array[word2.length()][word1.length()];
    }
    
    private int min(int x, int y, int z){
        if(x>=y){
            return y>=z?z:y;
        }else{
            return x>=z?z:x;
        }
    }

}
