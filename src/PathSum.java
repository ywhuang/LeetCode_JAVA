
public class PathSum {
	
	
	public class TreeNode {
		
		TreeNode right;
		TreeNode left;
		int val;
		public TreeNode(int x) {
			this.val = x;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean hasPathSum(TreeNode root, int sum) {
        
        if (root == null)
            return false;
        
        sum = sum - root.val;
        
        if (sum == 0)
            return true;
        else
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        
        
    }

}
