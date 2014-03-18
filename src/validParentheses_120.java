import java.util.Scanner;
import java.util.Stack;

public class validParentheses_120 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		System.out.println("valid P? ->" + validP(test));
	}
	
	public static boolean validP(String s) {
		
		char[] c = s.toCharArray();
		
		Stack<Character> stk = new Stack<Character>();
		
		for ( int i = 0 ; i < c.length ; i++) {
			if (c[i] == '(' || c[i] == '[' || c[i] == '{' ) {
				stk.push(c[i]);
			}
			
			if (c[i] == ')'){
				if (stk.peek() == '(')
					stk.pop();
				else
					return false;
			}

			if (c[i] == ']'){
				if (stk.peek() == '[')
					stk.pop();
				else
					return false;
			}

			if (c[i] == '}'){
				if (stk.peek() == '{')
					stk.pop();
				else
					return false;
			}
			
		}
		
		if (stk.isEmpty()) 
			return true;
		else		
			return false;
	}
}
