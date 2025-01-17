import java.util.*;
public class mergeIntervals {
	public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};
		int target = 9;
		int[] foundIndex;
		foundIndex = findSum(nums,target);
		System.out.println(Arrays.toString(foundIndex));
	}
	
	public static int[] findSum(int[] num,int target) {
	    int[] indice = new int[2];
	    if (num == null || num.length < 2) return indice;
	    int left = 0, right = num.length - 1;
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}
}
