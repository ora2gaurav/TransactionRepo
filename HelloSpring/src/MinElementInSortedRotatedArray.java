
public class MinElementInSortedRotatedArray {


	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5,6,7,8,9,10};
		rotateArray(arr,4);
		//for(int i=0;i<arr.length)
	}

	private static void rotateArray(int[] arr, int n) {
	if(arr.length+1==n) return ;
		int [] temp=new int [n];
		for(int i=0;i<n;i++) {
			temp[i]=arr[i];
		}
		int k=0;
		for(int i=n;i<arr.length-n;i++) {
			arr[k]=arr[i];k++;
		}
		for(int i=0;i<n;i++) {
			arr[i]=temp[i];
		}
		
	}

}
