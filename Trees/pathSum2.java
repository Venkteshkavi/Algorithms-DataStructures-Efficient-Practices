//Find the target sum starting from root to leaf - return the paths as well
class Solution{
    public List<List<Integer>> pathSum(TreeNode root,int sum){
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        helper(res,path,root,sum);

        return res;
    }

    private void helper(List<List<Integer>> res,List<Integer> path,TreeNode root,int sum){
        if(root == null){
            return;
        }

        sum -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            res.add(new ArrayList(path));
        }
        helper(res,path,root.left,sum);
        helper(res,path,root.right,sum);

        path.remove(path.size()-1);
    }
}
