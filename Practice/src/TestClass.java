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

        // Write your code here
         Scanner sc = new Scanner(System.in);
        Map<Character,Boolean> dictonaryVowel=new HashMap<>();
        dictonaryVowel.put('a',true);
        dictonaryVowel.put('e',true);
        dictonaryVowel.put('i',true);
        dictonaryVowel.put('o',true);
        dictonaryVowel.put('u',true);
        
       int T=sc.nextInt();
      
      for(int i=0;i<T;i++){
           char [] charArr=sc.next().toCharArray();
           char previous=' ';
           int worstInd=0;
           int BadInd=0;
           int goodInd=0;
           for(int j=0;j<charArr.length;j++){
               if(dictonaryVowel.containsKey(charArr[j])){
               if(previous!=' '&&(charArr[j]>previous && worstInd==1)||(charArr[j]<previous &&goodInd==1)){
                   BadInd=1;
                   break;
               }
               else if(previous!=' '&& charArr[j]>previous){
                   goodInd=1;
               }
               else if(previous!=' '&& charArr[j]<previous){
                   worstInd=1;
               }
               previous=charArr[j];
               }
              
           }
            if(BadInd==1){
                   System.out.println("Bad");
               }
               else if(worstInd==1){
                   System.out.println("Worst");
               }
               else{
                    System.out.println("Good");
               }
       }
       
       
       


    
    }
}
