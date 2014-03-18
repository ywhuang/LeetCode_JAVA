
public class DisjointBtree {
	
	
	
	public static void main(String args[]) {

		
	}

	public static class Tree {
		
		Tree left;
		Tree right;
		int value;
		boolean gray;
		
		
		Tree(int value, boolean gray) {
			this.left = null;
			this.right = null;
			this .value = value;
			this.gray = gray;
		}
		
	
	}
	

	
	public void disjoint( Tree t, Tree copy) {
		
		//Tree newcopy;
		if (t.left == null && t.right == null ) 
			return;
		
		if (t.gray == true) {
			t.gray = false;
		}
		
		if (copy.gray == true) {
			
			if (t.left == null) {
				Tree newcopy= new Tree(copy.value, copy.gray);
				t.left = newcopy;
			}
			if (t.right == null) {
				Tree newcopy= new Tree(copy.value, copy.gray);
				t.right = newcopy;
			}
			
		}
		
		
		if(t.left.gray != true) {
			disjoint (t.left , copy);						
		} else {
			disjoint (t.left, t.left);
		}
		
		if (t.right.gray != true ) {
			disjoint (t.right, copy);
		} else {
			disjoint (t.right, t.right);
		}
		
		
	}
}
