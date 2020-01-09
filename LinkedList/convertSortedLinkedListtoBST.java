/*
  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
  of every node never differ by more than 1.

  i/p: [-10,-3,0,5,9]
              mid
  o/p: [0,-3,9,-10,null,5,null]

  i/p: [1]
  o/p: [1]

  i/p: [-5,-4,-3,-2,-1,0]
              mid

      -3
     /

  o/p: [-2,-4,-0,-5,-3,-1,null]
*/

//Return the tree
/* Tasks:
   1. Find findMiddle - Done
   2. Assing Root - Done
   2. Recurse for left
   3. Recurse for right

*/

class Solution{
  public TreeNode sortedListToBST(ListNode head){
    if(head == null) return null;
    ListNode middleNode = findMiddle(head);
    TreeNode root = new TreeNode(middleNode.val);
    if(head == middleNode){
      return root;
    }
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(middleNode.next);
    return ;
  }

  private ListNode findMiddle(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = head;
    while(fast!=null && fast.next!=null){
      prev = slow
      slow = slow.next;
      fast = fast.next.next;
    }
    if(prev !=null){
      prev.next = null;
    }
    return slow;
  }
}
