/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;
class TestClass2 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
    	 Scanner sc = new Scanner(System.in);
    	 int T=sc.nextInt();
    	 Map<Character,Boolean> mapOfVowels=new HashMap<>();
         mapOfVowels.put('a',true);
         mapOfVowels.put('e',true);
         mapOfVowels.put('i',true);
         mapOfVowels.put('o',true);
         mapOfVowels.put('u',true);
         mapOfVowels.put('A',true);
         mapOfVowels.put('E',true);
         mapOfVowels.put('I',true);
         mapOfVowels.put('O',true);
         mapOfVowels.put('U',true);
         
    	 for(int choice=0;choice<T;choice++) {
    		 String inputString=sc.next();
    	
    		
    		 int sum=0;
    		 for(int i=0;i<inputString.length();i++) {
    			 int prevSum=0;
    			 for(int j=i;j<inputString.length();j++) {
    				if(i==j ) {
    					if(mapOfVowels.containsKey(inputString.charAt(i)))
    					prevSum=1;
    					else
    						prevSum=0;
    					
    				} 
    				else {
    					if(mapOfVowels.containsKey(inputString.charAt(j))) {
    						prevSum+=1;
    					}
    					
    					
    				}
    				sum+=prevSum;
    			 }
    		 }
    		 System.out.println(sum);
    		 
    	 }
        

    }
}
