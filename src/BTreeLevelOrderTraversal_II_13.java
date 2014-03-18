import java.util.ArrayList;
import java.util.HashMap;

public class BTreeLevelOrderTraversal_II_13 {
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        
        //static int height = 0; // zerobased;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
               
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (root == null)
            return res;
        else
            traversal(root,0,map);
            
        for (int i = map.size()-1 ; i >=0 ; i--) {
            res.add(map.get(i));
        }
            
        return res;
        
}

public void traversal(TreeNode node, int l, HashMap<Integer, ArrayList<Integer>> map) {
            
         
            
            if ( !map.containsKey(l) ) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(node.val);
                map.put(l,a);
            } else {
                map.get(l).add(node.val);
            }
              l++;
            
            if (node.left == null && node.right == null)
                return;
            if (node.left != null)
                traversal(node.left, l, map);
            if (node.right != null)
                traversal(node.right, l, map);
            
                  
}
}
