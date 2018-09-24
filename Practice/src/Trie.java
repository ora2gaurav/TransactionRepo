
class trie_node {
	public int isSet;
	public String data;
	public int isEnd;
	// public int isMore;
	public Trie next;

	trie_node() {
		isSet = 0;
		data = "";
		next = null;
		isEnd = 0;
		// isMore=0;
	}
}

public class Trie {
	public trie_node[] arr;

	Trie() {
		arr = new trie_node[26];
		for (int i = 0; i < arr.length; i++) {

			arr[i] = new trie_node();
		}
	}

	public static void main(String[] args) {

		Trie tr = new Trie();
		tr = processwords("HONEY", tr);
		tr = processwords("HOTEL", tr);
		tr = processwords("HOME", tr);
		tr = processwords("HOUSE", tr);
		tr = processwords("POSTER", tr);
		tr = processwords("HOMIE", tr);
		tr = processwords("HOUSEWIFE", tr);
		tr = processwords("HOUSTON", tr);
		tr = processwords("WERE", tr);

		searchSuggestions("HOM", tr);

	}

	public static Trie processwords(String a, Trie T) {
		Trie head = T;
		int index = 0;
		int i = a.length();
		for (char ch : a.toCharArray()) {
			index = chartoindex(ch);
			if (T.arr[index] != null && T.arr[index].isSet == 1) {
				if (i > 1 && T.arr[index].next == null) {
					T.arr[index].next = new Trie();

				}
				T = T.arr[index].next;
			} else {

				T.arr[index].isSet = 1;
				T.arr[index].data = String.valueOf(ch);
				if (i != 1) {
					T.arr[index].next = new Trie();
					T = T.arr[index].next;
				} else {
					T.arr[index].isEnd = 1;

				}
			}
			i--;

		}

		return head;

	}

	public static void searchSuggestions(String a, Trie T) {
		
		String result = "";
		for (char ch : a.toCharArray()) {
			int index = chartoindex(ch);
			if (T.arr[index] != null && T.arr[index].isSet == 1) {
				result += T.arr[index].data;

				if (T.arr[index].isEnd == 1) {
					System.out.println(result);
				}
				T = T.arr[index].next;
			} else {
				System.out.println("NOT FOUND SORRY");
				return;
			}
		}

		recursivecall(T, result);

	}

	public static void recursivecall(Trie T, String result) {
		if (T == null)
			return;
		else {

			trie_node[] arr = T.arr;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].isSet == 1 && arr[i].isEnd != 1) {

					recursivecall(arr[i].next, result + arr[i].data);
				} else if (arr[i].isSet == 1 && arr[i].isEnd == 1) {
					System.out.println(result + arr[i].data);
					recursivecall(arr[i].next, result + arr[i].data);

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
