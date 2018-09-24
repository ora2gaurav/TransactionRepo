
public class equilibriumpoint {
public static void main(String[] args) {
	int [] arr={1,3,5,2,2};
	int sum=0;
	int lsum=0;
	for(int i=0;i<arr.length;i++)
	{sum+=arr[i];
	}
	for(int i=0;i<arr.length;i++)
	{
		if(lsum==sum-arr[i])
		{
			System.out.println(i+1);
			break;
		}
		else{
			sum=sum-arr[i];
			lsum+=arr[i];
		}
	}
	
	
}
}
