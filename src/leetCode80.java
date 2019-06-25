import java.util.*;
public class leetCode80 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1,2,3,4,4,4};
		int result = 0;
		result = removeDuplicates(nums);
		for(int i=0;i<result; i++) {
			System.out.println(nums[i]);
		}
	}

	private static int removeDuplicates(int[] nums) {
		int i = 0;
		for(int n : nums) {
			if(i < 2 || n > nums[i-2]) {
				nums[i++] = n;
			}
		}
		
		return i;
	}
}
