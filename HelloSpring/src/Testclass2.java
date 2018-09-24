import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;


/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/

public class Testclass2 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        
        */
    	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer> ();
    	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          PrintWriter wr = new PrintWriter(System.out);
          int t= Integer.parseInt(br.readLine().trim());
          String op;
          while(t>0){
        	  op="YES";
        	  Integer cnt;
           int n = Integer.parseInt(br.readLine().trim());
           String[] arr_a = br.readLine().split(" ");
           for(int i_a=0; i_a<n; i_a++)
           {cnt=hm.get(Integer.parseInt(arr_a[i_a]));
           if(cnt==null){cnt=0;}
           
           hm.put(Integer.parseInt(arr_a[i_a]), cnt+1);
           }

      
       	
       	
           for(int i=n;i>0;)
           {
        	   Integer remcnt=hm.get(i);
        	   if(remcnt==null){op="NO"; break;}
        	   else{
        		   hm.remove(i);
        		   i=i-remcnt;
        	   }
        	   
           }
           if(hm.size()!=0)
        	   op="NO";
           
           System.out.println(op);
          t--;
          }
           wr.close();
           br.close();
    }
    
}
