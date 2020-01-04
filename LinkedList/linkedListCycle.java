//Return if there is cycle present in the linkedlist or not
import java.util.*;
//[3,2,0,4] ptr:1
//[1] pos: -1
class Solution{
  public boolean detectCycle(ListNode head){
    if(head == null){
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;

    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        return true;
      }
    }

    return false;
  }
}

//LinkedList Cycle Detection 2 : Find the point of the Cycle
class Solution{
  public ListNode detectCycle(ListNode head){
    if(head == null){
      return head;
    }

    ListNode intersectionPt = findIntersection(head);
    if(intersectionPt == null){
      return null;
    }

    ListNode p1 = head;
    ListNode p2 = intersectionPt;

    while(p1!=p2){
      p1 = p1.next;
      p2 = p2.next;
    }

    return p1;
  }

  private static findIntersection(ListNode head){
    ListNode slow = head;
    ListNode fast = head;

    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast)
        return slow;
    }

    return null;
  }
}
