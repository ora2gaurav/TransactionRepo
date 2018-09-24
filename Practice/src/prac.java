import java.util.Date;

public class prac{
	static int smin=0;static int smax=0;
	 public static void main(String[] args) {
		 
		 
		 List<Long> 
		 
		 int [] arr= {-1,2,3,-4,-6};
		 int max_ending_here=1;
		 int min_ending_here=1;
		 int max=1;//-10 max=1,-2max=20,4max=80,-5 max=-400
		 //-1 max=1,-2 max=2,4 max
		 int end=0;
		
		
		 int start=0;
		 for(int i=0;i<arr.length;i++) {
			 if(arr[i]>0) {
				 max_ending_here*=arr[i];
				 min_ending_here=min(min_ending_here*arr[i],1);
				 if(min_ending_here!=1) {
					 smin+=1;
				 }
				
				 
			 }
			 else if(arr[i]==0) {
				 smin=i+1;smax=i+1;
max_ending_here=1;
min_ending_here=1;
		}
			 
			 else {
				 int tem=max_ending_here;
				 max_ending_here=max(min_ending_here*arr[i],1);
				if(max_ending_here==1) {
					smax+=1;
				}
				else {smax=smin;}
				 min_ending_here=tem*arr[i];
				 }
						 
			 if(max_ending_here>max) {
				 end=i;
				 start=min(smax,smin);
				 max=max_ending_here;
			 }
			 
			 }
		 System.out.println(max);
		 System.out.println(end);
		 System.out.println(start);
	 }
	 static int max(int a,int b) {
		 if(a>b) {
			 
			 return a;
		 }
		 else {
			
			 return b;
		 }
	 }
	 static int min(int a,int b) {
		 if(a<b) {
			
			 return a;
		 }
		 else {
			
			 return b;
		 }
	 }
} 