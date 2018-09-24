import java.io.IOException;
class AAS{
}
class BAA extends AAS{
	
}
class CAA extends AAS{
	
}
public class jfiqjfq {
	
	public static void main(String[] args) {
	try {
		System.out.println(err());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}
	
	static int err() throws Exception{
		try {
			throw new IOException("aa");
		}
		catch(RuntimeException exp) {
			throw new RuntimeException("aaa");
		}
		finally {
			return -1;
		}
		
	}
	

}
