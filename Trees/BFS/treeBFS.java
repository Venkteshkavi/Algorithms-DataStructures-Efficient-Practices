class treeBFS{
  private void levelOrderTraversal(TreeNode root){
    List<Integer> res = new ArrayList();
    Queue<TreeNode> q = new TreeNode();
    q.add(root);
    int lvl = 0;
    while(!q.isEmpty()){
      res.add(new ArrayList());
      int qsize = q.size();
      while(qsize>0){
        TreeNode node = q.poll();
        res.get(lvl).add(node.val);
        qsize--;

        if(node.left!=null) q.add(node.left);
        if(node.right!=null) q.add(node.right);
      }
      lvl++;
    }
    System.out.println("Level Order Traversal  : " + res);
  }
}
