import java.util.*;
public class kthLargestElementInArrayHeap {
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,1,5,6,4};
		int k = 2;
		int result = 0;
		result = findKthLargest(nums,k);
		System.out.println(result);
	}
	
	public static int findKthLargest(int[] nums,int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int it : nums) {
			pq.add(it);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.poll();
	}
}
