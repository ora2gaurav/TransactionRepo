/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T>0) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			int [] arr=new int [N];
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
				
			}
			Arrays.sort(arr);
			int minCost=0;
			for(int i=arr.length-1;i>=0;i--) {
				if(Math.abs(arr[0]-arr[i])>K) {
					minCost+=Math.abs(arr[0]-arr[i])-K;
				}
			}
			System.out.println(minCost);
			
		}
	}
}