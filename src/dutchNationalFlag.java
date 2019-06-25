import java.util.*;
public class dutchNationalFlag {
	public static void main(String[] args) {
		int[] nums = new int[] {2,0,2,1,1,0};
		seggragateTheFlag(nums);
		System.out.println(Arrays.toString(nums));
	}

	private static void seggragateTheFlag(int[] nums) {
		int low = 0, mid = 0, hi = nums.length-1;
		
		while(mid<=hi) {
			if(nums[mid] == 0) {
				swap(nums,low,mid);
				low++;
				mid++;
			}
			else if (nums[mid] == 1) {
				mid++;
			} 
			else if (nums[mid] == 2) {
				swap(nums, mid, hi);
				hi--;
			}
		}
		
	}

	private static void swap(int[] nums, int from, int to) {
		// TODO Auto-generated method stub
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
		
	}
}
