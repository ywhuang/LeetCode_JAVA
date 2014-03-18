
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        
        
        
		 // special cases: if head is null or contains only one node
        if (head == null)
            return head;
        if (head.next == null)
            return head;
            
        // add a dummy node before the first node in case the first element is a duplicate
        ListNode current = new ListNode(0);
        current.next = head;
        head = current;
       
        
        // general case:
     // the sequence of the conditions would effect
        while ( current.next != null && current.next.next!= null ) { 
            // duplicate found
            if (current.next.val == current.next.next.val) {
                // use a seconde iterator to iterate through duplicates
                ListNode duplicate = current.next;
                //reach to the last duplicate element
                while (duplicate.next !=null && duplicate.val == duplicate.next.val ) {
                    duplicate = duplicate.next;
                }
                // change the pointer
                current.next = duplicate.next;
            } else {
                current = current.next;
            }
        }
        
        
        return head.next;
    
    }
	
	 public class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
}
