
public class Eucleaidn {

	
	
	
	public static void main(String[] args) {
		long N=16L;
		long M=4L;
		long count =1L;
		Integer checker=0;
		Integer curr=(int) M;
		while(true) {
			System.out.println(curr);
			if((checker&(1<<curr))>0||curr==0) {
				break;
			}
			else {
				
				checker|=(1<<curr);
				count++;
				if(curr+M>N) {
					curr=(int) (curr+M-(N+1));
				}
				else {
					curr=(int) (curr+M);
				}
				
				
			}
			
			
			
		}
		System.out.println(count);
		
	}
}
