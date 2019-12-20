/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        boolean val = dfs(root);
        if(val == false){
            return null;
        }
        else{
            return root;
        }
    }

    private boolean dfs(TreeNode root){
        if(root == null){
            return false;
        }

        boolean flag1 = dfs(root.left);
        boolean flag2 = dfs(root.right);

        if(flag1 == false){
            root.left = null;
        }

        if(flag2 == false){
            root.right = null;
        }

        return root.val == 1 || flag1 || flag2;
    }
}
