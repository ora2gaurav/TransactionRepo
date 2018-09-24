import java.util.Arrays;
import java.util.Scanner;

public class highestKm {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T>0) {
			int N=sc.nextInt();
			int [] arr=new int[N];
			int [] negativeArr=new int[N];
			for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			if(a>0) {
				arr[i]=sc.nextInt();
			}
			else {
				
			}
			}
			  Arrays.sort(arr);
			int cumulativeDistance=0;
			int totalCalories=0;
			for(int i=arr.length-1;i>=0;i--) {
				totalCalories+=2*cumulativeDistance+arr[i];
				cumulativeDistance+=arr[i];
				
			}
			System.out.println(totalCalories);
			T--;
		}
	}

}
