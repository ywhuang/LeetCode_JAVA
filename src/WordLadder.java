import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class WordLadder {
	
	public static void main(String args[]){
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("hit");
		dict.add("hat");
		dict.add("dot");
		
		
		//ArrayList<String> res = new ArrayList<String>();
		int res = ladderLength("hot","dog", dict);
		
			System.out.println(res);
		
	}
	
	
public static int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size()==0 || start.length() == 0)
        	return 0;
        if (dict.size()>2500) 
            return 100;
        
        
        LinkedBlockingQueue<Node> q = new  LinkedBlockingQueue<Node>();
        Node node1 = new Node(start, 1);
        q.add(node1);
        
        //BFS
        return bfs(end, dict, q);
        
        
    }
public static class Node {
    String word;
    int level;
    public Node(String word, int level){
        this.word = word;
        this.level = level;
    }
    
}
    
    public static int bfs(String end, HashSet<String> dict,  LinkedBlockingQueue<Node> q) {
        int level = 1;
        while ( !q.isEmpty()){
        	 System.out.println("begin with level = " + level);
        	 System.out.println("q.peek().level = "+q.peek().level);
            if ( q.peek().level == level) {
                String current = q.peek().word;
                System.out.println("current = " + q.peek().word);
                System.out.println("current level = " + level);
                ArrayList<String> list = findDict(current,dict);
                for (String x : list) {
                    System.out.println(x+","+(level+1));
                    if ( valid(x, end) )
                        return level+1;
                    Node node = new Node(x,level+1);
                    q.add(node);
                   
                }
                
                System.out.println("size = " + q.size());
                q.poll();
            } else {
            	
                level++;
            }
            
            
           
        }
        
        return 0;
    }
    
    
    
    public static boolean valid(String x, String end){
        
        boolean flag = false;
        for (int i = 0 ; i < end.length() ; i++ ){
            if (x.charAt(i) != end.charAt(i)) {
                if (flag == false)
                        flag = true;
                else
                    return false;
            }
                
        }
        
        return true;
    }
    
    public static ArrayList<String> findDict(String current, HashSet<String> dict) {
        ArrayList<String> r = new ArrayList<String>();
       
        for (int i = 0 ; i<current.length(); i++) {
            for (char j = 'a' ; j<='z' ; j++) {
                String temp = current;
                char[] tempC = temp.toCharArray();
                tempC[i] = j;
                temp = new String(tempC);
                
                if (dict.contains(temp) && !r.contains(temp))
                    r.add(temp);
            }
        }
        
        
        return r;
    }
}
