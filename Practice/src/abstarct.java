
public class abstarct extends absMe implements intf  {

	public static void main(String[] args) {
		abstarct abstarct=new abstarct();
		abstarct.doSomething();
		System.out.println(a);
		abstarct.doSomething();
		
	}
	public void doSomething() {
		System.out.println("huwhus");
	}
}


abstract class absMe{
	
	public  void doSomething() {System.out.println("anknk");};
	
}

interface intf{static int a=110;  

default  void doSomething() {
	System.out.println("asas");
}

}