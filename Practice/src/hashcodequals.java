import java.util.HashMap;
import java.util.Map;

public class hashcodequals {
public static void main(String[] args) {
	Aaa aa1=new Aaa(12);
	Aaa aa2=new Aaa(12);
	Aaa aa3=new Aaa(13);

	Baa bb1=new Baa(10);
	Baa bb2=new Baa(10);
	Baa bb3=new Baa(11);
	Map<Aaa,Integer> hm1=new HashMap<>();
	Map<Baa,Integer> hm2=new HashMap<>();
	hm1.put(aa1, 1);
	hm1.put(aa2, 2);
	hm1.put(aa3, 3);
	hm2.put(bb1, 1);
	hm2.put(bb2, 2);
	hm2.put(bb3, 3);
	System.out.println(hm1.toString());
	System.out.println(hm1.get(aa1));
	System.out.println(hm2.toString());
	System.out.println(hm2.get(bb2));
	if(aa1.equals(aa2)) {
		System.out.println("JJJ");
	}
	
	
}



}


class Aaa{
	int a;

	

	public Aaa(int a) {
		super();
		this.a = a;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aaa other = (Aaa) obj;
		if (a != other.a)
			return false;
		return true;
	}
	
	
	
}
class Baa{
	int b;

	public Baa(int b) {
		super();
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		return result;
	}

}