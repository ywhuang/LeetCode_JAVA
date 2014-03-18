
public class RemoveDupFrSortedList_83 {
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	 public ListNode deleteDuplicates(ListNode head) {
	        
	        if (head == null)
	            return null;
	        if (head.next == null)
	            return head;
	        ListNode start = head;
	        
	        while (head.next != null) {
	            if (head.next.val == head.val) {
	                head.next = head.next.next;
	            } else {
	                head = head.next;
	            }
	        }
	        
	        
	        return start;
	    }
	}
}
