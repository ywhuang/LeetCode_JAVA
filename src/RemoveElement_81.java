
public class RemoveElement_81 {

	public static void main(String args[]) {
		int[] a = {1,2,3,4,3,5,6,3};
		int l = removeElement(a , 3);
		for (int i = 0 ; i < l ; i ++) {
			System.out.print(a[i]+",");
		}
		System.out.println();
	}
	
	
	public static int removeElement(int[] a, int x) {
		
		int i = 0 ;
		int j = 0 ;
		
		while (i<a.length) {
			
			if ( a[i] == x) { 
				i++;
			}else {
				a[j]=a[i];
				i++;
				j++;
			}						
		}
		
		
		
		return j;
	}
	
	
	
	
}
