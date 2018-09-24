import java.util.HashMap;
import java.util.Iterator;



public class Anagrams {
	
	static boolean  isprime(int n)
	{  if(n==1) return false;
		for(int i=2;i<=n/2;i++){    
			   if(n%i==0){ return false;}
		}
		return true;
		
	}
	
	 static int getLargestNumberWithPrimeOccurences(int[] inputArray, int minOccurence) {
	        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	       
	        for (int i=0;i<inputArray.length;i++)
	        {
	            if(hm.containsKey(inputArray[i]))
	            {
	            	hm.put(inputArray[i], hm.get(inputArray[i])+1);
	            }
	            else{hm.put(inputArray[i], 1);
		           }
	        }
	        //System.out.println(hm);
	        Iterator<Integer> it=hm.keySet().iterator();
	        int val=0;
	        while (it.hasNext())
			{  val=hm.get(it.next());
	        	if(isprime(val)==false||val<minOccurence)
			{
				it.remove();
			}
			}
			it=hm.keySet().iterator();
			int max=it.next();
			while (it.hasNext())
			{ 
				if(max<it.next())
					max=it.next();
			}

			
			
			return max;
	        
	        
	        
	    }
	
	
	public static void main(String[] args) {

	int [] arr={1,11,11,11,11,23,11,
			37,51,37,37};
	
	System.out.println(getLargestNumberWithPrimeOccurences(arr,2));
	
	
	}

}
