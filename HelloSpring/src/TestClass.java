import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_a = br.readLine().split(" ");
         int[] a = new int[n];
         for(int i_a=0; i_a<arr_a.length; i_a++)
         {
         	a[i_a] = Integer.parseInt(arr_a[i_a]);
         }

         long out_ = solve(a);
         System.out.println(out_);
         

         wr.close();
         br.close();
    }
    static long solve(int[] a){
       int largest=a[0];
        long sum=0;
    	for(int i=1;i<a.length;i++)
    	{
    		if(largest<a[i])largest=a[i];
    	}
    	HashMap  <Integer,Integer> hm =new HashMap<Integer,Integer>();  
    	for (int i=0;i<=largest;i++)
  	  {hm.put(i, 0);
  	   }
    	recursub(a, 0,a.length, "",hm);

    	for(Entry<Integer, Integer> kv:hm.entrySet())
    	{
    		//System.out.println(((maxlength(a, i)*Math.pow(31, i))));
    		sum+=(kv.getValue()*Math.pow(31, kv.getKey()));
    		
    		
    	}
    	return (long) (sum%(Math.pow(10, 9)+7));
    
    }
    public static int xorval(String[] prefix)
    {  int xor=0;
    	for (int i=0;i<prefix.length;i++)
    	{xor=xor^Integer.parseInt(prefix[i]);
    		
    	}
		return xor;
    }
	public static void recursub(int []arr,int index,int k,String prefix,HashMap<Integer,Integer> hm)
	{
		    
		  if(prefix.length()<=k&&prefix.length()>0)
			{   
		    	int xorvalue=xorval(prefix.split(""));
		    	if(hm.containsKey(xorvalue))
		    	{
		    	int len=hm.get(xorvalue);
		    	if(len<prefix.length())
		    	{
		    		hm.put(xorvalue, prefix.length());
		    	}
		    	}
			}
		    
		    else if(prefix.length()>k){return;}
		for(int i=index;i<arr.length;i++)
		{
			String newprefix=""+arr[i];
			if(prefix.length()<k)
			recursub(arr,i+1,k,prefix+newprefix, hm);
			
		}
			
		
	}
}