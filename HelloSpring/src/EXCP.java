

  class op{
Integer aa=10;
public void finalize() 
{
	System.out.println("aaaaas");}


  }


public class EXCP extends op  {
static int a=1;
	 int add(){try{a=a+1;return a;}finally{a=a+1;System.out.println("aaa");}}
public static void main(String[] args) {
	try{
		new EXCP().add();
		System.out.println(a);
		//throw new Error();
	}
	finally{
		System.out.println("FINALLY");
	}
	
	String a1=new String("A1");
	String a2=new String("A2");
	String a3=a1;
	String a4=a3+"aa";
	String a5=a2;
	a1=null;
	System.gc();
	a2=null;
	System.gc();
	a3=null;
	EXCP e=new EXCP();
	e.aa=10;
	e.aa=null;
	e=null;
	System.gc();
	//System.out.println(this);
}
public void finalize() 
{
	System.out.println(this);}


}

