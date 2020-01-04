import java.util.*;

class Solution{
  public ListNode getIntersectionPoint(ListNode headA,ListNode headB){
    if(headA == null || headB == null)
      return null;
    ListNode ptrA = headA;
    ListNode ptrB = headB;

    while(ptrA!=ptrB){
      if(ptrA == null){
        ptrA = headB;
      }
      else{
        ptrA = ptrA.next;
      }

      if(ptrB == null){
        ptrB = headA;
      }
      else{
        ptrB = ptrB.next;
      }
    }
    return ptrA;
  }
}
