// Print all tree paths from root to leaf
// Time Complexity : O(n)
// Space Complexity : O(n) worst case tree skewed Best case : O(logn)
class Solution{
  private List<String> res = new ArrayList();
  public List<String> binaryTreePaths(TreeNode root){
    if(root == null) return new ArrayList();
    String s =  "";
    helper(root,s);
  }

  private void helper(TreeNode root,String s){
    if(root ==  null){
      return;
    }

    s += Integer.toString(root.val);
    if(root.left == null && root.right == null){
      res.add(s);
    }
    else{
      s += "->";
      helper(root.left,s);
      helper(root.right,s);
    }
    return;
  }
}

//Irerative DFS approach
// TC: O(n)
// SC: O(n)
class Solution{
  public List<String> binaryTreePaths(TreeNode root){
    if(root == null) return new ArrayList();

    List<String> res = new ArrayList();
    Stack<TreeNode> nodeStack = new Stack();
    Stack<String> pathStack = new Stack();
    nodeStack.add(root);
    nodeStack.add(Integer.toString(root.val));

    TreeNode node;
    String path;

    while(!nodeStack.isEmpty()){
      node = nodeStack.pop();
      path = pathStack.pop();

      if(node.left == null && node.right == null){
        res.add(path);
      }

      if(node.left!=null){
        nodeStack.add(node.left);
        pathStack.add(path + "->" + Integer.toString(node.left.val));
      }

      if(node.right!=null){
        nodeStack.add(node.right);
        pathStack.add(path + "->" + Integer.toString(node.right.val));
      }
    }
  }
}


// BFS approach
// TC: O(n)
// SC: O(n)
class Solution{
  public List<String> binaryTreePaths(TreeNode root){
    if(root == null) return new ArrayList();

    List<String> res =  new ArrayList();
    Queue<TreeNode> q1 = new LinkedList();
    Queue<TreeNode> q2 = new LinkedList();
    q1.add(root);
    q2.add(Integer.toString(root.val));

    while(!q1.isEmpty()){
      int qsize = q1.size();

      while(qsize > 0)
        TreeNode node = q1.poll();
        String path = q2.poll();
        qsize--;
        if(node.left!=null){
          q1.add(node.left);
          path.add(path+"->"+Integer.toString(node.left.val));
        }

        if(node.right!=null){
          q1.add(node.right);
          path.add(path+"->"+Integer.toString(node.right.val));
        }

        if(node.left ==  null && node.right ==  null){
          res.add(path);
        }

    }
  }
}
