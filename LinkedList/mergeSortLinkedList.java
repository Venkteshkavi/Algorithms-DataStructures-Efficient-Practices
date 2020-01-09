//sort a linked list using mergesort
/*
  Both Merge sort and Insertion sort can be used for linked lists.
  The slow random-access performance of a linked list makes other algorithms (such as quicksort) perform poorly, and others (such as heapsort) completely impossible.
  Since worst case time complexity of Merge Sort is O(nLogn) and Insertion sort is O(n^2), merge sort is preferred.
*/
// 1.Split the list
import java.util.*;

class Solution{
  public ListNode sortList(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;

    //1. Split Step
    while(fast!=null && fast.next!=null){
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if(prev != null){
      prev.next = null;
    }

    //Recusrive divide
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    //Merge Step (2 LinkedLists)
    return merge(l1,l2);
  }

  private ListNode merge(ListNode l1,ListNode l2){
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;

    while(l1!=null || l2!=null){
      if(l1 == null){
        curr.next = l2;
        break;
      }
      else if(l2 == null){
        curr.next = l1;
        break;
      }
      else{
        if(l1.val <= l2.val){
          curr.next = l1;
          l1 = l1.next;
        }
        else{
          curr.next = l2;
          l2 = l2.next;
        }
      }
      curr = curr.next;
    }

    return dummyHead.next;
  }
}
