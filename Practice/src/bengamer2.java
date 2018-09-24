import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bengamer2 {
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<String> strList = new ArrayList<>();
		int masktotal=0;
		for (int i = 0; i < N; i++) {
			strList.add(sc.next().substring(0, M));
			masktotal|=Integer.parseInt(strList.get(i),2);
		}
		
		
		List<Integer> costList=new ArrayList<>();
		
		for(int i=0;i<Math.pow(2, M);i++) {
			
			costList.add(Integer.MAX_VALUE);
		}
		if(costList.size()>0)
		costList.set(0, 0);
		int newState=0;int newcost=0;
		for(int i=0;i<Math.pow(2, M);i++) {
		int curr_cost=costList.get(i);
		int curr_ones=countSetBits(i);
		for(int j=0;j<N;j++) {
			newState=i|Integer.parseInt(strList.get(j),2);
			newcost=(int) (curr_cost+Math.pow(countSetBits(newState)-curr_ones, 2));
			costList.set(newState,newcost<costList.get(newState) ?newcost:costList.get(newState));	
		
		}
			
		
		}
		 
		
		System.out.println(costList.get(masktotal));
		}
	
	
	
	
	static int countSetBits(int n)
	{
	    // base case
	    if (n == 0)
	        return 0;
	 
	    else
	 
	        // if last bit set add 1 else add 0
	        return (n & 1) + countSetBits(n >> 1);
	}
	 

}
