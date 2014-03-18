import java.util.ArrayList;
import java.util.LinkedList;


public class MergeKSortedList_52 {
// using java LinkedList class instead
	
	public static void main(String args[]) {
		
		LinkedList<Integer> p = new LinkedList<Integer>();
		p.add(1);
		p.add(3);
		p.add(5);
		p.add(7);
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(2);
		q.add(4);
		q.add(6);
		q.add(8);
		q.add(12);
		
		LinkedList<Integer> r = new LinkedList<Integer>();
		r.add(9);
		r.add(10);
		r.add(11);
		
		System.out.println("p:" + p.toString() );
		System.out.println("q:" + q.toString() );
		System.out.println("r:" + r.toString() );
		
		
		ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>(); 
		lists.add(p);
		lists.add(q);
		lists.add(r);
		
		LinkedList<Integer> res = mergeKSortedList(lists);
		System.out.println("result:" +res.toString() );
		
	}
	
	// Analysis:
	// Choose one as the result list
	// Merge all other lists to this list
	
	// List p, q , And p as the result list
	// Use two pointers from the head of the lists
	// while ( q list still is not empty )
	// if p[i] < q[i], insert q[i] before p[i]
	// if p[i] > q[i], go to next p[i] in list p
	// Then continue to the next list r.. until all K lists have been compared
	
	// Complexity: O( K*m)
	
	
	public static LinkedList<Integer> mergeKSortedList(ArrayList<LinkedList<Integer>> lists) {
		
		LinkedList<Integer> resList = new LinkedList<Integer>();
		LinkedList<Integer> compareList = new LinkedList<Integer>();
		
		if (!lists.isEmpty()) {
			resList = lists.get(0);
		}
		
		int i = 1;
		// Loop all the linkedlist in the lists
		while (i < lists.size() ) {
			System.out.println("   i = " + i);
			compareList = lists.get(i);
			
			// merge two linkedlists
			
			int j =0;
			int k =0;
			// add null detection?
			//int x = resList.peekFirst();
			//int y = compareList.peekFirst();
			
			
			// need to consider when resList reaches the last element
			while (!compareList.isEmpty() && j < resList.size()) {  // || !resList.isEmpty() 				
				
				if (resList.get(j) >= compareList.get(k)) {
				
					// add compareList's node before res'node
					resList.add(j, compareList.removeFirst());
					j++;					
				} else {
					// resList moving forward
					j++;
				}			
				System.out.println("   j = " + j);
			} // end while
			
			System.out.println("   final j = " + j);
			// copy the rest elements in compareList when the resList reaches last
			if (j == resList.size() ) {
				
				while (!compareList.isEmpty()) {
				resList.add(compareList.removeFirst());
				}
			}	
			i++;						
		}
		return resList;
	}
		
}
