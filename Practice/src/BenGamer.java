import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class BenGamer {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Set<Integer> setofNumber=new HashSet<>();
		for (int i = 0; i < N; i++) {
			setofNumber.add(Integer.parseInt(sc.next().substring(0, M),2));
			
		}
		List<Integer> strList = new ArrayList<>(setofNumber);
		setofNumber.clear();
		int cost=Integer.MAX_VALUE; 
		
		N=strList.size();
		for(int k=0;k<N;k++) {
			Integer currPattern=0;
			int curr_cost=computeCost(currPattern, strList.get(k));
			currPattern=strList.get(k);
			int i=0;
			List<Integer> levelList=new ArrayList<>(strList);
			levelList.remove(k);
		while(i<N-1) {
			
			int level=getMinLevel(currPattern,levelList);
			curr_cost+= computeCost(currPattern, levelList.get(level));
			currPattern=currPatternbitOrOPeration(currPattern, levelList.get(level));
			levelList.remove(level);
			
			i++;
		}
		if(cost>curr_cost) {
			cost=curr_cost;
		}
		}
		
		System.out.println(cost);
		}
	
	
	public static int getMinLevel(Integer curr,List<Integer> strList) {
		int minLevel=0;int cost=Integer.MAX_VALUE;
		for(int i=0;i<strList.size();i++) {
			
			int currcost=computeCost(curr,strList.get(i));
			if(cost>=currcost)
			{minLevel=i;
			cost=currcost;
			}
			
		}
		return minLevel;
		
	}


	private static Integer currPatternbitOrOPeration(Integer currPattern, Integer costString) {

		
		int a =  currPattern;
		int b = costString;
		int c = a | b;

		return (c);
	}

	private static int computeCost(Integer currPattern, Integer costString) {
    
		
		int a = currPattern;
		int b = costString;
		int cost = 0;
		int c = (a ^ b) & b;
		cost = (int) Math.pow(countSetBits(c), 2);
			
		return cost;
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
