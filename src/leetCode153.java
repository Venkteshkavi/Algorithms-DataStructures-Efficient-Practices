import java.util.*;
public class leetCode153 {
	public static void main(String[] args) {
		int[] nums = new int[] {4,5,6,7,2,3};
		int start = 0;
		int end = nums.length-1;
		int result = 0;
		result = findPivotElement(nums,start,end);
		System.out.println(result);
	}
	
	public static int findPivotElement(int[] nums,int start, int end) {
		
		while(start <= end) {
			if(start == end) {
				return nums[start];
			}
			int mid = (start + (end-start))/ 2;
			if(nums[mid] > nums[mid+1]) {
				return nums[mid+1];
			}
			System.out.println(nums[mid] + " " + nums[start] + " " + nums[end]);
			if((nums[mid] > nums[start]) && (nums[mid] > nums[end])) {
				start = mid+1;
			}
			
			else {
				end = mid;
			}
			
		}
		return  nums[start];
	}
}
