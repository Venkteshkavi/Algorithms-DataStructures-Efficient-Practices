import java.util.*;

class Solution{
  public ListNode findMiddle(ListNode head){
    ListNode slow = head;
    ListNode fast = head;

    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
