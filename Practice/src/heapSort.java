import javax.swing.text.LayeredHighlighter;

public class heapSort {
	public static void main(String[] args) {
	int [] arr= {12, 11, 13, 24, 5, 6,7};
	//heapSort1(arr,arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		findKElements(3,arr);
	}

	private static void heapSort1(int[] arr, int length) {
		for(int i=length/2-1;i>=0;i--) {
			heapify(arr,i,arr.length);
		}
	   for(int i=arr.length-1;i>=0;i--) {
		swap(0,i,arr);
		heapify(arr, 0,i);
	   }
	   
	}

	private static void heapify(int[] arr, int i,int N) {
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<N&&arr[largest]<arr[left]) {
			largest=left;
		}
		if(right<N&&arr[largest]<arr[right]) {
			largest=right;
		}
		if(i!=largest) {
		swap(largest,i,arr);
		heapify(arr,largest,N);
		}
		
	}

	private static void swap(int largest, int i, int[] arr) {
		int temp=arr[i];
		arr[i]=arr[largest];
		arr[largest]=temp;
		
	}
	
private static void findKElements(int k,int [] arr) {
	for(int i=(arr.length/2)-1;i>=0;i--) {
		heapify(arr,i,arr.length);
	}
	int j=0;
	while(j<k) {
		System.out.println(arr[0]);
		swap(0,arr.length-(j+1),arr);
		heapify(arr,0,arr.length-(j+1));
		j++;
	}
}
}
