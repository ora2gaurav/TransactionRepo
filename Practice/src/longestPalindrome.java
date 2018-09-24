
public class longestPalindrome {
	
public static void main(String[] args) {
	String checkerStr="geeksskeeg";
	boolean[][] lookupArr=new boolean [checkerStr.length()][checkerStr.length()];
	int start=0;int maxLength=0; 
	for(int i=0;i<checkerStr.length();i++) {
		lookupArr[i][i]=true;
		start=i;
		maxLength=1;
	}
	//double
	for(int i=0;i<checkerStr.length()-1;i++) {
		if(checkerStr.charAt(i)==checkerStr.charAt(i+1)) {
			lookupArr[i][i+1]=true;
			start=1;
			maxLength=2;
		}
	}
	//triple++
	for(int k=3;k<=checkerStr.length();k++) {
		for(int i=0;i<checkerStr.length()-k+1;i++) {
			
			int j=i+k-1;
			if(lookupArr[i+1][j-1]&&checkerStr.charAt(i)==checkerStr.charAt(j)) {
				lookupArr[i][j]=true;
				if(maxLength<k) {
					start=i;
					maxLength=k;
				}
			}
		}
		
		
	}
	
	System.out.println(maxLength);
	System.out.println(checkerStr.substring(start, start+maxLength));
	
} 

}
