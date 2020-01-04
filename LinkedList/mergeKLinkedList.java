/*Approach 1: Brute Force: Place all elements in a list sort them and form the linkedlist
              back again
               T: O(NlogN) S: O(N)
           2: Compare One by One: Compare every \text{k}k nodes (head of every linked list) and get the node with the smallest value.
                                  Extend the final sorted linked list with the selected nodes.
                    T: O(Nk) k - No. of LinkedList N - No.of nodes in the final LL
                    S: O(N) -  for new LL creation otherwise O(1)
           3: Using PQ: optimize the comparison process by priority queue
                    T: O(NlogK) S: O(N) for LL , O(k) for PQ.
*/

import java.util.*;
public class mergeKLinkedList {
	Node head;

	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}

	private void append(int new_data) {
		if(head == null) {
			head =  new Node(new_data);
			return;
		}
		Node new_node = new Node(new_data);
		new_node.next = null;
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new_node;

	}


	private void printLL() {
		Node tNode = head;
		while(tNode!=null) {
			System.out.println(tNode.data);
			tNode = tNode.next;
		}
	}

	private static Node mergeKlists(List<mergeKLinkedList> lists) {

		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1,Node o2) {
				return  o1.data - o2.data;
			}
		});

		for(mergeKLinkedList list : lists) {
			if(list!=null) {
				q.add(list.head);
			}
		}

		Node nhead = new Node(0);
		Node curr = nhead;

		while(!q.isEmpty()) {
			curr.next = q.poll();
			curr = curr.next;
			Node next = curr.next;
			if(next!=null) {
				q.add(next);
			}
		}


		return nhead.next;
	}

	public static void main(String[] args) {
		mergeKLinkedList l1 = new mergeKLinkedList();
		mergeKLinkedList l2 = new mergeKLinkedList();
		mergeKLinkedList l3 = new mergeKLinkedList();
		l1.append(1);
		l1.append(4);
		l1.append(5);

		l2.append(1);
		l2.append(3);
		l2.append(4);

		l3.append(2);
		l3.append(6);


		List<mergeKLinkedList> lists = new ArrayList();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);

		Node ans = mergeKlists(lists);
		while(ans!=null) {
			System.out.println(ans.data);
			ans = ans.next;
		}

//		System.out.println(lists);


	}
}
