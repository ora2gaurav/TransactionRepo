
public class longestPalindromeRecursion {
	static int max=0;
public static void main(String[] args) {
	String str="forgeeksskeegfor";
	findMaxString(str,0,str.length()-1);
	System.out.println(max);
}
private static Boolean findMaxString(String str, int i, int j) {
	if(i==j) {
		return true;
	}
	else if(i+1==j && str.charAt(i)==str.charAt(j)) {
		return true;
	}
	else if(i+1==j )
		return false;
	
	int currMax=0;
	if(str.charAt(i)==str.charAt(j) ) {
		
		Boolean chk=findMaxString(str,i+1,j-1);
		if(chk) {
			currMax=j-i+1;
		}
		else {
			Boolean chk1=findMaxString(str,i+1,j);
			Boolean chk2=findMaxString(str,i,j-1);
			
		}
		if(currMax>max) {
			max=currMax;
		}
		return chk;
	}
	else {
		Boolean chk1=findMaxString(str,i+1,j);
		Boolean chk2=findMaxString(str,i,j-1);
		
		return chk1&&chk2;
	}

	
}

}
