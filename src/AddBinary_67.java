
public class AddBinary_67 {

	public static void main (String args[]) {
		
		String test1 = "1101";
		String test2 = "101";
		System.out.println(addBin(test1,test2));
		
		System.out.println((char)(98));
	}
	
	public static String addBin(String a, String b){
		
		char[] res = a.length()>b.length()? a.toCharArray():b.toCharArray(); // the longer
		char[] str = a.length()>b.length()? b.toCharArray():a.toCharArray(); // the shorter
		int i = str.length-1;
		int j = res.length-1;
		boolean carry = false;
		while (i>=0) {
			if (res[j]=='1' && str[i]=='1') {res[j]= carry? '1' : '0'; carry = true; i--;j--;continue;}
			if (res[j]=='0' && str[i]=='0') {res[j]= carry? '1' : '0'; carry = false;i--;j--;continue;}
			if (res[j]=='1' && str[i]=='0') {res[j]= carry? '0' : '1'; i--;j--;continue;}
			if (res[j]=='0' && str[i]=='1') {res[j]= carry? '0' : '1'; i--;j--;continue;}		
			System.out.println("check i =" + i +"check j =" + j +" res[j]= "+res[j]+" str[i]= "+ str[i]);
		}
		
		while (j>=0){
			if (res[j]=='1' && carry == true) {res[j] = '0'; j--; continue;}
			if (res[j]=='0' && carry == true) {res[j] = '1'; break;}
			System.out.println("check2");
		}
		System.out.println("check3");
		if (j<0 && carry)
			return "1"+(new String(res));
		else return new String(res);
		
	}
}
