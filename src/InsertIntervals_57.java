import java.util.ArrayList;


public class InsertIntervals_57 {
    
	//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	//You may assume that the intervals were initially sorted according to their start times.
	//Example 1:
	//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
	//Example 2:
	//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
	//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	public static void main(String args[]) {
		Interval i1 =new Interval(1,3);
		Interval i2 =new Interval(6,9);
		ArrayList<Interval> intvS = new ArrayList<Interval>();
		intvS.add(i1);
		intvS.add(i2);
		
		Interval intv = new Interval (2,5);
		ArrayList<Interval> res = insertInterval(intvS,intv);
		for (int i = 0 ; i < res.size() ; i++) {
			
			System.out.println("["+res.get(i).start+","+ res.get(i).end + "]");
		}
		
		
	}
	
	
	public static ArrayList<Interval> insertInterval (ArrayList<Interval> intvS, Interval intv) {
		
		// insert the new intervals
		// Insert new Start
		ArrayList<Interval> res = new ArrayList<Interval>();
		
		Interval temp ;
		
		
		int i = 0;
		while (i < intvS.size()) {
			temp = intvS.get(i);
			
		
				
			if (intv.start > temp.end)
				res.add(temp);
			else if ( intv.end < temp.start)
				break;
			else {
				intv.start = Math.min(temp.start, intv.start);
				intv.end = Math.max(temp.end, intv.end);
			}
			
			i++;
									
		}
		
		res.add(intv);
		// add the rest to the res arraylist
		
		while (i<intvS.size()) {
			res.add(intvS.get(i));
			i++;
		}

		return res;
	}
	
	
	public static class Interval {
		
		int start;
		int end;
		public Interval( ) {
			this.start = 0;
			this.end = 0;
		}
		
		public Interval (int s, int e) {
			this.start = s;
			this.end = e;
		}
		
	}
}
