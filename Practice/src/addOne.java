import java.util.ArrayList;
import java.util.List;

public class addOne {

	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i=1;i<500000;i++) {
			al.add(9);
		}
		System.out.println(plusOne(al));
		
	}
	 public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
	      int chk=0;
	      List<Integer> newA=new ArrayList<>();
	      for(Integer nam:A){
	          if(chk==0&&nam==0){
	              
	          }
	          else{
	              newA.add(nam);
	              chk=1;
	          }
	      }
	      A=new ArrayList<>(newA);
	      newA.clear();
	    //  System.out.println(A);
	      if(A.size()==0){
	          A.add(1);
	          return A;
	      }
	        int carry=1;
	        if(A.get(A.size()-1)+carry>9) {
	            for(int i=A.size()-1;i>=0&&carry==1;i--) {
	                if(A.get(i)+carry>9&&i!=0) {
	                    carry=1;
	                    A.set(i,0);
	                }
	                else if(i!=0) {
	                    A.set(i, A.get(i)+carry);
	                    carry=0;
	                }
	                else if(i==0&&A.get(i)+carry>9){
	                    A.set(i, 1);
	                    A.add(0);
	                }
	                 else{
	                      A.set(i, A.get(i)+carry);
	                      carry=0;
	                 }
	            }
	        }
	        else {
	            A.set(A.size()-1,A.get(A.size()-1)+carry);
	        }
	        return A;
	    }
	 
}
