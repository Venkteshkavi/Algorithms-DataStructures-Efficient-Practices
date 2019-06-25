import java.util.*;
public class leetCode1051 {
	public static void main(String[] args) {
		int[] heights = new int[] {1,1,4,2,1,3};
		int result = 0 ,result_1 = 0;
//		result = heightCheckerUsingSort(heights);
		result_1 = heightCheckerWithoutSort(heights);
		System.out.println(result);
		System.out.println(result_1);
	}

	private static int heightCheckerUsingSort(int[] heights) {
		int[] ans = new int[heights.length];
		int count = 0;
		ans = heights.clone();
		Arrays.sort(ans);
		for(int i=0; i<ans.length; i++) {
			if(ans[i] != heights[i]) {
				++count;
			}
		}
		return count;
	}
	
	private static int heightCheckerWithoutSort(int[] heights) {
        int[] heightToFreq = new int[101];
        
        for (int height : heights) {
            heightToFreq[height]++;
        }
        
        int result = 0;
        int curHeight = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }
            
            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }
        
        return result;
	}
	
}
