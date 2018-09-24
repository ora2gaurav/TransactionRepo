import java.util.HashSet;
import java.util.Set;

public class powerSet {
	
	
	public static void main(String[] args) {
		String str="abc";
		recursivePowerSet(str,0,"");
		
	}

	private static void recursivePowerSet(String str, int index, String prefix) {
	if(index==str.length()) {
		System.out.println(prefix);
		return;
	}
	recursivePowerSet(str, index+1, prefix+str.charAt(index));
	recursivePowerSet(str, index+1, prefix);
		
	}

}
