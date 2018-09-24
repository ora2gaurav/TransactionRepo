import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); 
        int [][] arr=new int[height][width];// the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); 
            System.err.println(line);

            char [] c=line.toCharArray();
            for(int j=0;j<width;j++){
                if(c[j]=='.')
                arr[i][j]=-1;
                else
                arr[i][j]=0;
                }
        }

        for(int i = 0; i < height; i++) {
	           for(int j=0;j<width;j++){
	          if(arr[i][j]!=-1)
	          { printneighbour(arr,i,j,width,height);
	          System.out.println(" ");
	          }
	           }
	               }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
            }
     private static void printneighbour(int[][] arr, int ai, int aj, int C, int R) {

	System.out.print(ai + " " + aj);
	int bottom=0;int right =0;
		for(int i=ai+1;i<R;i++){
			if(arr[aj][i]==0){
				bottom=1;
				System.out.print(" "+i+" "+aj);
				break;
			}
			}
		for(int i=aj+1;i<C;i++){
			if(arr[ai][i]==0){
				right=1;
				System.out.print(" "+ai+" "+i);
				break;
			}
			
		}
	
		if(right==0){
			System.out.print(" -1 -1");
		}
		if(bottom==0){
			System.out.print(" -1 -1");
		}
		}


}