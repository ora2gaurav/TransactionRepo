/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class TestClass3 {
    public static void main(String args[] ) throws Exception {/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes

*/
import java.util.*;
import java.math.BigInteger; 

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
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
    	 Map<Character,Boolean> dictonaryVowels=new HashMap<>();
         dictonaryVowels.put('a',true);
         dictonaryVowels.put('e',true);
         dictonaryVowels.put('i',true);
         dictonaryVowels.put('o',true);
         dictonaryVowels.put('u',true);
         dictonaryVowels.put('A',true);
         dictonaryVowels.put('E',true);
         dictonaryVowels.put('I',true);
         dictonaryVowels.put('O',true);
         dictonaryVowels.put('U',true);
         
    	 for(int choice=0;choice<T;choice++) {
    		 String inputString=sc.next();
    	        char chArr[]=inputString.toCharArray();
    		
    		BigInteger sum = new BigInteger("0"); 
    		for(int i=0;i<chArr.length;i++) {
    			if(dictonaryVowels.containsKey(chArr[i])) {
    			    int index=i+1;
    			    int multiplacnd=chArr.length-i;
    				sum=sum.add(new BigInteger(index+"").multiply(new BigInteger(multiplacnd+"")));
    			}
    		}
    		 System.out.println(sum);
    		 
    	 }
        

    
    }
}
}
}
