import java.util.Arrays;

public class FindFourPairHavingSum {
	
	
	public static void main(String[] args) {
		int arr[] = {10, 20, 30, 40, 1, 2};
	    int n = arr.length;
	    int X = 91;
	    findFourElements (arr, n, X);
	  
	}

	public static void findFourElements(int[] arr, int n, int x) {
		pairsum [] listofsum =new pairsum[(n*(n-1)/2)];
		int k=0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				listofsum[k++]=new pairsum(arr[i] + arr[j], i, j);	
		 Arrays.sort(listofsum);
		//System.out.println(k);
		// for(int i=0;i<k;i++)
		 //System.out.println(listofsum[i].toString());
		 int i=0;
		 int j=k-1;
		 int sum=0;
		 while(i<j &&(i<k-1)&&(j>=0)) {
			 sum=listofsum[i].sum+listofsum[j].sum;
			 if(sum==x) {
				 if(checkcommon(listofsum[i],listofsum[j])) {
					 System.out.println(listofsum[i]+" ,"+ listofsum[j]);break;}
			 }
			 else if(sum>x)
			 {j--;}
			 else if(sum<x) {
				 i++;
			 }
			 
		 }
		 
			
		
	}
	
	public static boolean checkcommon(pairsum a,pairsum b) {
		
		if(a.a!=b.a || a.a !=b.b ||a.b!=b.a ||a.b!=b.b)
		return true;
		return false;
		
	}
}
class pairsum implements Comparable<pairsum>{
	
	public pairsum(int sum, int a, int b) {
		super();
		this.sum = sum;
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return "pairsum [sum=" + sum + ", a=" + a + ", b=" + b + "]";
	}
	int sum;
	int a;
	int b;
	@Override
	public int compareTo(pairsum o) {
		
		return sum-o.sum;
	}
	
}