import java.util.Arrays;

public class SubarraySum
{
    /* Returns true if the there is a subarray of arr[] with sum equal to
       'sum' otherwise returns false.  Also, prints the result */
    int subArraySum(int arr[], int n, int sum) 
    {
        int curr_sum = arr[0], start = 0, i;
 int cnt=0;
 
        // Pick a starting point
        for (i = 1; i <= n; i++) 
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1)
            {
                curr_sum = curr_sum / arr[start];
                start++;
            }
             
            // If curr_sum becomes equal to sum, then return true
            if (curr_sum<= sum) 
            	
            {  cnt++;
                
            }
            if(curr_sum!=arr[i-1]&&arr[i-1]<=sum)
            {  cnt++;
            }
            // Add this element to curr_sum
            if (i < n)
            curr_sum = curr_sum *arr[i];
             
        }
 
        System.out.println(cnt);
        return 0;
    }
 
    public static void main(String[] args) 
    {
        SubarraySum arraysum = new SubarraySum();
        int arr[] = {2,3,6,4,5,7,1};
        
        int n = arr.length;
        int sum =10;
        arraysum.subArraySum(arr, n, sum);
    }
}