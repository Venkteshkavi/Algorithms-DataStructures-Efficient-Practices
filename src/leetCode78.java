//Power Set Problem & Power set with duplicates Prob Done with DFS 
import java.util.*;
public class leetCode78 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,2};
		findPowerSet(nums);
		
		//Power Set Given Integers are Unique using dfs
		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		result = findPowerSetUsingDFS(nums);
//		System.out.println(result);
		
		//Power Set Given Integers have duplicate elements using dfs
		List<List<Integer>> result_1 = new ArrayList<List<Integer>>();
		result_1 = findPowerSet2UsingDFS(nums);
		System.out.println(result_1);
	}
	
	public static void findPowerSet(int[] nums) {
		long powersetSize = (long) Math.pow(2, nums.length);
		System.out.println("Power Set Size is " + " " + powersetSize);
		List<List<Integer>> subset = new ArrayList<List<Integer>>();
	
		//No. of combinations possible will form the outer loop
		//Runs from 0 to 7
		for(int i =0; i<powersetSize; i++) {
			//Runs from 0 to 2
			List<Integer> subsets = new ArrayList<Integer>();
			for(int j=0; j<nums.length; j++) {
				if((i & (1<<j)) > 0){
					subsets.add(nums[j]);

				}
			}
			subset.add(subsets);
		}
		System.out.println(subset);
	}
	
	
	public static List<List<Integer>> findPowerSetUsingDFS(int[] nums){
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		
		List<Integer> subset = new ArrayList<Integer>();
		
		findDFS(nums,results,subset,0);

		return results;
		
	}

	private static void findDFS(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIdx) {
		//Since we are passing oly a referrence we doing a deep copy onto the results (new ArrayList does that)
		results.add(new ArrayList<>(subset));
		
		for(int i=startIdx; i<nums.length; i++) {
			subset.add(nums[i]);
			findDFS(nums,results,subset,i+1);
			subset.remove(subset.size()-1);
		}
		
	}
	
	public static List<List<Integer>> findPowerSet2UsingDFS(int[] nums){
		List<List<Integer>> results_1 = new ArrayList<List<Integer>>();
		List<Integer> subsets = new ArrayList<Integer>();
		int startIdx = 0;
		findDFSWithDuplicates(nums,results_1,subsets,startIdx);
		return results_1;
	}

	private static void findDFSWithDuplicates(int[] nums, List<List<Integer>> results_1, List<Integer> subsets,
			int startIdx) {
		
		results_1.add(new ArrayList<>(subsets));
		
		for(int i=startIdx; i<nums.length; i++) {
			if(i!=startIdx && nums[i] == nums[i-1]) {
				continue;
			}
			
			subsets.add(nums[i]);
			findDFSWithDuplicates(nums,results_1,subsets,i+1);
			subsets.remove(subsets.size()-1);
		}
		
	}
}
