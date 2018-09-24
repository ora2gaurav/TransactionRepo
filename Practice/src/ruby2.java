import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ruby2 {

	public static void main(String[] args) {
		/*
		 * B->B/R
		 * Y->B/R
		 * R->Y
		 * R->(G)/Y
		 * G->G/(Y)
		 * B->B/R(G/Y)
		 * b-r-G-Y
		 * B-R-Y-R-y-r-.....r-G
		 * BBBBRRRGGY
		 * RYYYYYYYRRRRRG
		 * RYRYRYRYRYRG
		 * RYRGGGGGGG
		 * RYRYRYRYRGY
		 * 10R 5Y
		 * RYRYRYRYRYRGGGGGGG
		 * RYR
		 * */
		Scanner sc = new Scanner(System.in);
		int B = sc.nextInt();
		int R = sc.nextInt();
		int Y = sc.nextInt();
		int G = sc.nextInt();
		int len=0;
	len+=B;
	int r=R;int y=Y;
	int g=0;
	if(R>0)
	{len+=((R-1)>Y?Y:R-1)*2;
	
	r=R-((R-1)>Y?Y:R-1);
	y=Y-((R-1)>Y?Y:R-1);
	}
	if(r>0)len++;
	if((R>0||B<=0 )&&G>0)
	{	g=1;len+=G;}
	
	if(y>0&&(g>0||R>0)) {len++;}
	//&&(G>0||R>0)
	System.out.println(len);

	
	
	}}
