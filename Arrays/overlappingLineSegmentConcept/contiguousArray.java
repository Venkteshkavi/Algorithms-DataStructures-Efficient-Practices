//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
//i/p: [0,1] o/p: 1
//i/p: [0,1,0] o/p:  2 -> [0,1],[1,0]

/*
    1. If overlapping subaaray problem, first step is to use the prefix sum
    2. Prefix sum goes to the hashmap, if you find the same prefix sum back again
       it means the indices between these  to same values gets balanced
*/

class Solution{
  public int findMaxLength(int[] nums){
    int prefixSum = 0;
    Map<Integer,Integer> map = new HashMap();
    int maxlen = 0;//Integer.MIN_VALUE can be used but when max len is found return 0
    for(int i = 0; i < nums.length; i++){
      prefixSum += nums[i] == 0 ? -1 : 1;
      if(map.containsKey(prefixSum)){
        maxlen = Math.max(maxlen,i-map.get(prefixSum));
      }
      else{
        map.put(prefixSum,i);
      }
    }

    return maxlen;
  }
}
