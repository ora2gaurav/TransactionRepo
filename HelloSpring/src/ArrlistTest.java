import java.util.*;
 
public class ArrlistTest {

	
	public static void main(String args[])
	{
		int [] arr={7,2,5,4};
		int mid=(0+3)/2;
		int lmid=mid,hmid=mid;
		while(lmid>=0 && hmid<=3)
		{
			int lsum=0,rsum=0;
			for(int i=0;i<=lmid;i++)
				lsum+=arr[i];
			for(int i=3;i>hmid;i--)
				rsum+=arr[i];
			System.out.println("LSUM-"+lsum+"  RSUM-"+rsum);
			if(rsum==lsum){System.out.println(lmid+1); break;}
			else if(rsum>lsum ){hmid++;}
			else{lmid--;}
				
		}
		
		System.out.println("-1");
		
		
		
	}
}
