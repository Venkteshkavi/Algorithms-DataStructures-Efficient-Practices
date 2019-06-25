import java.util.*;
public class minJump2 {
	public static void main(String[] args) {
		int[] arr = new int[] {2,0,1,4,5};
		int minJumps = 0;
		minJumps = findMinJumps(arr);
//		System.out.println(minJumps);
	}
	
	public static int findMinJumps(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for(int i=0; i<nums.length-1; i++) {
//			curFarthest = Math.max(curFarthest,i+nums[i]); 
//			if(i == curEnd) {
//				jumps++;
//				curEnd = curFarthest;
//			}
			System.out.print(i);
		}
		return 1;
	}
}