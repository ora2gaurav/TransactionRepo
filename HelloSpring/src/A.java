import java.io.*;

public class A {
	static int [] arr={1,9,4,2,6,13,8,11};
    public static void main(String[] args) throws IOException {
    	
    	int even=0,odd=1;
    	/*1.check count of odd and even elements*/
    	for (;even <arr.length && odd<arr.length;)
    	{
    		System.out.println("even"+even);
    		System.out.println("odd"+odd);
    		if(arr[even]%2==0&&even+2<=arr.length){even=even+2;}
    		if(arr[odd]%2!=0&&odd+2<=arr.length){odd=odd+2;}
    		if(arr[odd]%2==0&&arr[even]%2!=0)
    		{
    		swap(even,odd);
    		}

    		
    	}
    	for (int i=0;i<arr.length;i++)
    		System.out.println(arr[i]);
    	
       
    }
    static void  swap(int a,int b)
    {
    	int temp=arr[a];
    	arr[a]=arr[b];
    	arr[b]=temp;
    	
    }
   
 }
