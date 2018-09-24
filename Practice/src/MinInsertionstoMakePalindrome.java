
public class MinInsertionstoMakePalindrome {

	
	
	public static void main(String[] args) {
		String str="geeg";
		int [][] arr=new int [str.length()][str.length()];
		for(int gap=1;gap<str.length();gap++) {
			for(int l=0,h=gap;l<h&&h<str.length();++l,++h) {
				arr[l][h]=str.charAt(l)==str.charAt(h)?(arr[l+1][h-1]):Integer.min(arr[l+1][h], arr[l][h-1])+1;
			}
		}
		System.out.println(arr[0][str.length()-1]);
				
	}
}
