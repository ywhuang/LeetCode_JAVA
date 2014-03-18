
public class SwapNodesInPairs_108 {
	
	public static void main(String args[]) {
		
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next =new ListNode(3);
		test.next.next.next =new ListNode(4);
		test.next.next.next.next =new ListNode(5);						
		
		printList(test);
		
		printList(swapInPair(test));
		
	}
	
	
	public static ListNode swapInPair(ListNode head) {
		
		// create a starter node
		
		ListNode p = new ListNode(0);
		p.next = head;
		head = p;
		printList(head);
		// printLinkedList to test;
			
		while (p.next != null && p.next.next !=null) {
			ListNode q1 = p.next;
			ListNode q2 = p.next.next;
			
			q1.next=q2.next;
			q2.next = q1;
			p.next = q2;
			
			p = p.next.next; // or p = q1;
			
		}			
		
		return head.next;
	}
	
	
	public static void printList(ListNode head){
		
		while(head != null) {
			System.out.print(head.val+" -> " );
			head = head.next;
			
		}
		System.out.println();
	}
	
	
	
	
	
	//Definition for singly-linked list.
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	
	
}
