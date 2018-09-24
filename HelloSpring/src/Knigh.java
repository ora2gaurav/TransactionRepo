import java.io.IOException;

public class Knigh   {

	   static int M=8;
		static int N=8;
		static int di=2,dj=0;
	    static String horizdir; static String verdir;
	    static int min(int x, int y, int z)
	{
	   if (x < y)
	      return (x < z)? x : z;
	   else
	      return (y < z)? y : z;
	}
	 public static int getmin (int si,int sj)  
		{
		 if(si<0||sj<0||si>=8||sj>=8)
		 { 
			 throw new RuntimeException();}
		if(si==2 && sj==0) {return 1; }
		return 1+min(getmin(si,sj-1),getmin(si-1,sj),getmin(si-1,sj-1))
				;
		   
		   
		
		    
		}
		public static void main (String[] args) {
		 
		 int si=3,sj=3;
		 int cost=0;
		  horizdir="right";verdir="up";
		 if(si>=di)horizdir="left";
		 if(sj<=dj)verdir="down";
		  
		 System.out.println(getmin(3,3));
		 
		}
	}

