//Remove LinkedList elements
// Sentinel nodes are widely used in trees and linked lists as pseudo-heads, pseudo-tails, markers of level end, etc. They are purely functional, and usually does not hold any data. Their main purpose is to standardize the situation, for example, make linked list to be never empty and never headless and hence simplify insert and delete.
// if we need to delete nodes at the starting the problem becomes Complex

//TC: O(n)
//SC: O(1) -- doubt

//I/p : [1->2->6->3->4->6]
//important tc: [1], [1,1]


class Solution{
  public ListNode removeLinkedListElements(ListNode head){
    if(head == null) return null;
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;
    ListNode prev = sentinel;
    ListNode curr = head;

    while(curr!=null){
      if(curr.val == val){
        prev.next = curr.next;
      }
      else{
        prev = curr;
      }
      curr = curr.next;
    }

    return sentinel.next;
  }
}
