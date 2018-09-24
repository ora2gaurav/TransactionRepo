/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int B = sc.nextInt();
		int R = sc.nextInt();
		int Y = sc.nextInt();
		int G = sc.nextInt();
		int len=0;
	int i=0;
		while (i < B)

		{
			len++;
			i++;
		}
	int r=R;int y=Y;
	while(r>1&&y>0) {
		len+=2;
		r--;
		y--;
		
	}
	if(r>0)len++;
	i=0;
	while(G>i&&(R>0||(B<=0))) {
		len++;
		i++;
	}
	
	if(y>0) {len++;}
	
	System.out.println(len);

	
	
	}
}
