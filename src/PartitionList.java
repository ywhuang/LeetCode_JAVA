
public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}
		      public ListNode partition(ListNode head, int x) {
		          
		          
		          if (head.next == null)
		              return head;
		          
		          ListNode current = new ListNode(0);
		          current.next=head; // executing node
		          head= current; // memory node
		          
		          ListNode last = current; 
		          int n = 0; // length of the list
		          
		          
		          //find last
		          while (last.next != null) {
		              last = last.next;
		              n++;
		          }
		          
		          while(n>0) {
		              if (current.next.val < x) {
		                  current = current.next;
		                  n--;
		              }   else {
		                  ListNode temp = new ListNode(current.next.val);
		                  last.next = temp;
		                  //last.next.next = null;
		                  last = last.next;
		                  
		                  current.next= current.next.next;
		                  n--;
		              }
		          }
		          
		          
		          return head.next;
		      }
}
