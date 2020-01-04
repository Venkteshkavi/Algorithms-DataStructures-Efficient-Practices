//Find Average of Each level in BT
import java.util.*;

//Using BFS
// TC : O(N) - all the nodes are visited atleast once.
// SC: O(M) - M refers to the maximum no. of nodes at any level in the tree
class Solution{
  public List<Double> averageOfLevels(TreeNode root){
    if(root == null) return  new ArrayList();

    List<Double> res =  new ArrayList();
    Queue<TreeNode> q = new LinkedList();
    q.add(root);

    while(!q.isEmpty()){
      int qsize = q.size();
      double avg =  0;
      double sum  = 0;
      //For calculating avg
      int temp = qsize;
      while(qsize > 0){
        TreeNode node = q.poll();
        qsize--;

        sum += node.val;

        if(node.left!=null) q.add(node.left);
        if(node.right!=null) q.add(node.right);
      }
      avg = sum / temp;
      res.add(avg);
    }


    return  res;
  }
}


/*  * Using recursion
    * Intuition : Maintain two lists one for the node values, and other for counts
*/

class Solution{
  public List<Double> averageOfLevels(TreeNode root){
    if(root == null) return new ArrayList();
    List<Double> res = new ArrayList();
    List<Integer> count = new ArrayList();

    findAvg(root,0,sum,count);

    for(int i=0; i<res.size(); i++){
      res.set(i,res.get(i) / count.get(i));
    }

    return res;
  }

  private void findAvg(TreeNode root,int i,List<Double> sum,List<Integer> count){
    if(root == null) return;

    //i < sum.size() because : when trying to set for 0 set method throws an error
    // because we dont have anything in the list to modify
    // therefore add in else clause when same index is encountered sum these values.

    if(i<sum.size()){
      sum.set(i,sum.get(i) + root.val);
      count.set(i,count.get(i)+1);
    }
    else{
      //not just root.val -> Integer to double error therefore multiply by 1.0
      sum.add(1.0 * root.val);
      count.add(1)l
    }

    findAvg(root,i+1,sum,count);
    findAvg(root,i+1,sum,count);
  }
}
