//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
/*
Input:nums = [1,1,1], k = 2
Output: 2
*/

class Solution{
    public int subarraySum(int[] nums,int k){
      if(nums.length == 0)
        return 0;
      Map<Integer,Integer> map = new HashMap();
      int count = 0;
      int prefixSum = 0;
      for(int i=0; i<nums.length; i++){
        prefixSum += nums[i];
        if(map.containsKey(prefixSum-k)){
          count += map.get(prefixSum-k);
        }
        else{
          map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
      }
      return count;
    }
}
