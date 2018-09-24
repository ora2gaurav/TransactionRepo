class A1{
	static int cu=10;
	int a;
	A1(int a){ this.a=a;System.out.println("A");}

	
}
abstract class D{
	
}
class B extends A1
{  
	B(){super(1);
	cu++;
	System.out.println("B");}
	}
public class kk {
	static void swap(A1 a,A1 b)
	{
		int c = a.a;
		 a.a= b.a;
		b.a=c;
	}
	public static void main(String[] args) {
		A1 j=new A1(2);
		A1 j1=new A1(3);
		
		System.out.println(j.a +"  "+ j1.a);
		swap(j,j1);
		System.out.println(j.a +"  "+ j1.a);	}

}
