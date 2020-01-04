//Find the target Sum Path - Path need not be from root to leaf
// Approach - Perform dfs from each of the nodes record the paths as you go

//Important Test Case Encountered : [1,null,2,null,3,null,4,null,5] Sum : 3
// Output : 2

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
