//Power Set problem with duplicates
import java.util.*;
public class leetCode90 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,2};
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = subsetWithDup(nums);
		System.out.println(result);
	}

	private static List<List<Integer>> subsetWithDup(int[] nums) {
		Arrays.sort(nums);
	    List<List<Integer>> output= new ArrayList<>();
	    dfs(nums,0,new ArrayList<Integer>(),output);
		return output;
	}

	private static void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> output) {
        output.add(path);
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            List<Integer> nPath= new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums,i+1,nPath,output);
        }
	}
}
