import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ruby {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int B = sc.nextInt();
		int R = sc.nextInt();
		int Y = sc.nextInt();
		int G = sc.nextInt();
		int currLength = 0;
		int lenght = 0;
		int lenghtBlue = 0, lenghtRed = 0;
		int lenghtYellow = 0, lenghtGreen = 0;
		int totalSize=B+R+Y+G;
		Map<String,Integer> dynamicHelperMap=new HashMap<>();
		if (B > 0 || R > 0) {
			if (B > 0) {
				lenghtBlue = findMaxLen(B - 1, R, Y, G, "B", currLength + 1,dynamicHelperMap,totalSize);
			}
			if (R > 0 && totalSize>lenghtBlue) {
				lenghtRed = findMaxLen(B, R - 1, Y, G, "R", currLength + 1,dynamicHelperMap,totalSize);
			}

		} else {
			if (Y > 0) {
				lenghtYellow = findMaxLen(B, R, Y - 1, G, "Y", currLength + 1,dynamicHelperMap,totalSize);
			}
			if (G > 0 && totalSize>lenghtYellow) {
				lenghtGreen = findMaxLen(B, R, Y, G - 1, "G", currLength + 1,dynamicHelperMap,totalSize);
			}

		}

		lenght = getMax(lenghtBlue, lenghtRed, lenghtYellow, lenghtGreen);
		System.out.println(lenght);

	}

	private static int findMaxLen(int b, int r, int y, int g, String colortype, int currLength, Map<String, Integer> dynamicHelperMap, int totalSize) {
		String key=b+""+r+""+y+""+g+""+colortype;
		if ((b <= 0 && r <= 0 && y <= 0 && g <= 0)||currLength==totalSize) {
			
			return currLength;
		} else {
			
			if(dynamicHelperMap.containsKey(key)){
				return dynamicHelperMap.get(key);
			}
			int l1 = currLength;
			int l2 = currLength;
			int l3 = currLength;
			int l4 = currLength;
			if (colortype.equals("B") || colortype.equals("Y")) {
				if (b > 0)
					l1 = findMaxLen(b - 1, r, y, g, "B", currLength + 1,dynamicHelperMap,totalSize);

				if (r > 0) 
				l2 = findMaxLen(b, r - 1, y, g, "R", currLength + 1,dynamicHelperMap,totalSize);

			} else if (colortype.equals("G") || colortype.equals("R")) {
				if (g > 0)
					l3 = findMaxLen(b, r, y, g - 1, "G", currLength + 1,dynamicHelperMap,totalSize);

				if (y > 0)
					l4 = findMaxLen(b, r, y - 1, g, "Y", currLength + 1,dynamicHelperMap,totalSize);

			}
			dynamicHelperMap.put(key,  getMax(l1, l2, l3, l4));
			return getMax(l1, l2, l3, l4);
		}
		

	}

	private static int getMax(int l1, int l2, int l3, int l4) {
		int largest = l1;
		if (l2 >= largest)
			largest = l2;
		if (l3 >= largest)
			largest = l3;
		if (l4 >= largest)
			largest = l4;

		return largest;
	}
}
