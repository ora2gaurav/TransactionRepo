import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bear2 {
	static Integer max=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] head=new int[N];
		int [] tail=new int[N];
		for (int i = 0; i < N; i++) {
			int taila = sc.nextInt();
			tail[i]=(taila);
		}
		for (int i = 0; i < N; i++) {
			int heada = sc.nextInt();
			head[i]=heada;
			tail[i]+=(heada);
		}
		int maxSum=0;int sumEach=0;
		List<Integer> highestTime = maxOverlap(head,tail);
		sumEach=max;
		for(Integer time:highestTime) {
			int secondSum=0;
		if(sumEach==N||maxSum==N) {
			maxSum=N;
			break;
		}
		 else {secondSum = removeListOfElements(time, tail, head, N);
			}
		
		if(sumEach+secondSum>maxSum) {
			maxSum=sumEach+secondSum;
		}
		}
			
			System.out.println(maxSum>N?N:maxSum);
		}
		
		

	

	private static Integer removeListOfElements(int highestTime, int[] tail, int[] head, int n) {
		 List<Integer>  secondtailLength=new ArrayList<>();
		 List<Integer>  secondheadLength=new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			if (highestTime >= head[i] && highestTime <= (tail[i])) {
				
			} 
			else {
				secondtailLength.add(tail[i]);
				secondheadLength.add(head[i]);
			}

		}
		
		 int [] headaux=new int[secondtailLength.size()];
			int [] tailaux=new int[secondtailLength.size()];
			for(int i=0;i<secondtailLength.size();i++)
			{headaux[i]=secondheadLength.get(i);
			tailaux[i]=secondtailLength.get(i);
				
			}
        List<Integer> secindtime=maxOverlap(headaux,tailaux);
		return max;
	}





	public static List<Integer> maxOverlap(int []start,int [] end )
	{
	    List<Integer>countMap=new ArrayList<>();  
		
		   int maxa = Arrays.stream(start).max().getAsInt();
	      
	       int maxb = Arrays.stream(end).max().getAsInt();
	      
	       int maxc=Math.max(maxa,maxb); 
	          
	       int []x = new int[maxc+2];
	       Arrays.fill(x, 0);
	          
	        int cur=0,idx=0;
	        for(int i=0;i<start.length;i++)
	        {// Lazy addition
	         ++x[start[i]];
	         --x[end[i]+1];
	        }
	           
	        int maxy=Integer.MIN_VALUE;
	        for(int i=0;i<=maxc;i++) 
	        {cur+=x[i];if(maxy<cur){maxy=cur;}
	        	
	        }
	        cur=0;
	        for(int i=0;i<=maxc;i++) 
	        {cur+=x[i];
	        	if(cur==maxy) {
	        		countMap.add(i);
	        		
	        	}
	        	
	           //cur+=x[i];if(maxy<cur){maxy=cur;idx=i;}           
	        }
	    /*    System.out.println("Maximum value is:"+
	                           maxy+" at position: "+idx+"");
	      */  max=maxy;
	        return (countMap);
	           
	}    
	  
}
