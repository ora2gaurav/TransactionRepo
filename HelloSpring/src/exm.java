interface t1{int i=10;}
interface t2{int i=20;}
public class exm implements t1,t2{

	
	public static void main(String[] args) throws InterruptedException  {
		
		try{
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(t1.i);
		System.out.println(new exm().hashCode());
		}
		
		finally{
		System.out.println("aaa \n");	
			
		}
	}
	
}
