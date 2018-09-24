import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class CheckBigDecoma {

	
	
	public static void main(String[] args) throws ParseException {
		
		chekcclaa a1=new chekcclaa();
		a1.a="A";
		a1.b="BCCS";
		a1.c=13;
		a1.d=19;
		chekcclaa a2=new chekcclaa();
		a2.a="A";
		a2.b="B";
		a2.c=13;
		a2.d=11119;
		Map<chekcclaa,Integer> a=new HashMap<>();
		a.put(a1, 1);
		a.put(a2, 2);
		System.out.println(a.toString());
		
		BigDecimal dec=new BigDecimal(100);
		BigDecimal dec2=new BigDecimal(106.22221111);
		dec2.setScale(4, BigDecimal.ROUND_HALF_DOWN);
		System.out.println(dec2);
		BigDecimal dec3=new BigDecimal(90);
		System.out.println(dec.compareTo(dec));
		System.out.println(dec.compareTo(dec2));
		System.out.println(dec.compareTo(dec3));
		
		
		
				
		
	}
}
class chekcclaa{
	String a;
	String b;
	int c;
	int d;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + c;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		chekcclaa other = (chekcclaa) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (c != other.c)
			return false;
		return true;
	}
	
	
}