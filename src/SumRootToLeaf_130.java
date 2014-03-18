import java.util.ArrayList;
public class SumRootToLeaf_130 {

	public static void main(String args[]){
		SumRootToLeaf_130 test = new SumRootToLeaf_130();
		Tree t1 = new Tree(1);
		t1.right = new Tree(3);
		t1.right.right = new Tree(7);
		t1.right.left = new Tree(6);
		t1.left = new Tree(2);
		t1.left.left = new Tree(4);
		t1.left.right = new Tree(5);
		
		System.out.println("sum = " + test.sumRTL(t1));
		
	}
	
	public int sumRTL(Tree t){
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		int sum = 0;
		
		return dfsSum(t, path, sum);	
		
	}
	
	private int dfsSum(Tree t,ArrayList<Integer> path, int sum ) {
		
		if ( t.left == null && t.right == null) {
			path.add(t.value);
			System.out.println("sum = " + sum );
			sum = sum*10 + t.value;
			for (int x:path){
				System.out.print(x + ",");
			}
			System.out.println("tempsum = " + sum);
			return sum;
		}
		int sumL = 0 ;
		int sumR = 0 ;
		path.add(t.value);
		
		if (t.left != null) {
			
			
			int tempsum1 = sum*10 +t.value;
			sumL = dfsSum(t.left, path , tempsum1);
			path.remove(path.size() -1);
			
		}
		if (t.right != null) {
			
			
			int tempsum2 = sum*10 +t.value;
			sumR = dfsSum(t.right, path , tempsum2);
			path.remove(path.size() -1);
		}
		System.out.println("   sumL = " + sumL+" sumR = " + sumR);
		return sumL + sumR;
	}

	public static class Tree {
	Tree right;
	Tree left;
	int value;
	
	public Tree(int x){
		this.value = x;
		this.right = null;
		this.left = null;
		
	}
	
}


}
