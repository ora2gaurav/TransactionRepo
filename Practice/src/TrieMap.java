import java.util.HashMap;
import java.util.Map;

class trienode {
	public trienode(  TrieMap next) {
		super();
		this.isEnd = 0;
		this.next = next;
	}

	public int isEnd;
	public TrieMap next;

	trienode() {
		next = null;
		isEnd = 0;
	}
}

public class TrieMap {
	public Map<Integer,trienode> trieMap;

	TrieMap() {
		trieMap=new HashMap<>();
	}

	public static void main(String[] args) {

		TrieMap tr = new TrieMap();
		 processwords("HONEY", tr);
		 processwords("HOTEL", tr);
		 processwords("HOME", tr);
		 processwords("HOUSE", tr);
		 processwords("POSTER", tr);
		 processwords("HOMIE", tr);
		 processwords("HOUSEWIFE", tr);
		 processwords("HOUSTON", tr);
		 processwords("WERE", tr);
		 processwords("9939909000", tr);
		 processwords("993900000", tr);
		 processwords("998878909000", tr);
		 processwords("998700000", tr);
		 processwords("990987777", tr);
		searchSuggestions("HOM", tr);
		System.out.println("");
		searchSuggestions("H", tr);
		System.out.println("");
		searchSuggestions("_", tr);
		System.out.println("");
		searchSuggestions("I", tr);
		System.out.println("");
		searchSuggestions("POS", tr);

	}

	public static TrieMap processwords(String a, TrieMap T) {
		TrieMap head = T;
		int index = 0;
		int i = a.length();
		for (char ch : a.toCharArray()) {
			index = chartoindex(ch);
			if(T.trieMap.containsKey(index)) {
				if (i > 1 &&T.trieMap.get(index).next== null) {
					T.trieMap.get(index).next = new TrieMap();

				}
			
				T=T.trieMap.get(index).next;
			}
			else {
				T.trieMap.put(index,new trienode(new TrieMap()));
				if (i != 1) {
					T = T.trieMap.get(index).next;
				} else {
					T.trieMap.get(index).isEnd = 1;
			}
			}
				i--;
		}

		return head;

	}

	public static void searchSuggestions(String a, TrieMap T) {
		
		String result = "";
		for (char ch : a.toCharArray()) {
			int index = chartoindex(ch);
			if (T.trieMap.containsKey(index)) {
				result +=String.valueOf(ch);

				if (T.trieMap.get(index).isEnd == 1) {
					System.out.println(result);
				}
				T = T.trieMap.get(index).next;
			} else {
				System.out.println("NOT FOUND SORRY");
				return;
			}
		}

		recursivecall(T, result);

	}

	public static void recursivecall(TrieMap T, String result) {
		if (T == null)
			return;
		else {
			Map<Integer,trienode> trieMap=T.trieMap;
			for(Map.Entry<Integer, trienode> trieentry :trieMap.entrySet()) {
				if(trieentry.getValue().isEnd!=1)
				recursivecall(trieentry.getValue().next, result + asciTochar(trieentry.getKey()));
				else {
					System.out.println(result +asciTochar(trieentry.getKey()));
					recursivecall(trieentry.getValue().next, result +asciTochar(trieentry.getKey()));
				
				}
				
			}
		

		}
	}

	public static char asciTochar(int a) {
		char c = (char) ('A' + a);
		return c;
	}

	public static int chartoindex(char a) {
		return a - 'A';

	}

}
