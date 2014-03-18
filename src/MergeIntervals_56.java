import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MergeIntervals_56 {
	
	
	//Given a collection of intervals, merge all overlapping intervals.
	//For example,
	//Given [1,3],[2,6],[8,10],[15,18],
	//return [1,6],[8,10],[15,18].
	
	public static void main(String args[]) {
		Interval i1 =new Interval(1,3);
		Interval i4 =new Interval(2,6);
		Interval i3 =new Interval(8,10);
		Interval i2 =new Interval(15,18);
		ArrayList<Interval> intvS = new ArrayList<Interval>();
		intvS.add(i1);
		intvS.add(i2);
		intvS.add(i3);
		intvS.add(i4);
		
		
		ArrayList<Interval> res = mergeIntervals(intvS);
		for (int i = 0 ; i < res.size() ; i++) {
			
			System.out.println("["+res.get(i).start+","+ res.get(i).end + "]");
		}
		
		
	}
	static final Comparator<Interval> Int_compare = new Comparator<Interval>(){
		public int compare(Interval i, Interval j){
			return new Integer(i.start).compareTo(new Integer(j.start));
		}
	};
	
	public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
		
		ArrayList<Interval> res = new ArrayList<Interval>();
		Collections.sort(intervals, Int_compare); // sort the arraylist according to the start value
		
		Interval temp ;
		Interval travel = intervals.get(0);
		for (int i = 1 ; i< intervals.size() ; i ++) {
						
			temp = intervals. get(i);
			if (temp.start > travel.end || temp.end < travel .start) {
				res.add(travel);
				travel = temp;
			} else {
				travel.start = Math.min(temp.start, travel.start);
				travel.end = Math.max(temp.end, travel.end);
			}			
		}
		
		res.add(travel);
		
		return res;
		/**
		Interval temp1;
		Interval temp2;
		Interval merge = new Interval();
		//int mergeStage = -1;
		//sort according to the start value
		
		// merge
		
		for (int i = 0 ; i<intervals.size() -1 ; i++) {
			boolean mergeSwitch = false;								
			for (int j = i+1 ; j < intervals.size() ; j++ ) {
				temp1 = intervals.get(i);
				temp2 = intervals.get(j);
				
				int startSwitch = (temp1.start - temp2.start) * (temp1.start - temp2.end);
				int endSwitch = (temp1.end - temp2.start) * (temp1.end - temp2.end);
				
				if ( startSwitch < 0 )
					merge.start = Math.min(temp1.start, temp2.start); // overlap
					
				if ( endSwitch < 0)
					merge.end = Math.max(temp1.end, temp2.end);; //overlap
					
				if (startSwitch < 0 || endSwitch < 0) {
					mergeSwitch = true;
					//mergeStage = j;
				}
				
					if (j == intervals.size() -1 ) { 
						if (mergeSwitch == false)
							res.add(temp1);
						else // (mergeSwitch == true ) 
							res.add(merge);
					}
			}									
		}
		*/
		
		
		
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
