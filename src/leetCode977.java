import java.util.*;
public class leetCode977 {
	public static void main(String[] args) {
		int[] nums = new int[] {-4,-1,0,1,2,4};
		int[] result = new int[nums.length];
		result = findSquares(nums);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findSquares(int[] nums) {
		
		int j=0, t=0;
		int[] ans = new int[nums.length];
		//Find the first positive index
		while(j < nums.length && nums[j] < 0) {
			j++;
		}
		
		int i = j-1; //Last Negative Index
		
		//j represents the first starting index of the postitive numbers
		
		while(i >=0 && j<nums.length) {
			if(nums[i] * nums[i] < nums[j]*nums[j]) {
				ans[t++] = nums[i] * nums[i];
				i--;
			}
			else {
				ans[t++] = nums[j] * nums[j];
				j++;
			}
		}
		
		//Copy Remaining items present if any from negative side
		while(i>=0) {
			ans[t++] = nums[i] * nums[i];
			i--;
		}
		
		while(j<nums.length) {
			ans[t++] = nums[j] * nums[j];
			j++;
		}

		return ans;
	}
}
