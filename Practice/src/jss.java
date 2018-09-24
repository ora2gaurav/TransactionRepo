import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class jss {

	
	
	public static void main(String[] args) {
		Map<Integer,String>  map=new LinkedHashMap<>();
		map.put(1,"aaaaaaa");
		map.put(2, "aaaqqq1");
		for(Map.Entry<Integer,String> mape:map.entrySet()) {
			System.out.println(mape.getKey());
		}
		String a=map.get(1);
		//a=a+"bbb";
		map.get(1)=map.get(1)+"zz";
		map.put(1,"xyz");
		//System.out.println(a);
		for(Map.Entry<Integer,String> mape:map.entrySet()) {
			System.out.println(mape.getKey());
		}
		
	}
}
