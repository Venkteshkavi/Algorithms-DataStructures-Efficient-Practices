import java.util.*;

public class threeSum {
	public static List<List<Integer>> ThreeSum (int[] nums){
		List<List<Integer>> res  = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		for(int i =0; i<nums.length; i++) {
			int left = i+1;
			int right = nums.length - 1;
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if(sum == 0) {
					List<Integer> l = new ArrayList<>();
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]);
					res.add(l);
					
					int leftValue = nums[left];
					while(left<nums.length && nums[left] == leftValue) {
						++ left;
					}
					
					int rightValue = nums[right];
					while(right > left && nums[right] == rightValue) {
					 -- right;
				}
			} else if(sum < 0) {
				++left;
			}
			else {
				-- right;
			}
		}
			while(i+1 < nums.length && nums[i] == nums[i+1]) {
				++i;
			}
	
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> output = new ArrayList<>();
		output = ThreeSum(nums);
		System.out.println(output);
	}
}
