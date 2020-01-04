//TC: O(N) size of linked list no. node
//SC: O(1) without considering the dummyhead

import java.util.*;

class Solution{
  public ListNode swapPairs(ListNode head){
    ListNode dummyHead = new ListNode(0);
    ListNode dummyHead.next = head;
    ListNode curr = dummyHead;

    while(curr.next!=null && curr.next.next!=null){
      ListNode first = curr.next;
      ListNode second = curr.next.next;

      first.next = second.next;
      curr.next = second;
      second.next = first;
      curr = first;
    }

    return dummyHead.next;
  }
}
