//SOLUTION 1 - ADD as you go down
//SOLUTION 2 - Subtract from the target as you go down

//Time Complexity : O(n) Space Complexity : O(n) Best Case: O(logn)
//we visit each node exactly once thus TC is  O(n)
//worst case SC recursion call would occur N times (ht of tree) => O(n)
// best case SC => height of tree is balanced => O(logn)
class Solution{
    boolean res = false;
    public boolean hasPathSum(TreeNode root,int sum){
        helper(root,0,sum);

        return res;
    }


    private void helper(TreeNode root,int currSum,int sum){
        if(root == null){
            return;
        }

        currSum += root.val;
        if(root.left == null && root.right == null){
            if(sum == currSum)
                res = true;
        }
        helper(root.left,currSum,sum);
        helper(root.right,currSum,sum);

        currSum -= root.val;
    }
}

//Solution 2

class Solution{
  public boolean hasPathSum(TreeNode root,int sum){
    return helper(root,sum);
  }

  private boolean helper(TreeNode root,int sum){
    if(root == null)
      return false;
    sum -= root.val;
    if(root.left == null && root.right == null){
      return sum == 0;
    }

    return helper(root.left,sum) || helper(root.right,sum);
  }
}


// Iterative approach BFS is not appropriate because we dont reach the solution quickly except the worst case
// when the tree is completely unbalanced.

class Solution{
  public boolean hasPathSum(TreeNode root,int sum){
    if(root == null)
      return false;

    Stack<TreeNode> nodeStack = new Stack();
    Stack<Integer> sumStack = new Stack();

    nodeStack.add(root);
    sumStack.add(sum - root.val);

    TreeNode node;
    int curr_sum = 0;
    while(!nodeStack.isEmpty()){
      node = nodeStack.pop();
      curr_sum = sumStack.pop();

      if(node.right == null && node.left == null && currSum == 0) return true;

      if(node.right!=null){
        nodeStack.add(node.right);
        sumStack.add(curr_sum - node.right.val);
      }

      if(node.left!=null){
        nodeStack.add(node.left);
        sumStack.add(curr_sum-node.left.val);
      }
    }


    return false;
  }
}
