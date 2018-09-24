

public class Snippet {
	
	
	
	public static void main(String[] args) {
		int [] arr= {13,18,99,101,124,178,191,200};
		rotateArray(arr,4);
		fetchMin(arr,0,arr.length-1);
	}
	
	private static void fetchMin(int[] arr, int low, int high) {
		int mid=(low+high)/2;
		if(arr[mid]<arr[mid-1]) {
			System.out.println(arr[mid]);
			return;
		}
		else if(arr[mid]<arr[high])
			fetchMin(arr,low,mid);
		else fetchMin(arr,mid,high);
			
		
		
	}

	private static void rotateArray(int[] arr, int n) {
	if(arr.length+1==n) return ;
		int [] temp=new int [n];
		for(int i=0;i<n;i++) {
			temp[i]=arr[i];
		}
		int k=0;
		for(int i=n;i<arr.length;i++) {
			arr[k]=arr[i];k++;
		}
		int i=0;
		for(;k<arr.length;k++) {
			arr[k]=temp[i];
			i++;
		}
	return;	
	}
	
	
}