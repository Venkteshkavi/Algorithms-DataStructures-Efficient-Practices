/*
  Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
  If there isn't one, return 0 instead.
  Input: nums = [1, -1, 5, -2, 3], k = 3
  Output: 4
  Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
*/

class Solution{
  public int maxSubArrayLen(int[] nums, int k) {
    if(nums.length == 0) return 0;
    Map<Integer,Integer> map = new HashMap();
    int maxlen = 0;
    int prefixSum = 0;
    for(int i=0; i<nums.length; i++){
      prefixSum += nums[i];
      if(map.containsKey(prefixSum-k)){
        maxlen = Math.max(maxlen,i-map.get(prefixSum-k));
      }
      if(!map.containsKey(prefixSum)){
        map.put(prefixSum,i);
      }
    }

    return maxlen;
  }
}
