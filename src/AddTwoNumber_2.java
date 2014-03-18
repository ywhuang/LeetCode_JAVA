
public class AddTwoNumber_2 {
	// 2->4->5
	// 3->6->4
	
	//  5->0->0->1
	public static void main(String args[]){
		
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(5);
		//list1.next.next.next = new ListNode(7);
		
		ListNode list2 = new ListNode(3);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(4);
		//list2.next.next.next = new ListNode(8);
		
		ListNode res = add(list1, list2);
		while(res != null) {
			System.out.print(res.value+" -> ");
			res = res.next;
		}		
	}
	
	public static class ListNode{
		ListNode next;
		int value;
		public ListNode(int x) {
			this.value = x;
		}
	}
	
	public static ListNode add(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode head = res; // memorize the head of the res
		int carry = 0;
		int sum = 0;
		
		while (l1!=null && l2 !=null){
			sum = l1.value + l2.value + carry;
			res.next = new ListNode(sum % 10);			
			carry = sum/10;
			
			l1= l1.next;
			l2= l2.next;
			res = res.next;
		}
		
		while( l1 != null) {
			sum = l1.value + carry;
			res.next = new ListNode(sum % 10);
			
			carry = sum/10;
			l1= l1.next;
			res = res.next;
		}
		while( l2 != null) {
			sum = l2.value + carry;
			res.next = new ListNode(sum % 10);
			
			carry = sum/10;
			l2= l2.next;
			res = res.next;
		}
		if (carry > 0){
			res.next = new ListNode(carry % 10);
			carry = sum/10;
			res = res.next;
		}
		
		
		return head.next;
	}
	
	
}
