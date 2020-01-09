class Solution{
  public List<Integer> inorderTraversal(TreeNode root){
    if(root == null) return new ArrayList();
    List<Integer> res = new ArrayList();
    Stack<TreeNode> s = new Stack();

    // Make a copy otherwise we will lose root
    TreeNode curr = root;
    while(curr!=null || !stack.isEmpty()){
      while(curr!=null){
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }
}
