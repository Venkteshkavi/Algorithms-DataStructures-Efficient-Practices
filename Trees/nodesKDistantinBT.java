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
    Map<TreeNode,TreeNode> vertexMap;
    List<Integer> result;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        vertexMap = new HashMap();
        result = new ArrayList();

        //Creating a CHILD - PARENT MAPPING => so that we can do a bfs from the target
        buildVertexMap(root,null);

        findKDistantNode(root,target,K);

        //When Zero Distant apart add the target itself
        if(K==0){
            result.add(target.val);
        }
        return result;
    }

    //CHILD-PARENT MAP
    private void buildVertexMap(TreeNode node,TreeNode parent){
        if(node!=null){
            vertexMap.put(node,parent);
            buildVertexMap(node.left,node);
            buildVertexMap(node.right,node);
        }
    }

    private void findKDistantNode(TreeNode root,TreeNode target,int k){
        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        Set<TreeNode> seen = new HashSet();
        int lvl = 0;
        int lvlCount = 0;
        while(!q.isEmpty()){

            //Get lvl to stay in the same level and add all the elements to the queue
            lvl = q.size();

            while(lvl  > 0){
                TreeNode node = q.poll();
                seen.add(node);
                lvl--;

                if(!seen.contains(node.left) && node.left!=null){
                    q.add(node.left);
                }
                if(!seen.contains(node.right) && node.right!=null){
                    q.add(node.right);
                }
                if(vertexMap.get(node)!=null && !seen.contains(vertexMap.get(node)))
                    q.add(vertexMap.get(node));

            }

            //LVL COUNT IS INCREMENTED WHEN EACH LEVEL IS COMPELTE
            lvlCount++;
            if(lvlCount == k){
                for(TreeNode n : q){
                    result.add(n.val);
                }
                break;
            }
        }
    }
}
