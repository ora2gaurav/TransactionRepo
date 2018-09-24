import java.util.Scanner;

public class practicethreads {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	Integer a=sc.nextInt();
	String pol=Integer.toBinaryString(a);
	System.out.println(pol);
	int first=pol.indexOf('1');
	int last=pol.lastIndexOf('1');
	int maxrun=0;int currun=0;
	char[]polar=pol.toCharArray();
	//System.out.println(polar);
	for(int i=first;i<=last;i++)
	{//System.out.println(polar[i]);
		if(polar[i]=='0') {
			currun++;
		}
		else {
			if(currun>maxrun) {
				maxrun=currun;
				
			}
			currun=0;
		}
		
	}
	System.out.println(maxrun);
	
	
	
	
}
}
