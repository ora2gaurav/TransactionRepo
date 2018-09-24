import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DuckFishAllocation {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Map<Integer,List<Integer>> mapOfDuckAges=new TreeMap<>();
	
	int T=sc.nextInt();
	while(T>0) {
		mapOfDuckAges.clear();
		int totalDucks=sc.nextInt();
		int [] duckAgeLookup=new int [totalDucks];
		for(int i=0;i<totalDucks;i++) {
			int duckAge=sc.nextInt();
			if(mapOfDuckAges.containsKey(duckAge)) {
				mapOfDuckAges.get(duckAge).add(i);
			}
			else {
				mapOfDuckAges.put(duckAge, new ArrayList<>(Arrays.asList(i)));
				}
			
			duckAgeLookup[i]=duckAge;
		}
		int [] arr=calcualteDuckAllocationResponse(mapOfDuckAges,totalDucks,duckAgeLookup);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		
		T--;
	}
}

private static int[] calcualteDuckAllocationResponse(Map<Integer, List<Integer>> mapOfDuckAges, int totalDucks, int[] duckAgeLookup) {
	int [] resultArr=new int [totalDucks];
	if(totalDucks==1) {
		resultArr[0]=1;
		return resultArr;
	}
	for(Map.Entry<Integer,List<Integer>> entryKeyVal:mapOfDuckAges.entrySet()) {
		int duckAge=entryKeyVal.getKey();
		List<Integer> duckIndexes=entryKeyVal.getValue();
		for(Integer index:duckIndexes) {
			Integer neighbour1=null;
			Integer neighbour2=null;
			if(index-1>=0) {
				neighbour1=index-1;
			}
			if(index+1<totalDucks) {
				neighbour2=index+1;
			}
			if(index==0 ||index==totalDucks-1) {
				if(index==0) {
					neighbour2=index+1;
				}
				else {
					neighbour2=index-1;
				}
				if(resultArr[neighbour2]==0) {
					resultArr[index]=1;
				}
				else if(duckAgeLookup[neighbour2]<duckAgeLookup[index]) {
					resultArr[index]=resultArr[neighbour2]+1;
				}
				else {
					resultArr[index]=1;
				}
			}
			else {
				
				
				 if(duckAgeLookup[neighbour1]<duckAgeLookup[index]  &&duckAgeLookup[neighbour2]<duckAgeLookup[index] ) {
					int max=resultArr[neighbour1]>resultArr[neighbour2]?resultArr[neighbour1]:resultArr[neighbour2];
					resultArr[index]=max+1;
				}
				 else if(duckAgeLookup[neighbour2]<duckAgeLookup[index] ) {
						resultArr[index]=resultArr[neighbour2]+1;
					}
					else if(duckAgeLookup[neighbour1]<duckAgeLookup[index]  ) {
						resultArr[index]=resultArr[neighbour1]+1;
					}
				else {
					resultArr[index]=1;
				}
				
				
			}
				
		}
				
		
	}
	return resultArr;
}
}
