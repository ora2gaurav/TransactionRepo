
public class partiton {
	static int findMinRec(int arr[], int i, int sumright, int sumleft)
	{
	    if (i==0)
	    { if(sumleft==sumright)
	    	System.out.println("left sum "+sumleft +" right sum "+sumright);
	    	return Math.abs(sumright-sumleft);
	    
	    }
	 
	    return Math.min(findMinRec(arr, i-1, sumright+arr[i-1], sumleft),
	               findMinRec(arr, i-1, sumright, sumleft+arr[i-1]+1));
	}
	
	static int findMin(int arr[], int n)
	{
	    // Compute total sum of elements
	    //int sumTotal = 0;
	    //for (int i=0; i<n; i++)
	      //  sumTotal += arr[i];
	 
	    // Compute result using recursive function
	    return findMinRec(arr, n, 0, 0);
	}
	    /*Driver function to check for above function*/
	    public static void main (String[] args)
	    {
	 
	        int arr[] = {1,3,5,2,4,6,3};
	        int n = arr.length;
	        int res=findMin(arr,n);
	            System.out.println(res);
	        }
	    
	    
}
