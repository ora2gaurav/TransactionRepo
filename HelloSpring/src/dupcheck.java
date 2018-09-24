import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class poq{
	int a;
	int b;
	

	public poq(){}
	public poq(int a){}
	
}

public class dupcheck {
	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
	@SuppressWarnings("rawtypes")
	Class c=Class.forName("poq");
	ArrayList<Constructor<poq>> ctor=new ArrayList<Constructor<poq>>();
	ctor.add(c.getDeclaredConstructor());
	System.out.println(c.getDeclaredConstructors());
	System.out.println(ctor);
	
		HashMap<String,Integer> hm=new 	HashMap<String,Integer>();
		String []arr={"aaa","bbb","aaa","aaa","bbb","ccc"};
		for (String str :arr)
		{   //System.out.println(str);
		    //if(hm.containsKey(str)==true){ break;}
		    hm.put(str,1);
		    
		    
		}
		ArrayList<Integer> araw=new ArrayList<Integer>();
            System.out.println("aaa->"+hm.put("ccc",2));		
		Iterator qw=hm.entrySet().iterator();
		while(qw.hasNext())
		{
			System.out.println(qw.getClass());
			qw.next();
		}
//	for(Entry<String, Integer> k:hm.entrySet())
	//{
	//	System.out.println("");
	//}

}
}