import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class findMinSubarrayWithGivenSum {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	HashMap<Integer,Integer> hm=new HashMap<>();
	int [] arr=new int [N];
	for(int i=0;i<N;i++) {
		arr[i]=sc.nextInt();
		if(i!=0) {
			arr[i]+=arr[i-1];
		}
	}
	hm.put(arr[0],0);
	for(int i=1;i<N;i++) {
		hm.put( arr[i],i);
		
	}
	int sum=sc.nextInt();
	int minCount=Integer.MAX_VALUE;
	for(Map.Entry<Integer, Integer> intVa:hm.entrySet()) {
		if(intVa.getKey()==sum) {
			if(minCount>(intVa.getValue()+1)) {
				minCount=intVa.getValue()+1;
			}
		}
		else if(intVa.getKey()>sum) {
			Integer index=hm.get(intVa.getKey()-sum);
			if(index!=null) {
				if(minCount>Math.abs(index-intVa.getValue())) {
					minCount=Math.abs(index-intVa.getValue());
				}
			}
		}
	}
System.out.println(minCount);	                    
}
}
