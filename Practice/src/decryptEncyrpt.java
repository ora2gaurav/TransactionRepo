import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class decryptEncyrpt {

	public static void main(String[] args) {
		String str = "SUNMOONSTARSEVERY";
		
		printme();
		
		//System.out.println(encryptDecrutp(str));
		//System.out.println(encryptDecrutp(encryptDecrutp(str)));
		
		
		
	}

	private static void printme() {
		List<Integer> list=new ArrayList<>(Arrays.asList(113920,
				117061,
				118516,
				118567,
				118575,
				124672,
				131000,
				142204,
				146581,
				183900,
				183910,
				193610,
				222585,
				325406,
				441651,
				559911,
				613738,
				675031,
				676830,
				703753,
				758906,
				767660,
				872140));	
		for(Integer a:list) {
			System.out.println("{\r\n" + 
					"					\"offeringGroupId\": \"00001\",\r\n" + 
					"					\"offeringId\": \""+a.toString()+"\"\r\n" + 
					"				},");
		}
	}

	private static String encryptDecrutp(String str) {
		char chArr[] = str.toCharArray();
		int factor = 4;
		int colsize = chArr.length / factor;
		char result[] = new char[chArr.length];
		int j = 0;int curr=0;
		while (j <= chArr.length - 1) {
			result[j++] = chArr[curr];
			if (curr + colsize + 1 > chArr.length) {

				curr = Math.abs(curr + colsize + 1 - chArr.length);
			} else {
				curr += (colsize + 1);
			}
		}
		
		
		StringBuilder soa=new StringBuilder();
		for(int i=0;i<result.length;i++)
		{
		soa.append(result[i]);}
		return soa.toString();
		
		
	}
}
