
public class dutchFlagAlgo {
public static void main(String[] args) {
	int [] arr= {1,2,0,1,1,0,0,2,1,0};
	int temp=0;int mid=0;int low=0;int high=arr.length-1;
	
	while(mid<high) {
		int num=arr[mid];
		if(num==0) {
			temp=arr[low];
			arr[low]=arr[mid];
			arr[mid]=temp;
			low++;
			mid++;
		}
		else if(num==1) {
			mid++;
		}
		else {
			temp=arr[high];
			arr[high]=arr[mid];
			arr[mid]=temp;
			high--;
		}
		
	}
	for(int i=0;i<arr.length;i++)
	System.out.println(arr[i]);
}
}
