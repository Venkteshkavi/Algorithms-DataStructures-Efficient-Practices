//Find the target Sum Path - Path need not be from root to leaf
// Approach - Perform dfs from each of the nodes record the paths as you go

//Important Test Case Encountered : [1,null,2,null,3,null,4,null,5] Sum : 3
// Output : 2

//TC: O(n2)
class Solution{
  public int pathSum(TreeNode root,int sum){
    if(root == null) return 0;

    //DFS FROM EACH NODE
    return findPath(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
  }

  private int findPath(TreeNode root,int sum){
    //Initialize result at every node recursion
    //each node tells the parent how many sum paths it has found

    int res = 0;
    if(root == null) return res;

    if(sum == root.val) res++;

    res += findPath(root.left,sum-root.val);
    res += findPath(root.right,sum-root.val);

    return res;
  }
}

//Efficent solution TC: O(n)
//SC:O(n)
class Solution{
    public int pathSum(TreeNode root,int target){
        if(root == null) {
            return 0;
        }

        Map<Integer,Integer> prefixSum = new HashMap();
        prefixSum.put(0,1);   //In case we find the exact target and preSum-target = 0
        int currSum = 0;
        return helper(root,currSum,prefixSum,target);
    }


    private int helper(TreeNode root,int currSum,Map<Integer,Integer> prefixSum,int target){
        if(root == null) return 0;

        currSum += root.val;
        int res = prefixSum.getOrDefault(currSum-target,0);
        prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);

        res += helper(root.left,currSum,prefixSum,target);
        res += helper(root.right,currSum,prefixSum,target);

        //Invalidate the prefixsum in  this path
        /*
            Eg : Test Case : [1,-2,-3]
            Here in path [1,-2] we encounter one result -1 is added to prefixMap
            {0:1,1:1,-1:1}
            If we dont invalidate -1, during the path 1->-3 currSum = -2
            currSum - target = -1, is in Map so res becomes 2
            But  answer is 1
        */
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);

        return res;
    }
}

//Inorder to return all the paths
class Solution{
  public List<List<Integer>> pathSum(TreeNode root,int sum){
    if(root == null) return 0;
    List<List<Integer>> res = new ArrayList();
    //DFS FROM EACH NODE
    return findPath(root,new ArrayList(),res,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
  }

  private List<Integer> findPath(TreeNode root,List<Integer> temp,List<List<Integer>> res,int sum){
    //Initialize result at every node recursion
    //each node tells the parent how many sum paths it has found
    if(root == null) return temp;

    temp.add(root.val);
    if(sum == root.val){
      res.add(new ArrayList(temp));
    }
    findPath(root.left,sum-root.val);
    findPath(root.right,sum-root.val);

    temp.remove(temp.size()-1);

    return res;
  }
}


//With paths
class Solution{
    List<List<Integer>> result = new ArrayList();
    public int pathSum(TreeNode root,int target){
        if(root == null) {
            return 0;
        }

        List<Integer> temp = new ArrayList();
        Map<Integer,Integer> prefixSum = new HashMap();
        prefixSum.put(0,1);   //In case we find the exact target and preSum-target = 0
        int currSum = 0;
        int res = helper(root,currSum,temp,prefixSum,target);
        System.out.println(result);

        return res;
    }


    private int helper(TreeNode root,int currSum,List<Integer> temp,Map<Integer,Integer> prefixSum,int target){
        if(root == null) return 0;

        currSum += root.val;
        temp.add(root.val);
        int res = prefixSum.getOrDefault(currSum-target,0);
        if(res > 0){
            int sum = 0;
            for(int i=0; i<temp.size(); i++){
                sum += temp.get(i);
            }

            if(sum > target) temp.remove(0);

            result.add(new ArrayList(temp));
            temp.add(0,sum-target);
        }
        prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);

        res += helper(root.left,currSum,temp,prefixSum,target);
        res += helper(root.right,currSum,temp,prefixSum,target);

        //Invalidate the prefixsum in  this path
        /*
            Eg : Test Case : [1,-2,-3]
            Here in path [1,-2] we encounter one result -1 is added to prefixMap
            {0:1,1:1,-1:1}
            If we dont invalidate -1, during the path 1->-3 currSum = -2
            currSum - target = -1, is in Map so res becomes 2
            But  answer is 1
        */
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        temp.remove(temp.size()-1);

        return res;
    }
}
