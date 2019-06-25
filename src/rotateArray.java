import java.util.*;
public class rotateArray {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7};
		int rotate = 3;
		rotateArr(nums,rotate);
		System.out.println(Arrays.toString(nums));
	}
	
	// Brute Force Approach by Rotating array thrice each time by shifting all the elements of the array.
//	public static void rotateArr(int[] nums,int rotate) {
//        int temp, previous;
//        for (int i = 0; i < rotate; i++) {
//            previous = nums[nums.length - 1];
//            for (int j = 0; j < nums.length; j++) {
//                temp = nums[j];
//                nums[j] = previous;
//                previous = temp;
//            }
//        }
//	}
	
	//Using Extra Space approach
	public static void rotateArr(int[] nums,int rotate) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + rotate) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
	}
	
	//Using connected Components approach
//	public static void rotateArr(int[] nums,int k) {
//	    k = k % nums.length;
//	    int count = 0;
//	    for (int start = 0; count < nums.length; start++) {
//	        int current = start;
//	        int prev = nums[start];
//	        do {
//	            int next = (current + k) % nums.length;
//	            int temp = nums[next];
//	            nums[next] = prev;
//	            prev = temp;
//	            current = next;
//	            count++;
//	        } while (start != current);
//	    }
//	}
	
	//Using reversing the array approach
}
