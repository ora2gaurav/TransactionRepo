import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class ProcessString {
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
		    		System.out.println(prefix);
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
	public static void main(String[] args)  {
	int [] arr={1,2,3,4,5};
	
	HashMap  <Integer,Integer> hm =new HashMap<Integer,Integer>();  
	for (int i=0;i<=5;i++)
	  {hm.put(0, 0);
	 }
		recursub(arr, 0,5, "",hm);
		
//	}
	
	for(Entry<Integer, Integer> a:hm.entrySet())
	{
		System.out.println("Key:->"+a.getKey()+"Value:->"+a.getValue());
	}
	
	}
	
}
