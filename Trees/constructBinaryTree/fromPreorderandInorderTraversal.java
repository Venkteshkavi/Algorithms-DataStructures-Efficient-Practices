class Solution{
  public TreeNode buildTree(int[] preorder, int[] inorder){
    Map<Integer,Integer> inorderMap = new HashMap();
    for(int i=0; i<inorder.length; i++){
      inorderMap.put(inorder[i],i);
    }

    int preStart = 0;
    int inStart = 0;
    int inEnd = inorder.length;

    return helper(preStart,inStart,inEnd-1,preorder,inorder,inorderMap);
  }

  public TreeNode helper(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder,Map<Integer,Integer> inorderMap){
    if(preStart > preorder.length-1 || inStart > inEnd){
      return null;
    }

    TreeNode root = new TreeNode(preorder[preStart]);

    int inIndex = inorderMap.get(root.val);

    root.left = helper(preStart+1,inStart,inIndex-1,preorder,inorder,inorderMap);
    root.right = helper(preStart+(inIndex-inStart+1),inIndex,inEnd,preorder,inorder,inorderMap);

    return root;
  }
}
