

public class FlattenBTree_30 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

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
	
	public void flatten(Tree root) {
		
		while ( root != null ) {
			
			if (root.left != null) {
				
				Tree temp = root.left ;
				
				while (temp.right != null) {
					temp = temp.right;
				}
				
				temp.right = root.right;
				root.right = root.left;
				root.left = null;
				
			}
				root = root.right;									
		}
		
		
	}
}
