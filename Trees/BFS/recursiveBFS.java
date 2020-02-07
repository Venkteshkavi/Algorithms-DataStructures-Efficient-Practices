class Solution{
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return new ArrayList();

        int lvl = 0;
        helper(root,lvl);
        return res;
    }

    private void helper(TreeNode node,int lvl){
        if(res.size() == lvl){
            //Found a new depth in the tree then add new lvl
            res.add(new ArrayList());
        }

        //When lvl is less than res.size() it reached here this means we are visiting a node
        // at the some lvl encountered before
        res.get(lvl).add(node.val);

        if(node.left!=null){
            helper(node.left,lvl+1);
        }
        if(node.right!=null){
            helper(node.right,lvl+1);
        }
    }
}
