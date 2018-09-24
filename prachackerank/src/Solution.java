import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
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
class TrieMap {
	public Map<Integer,trienode> trieMap;

	TrieMap() {
		trieMap=new HashMap<>();
	}
    public static Integer count=0;
	

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
					count++;
				}
				T = T.trieMap.get(index).next;
			} 
			else {
				System.out.println(count);
				return;
			}
		}

		recursivecall(T, result);
            System.out.println(count);
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
					//System.out.println(result +asciTochar(trieentry.getKey()));
                    count++;
					recursivecall(trieentry.getValue().next, result +asciTochar(trieentry.getKey()));
				
				}
				
			}
		

		}
	}

	public static char asciTochar(int a) {
		char c = (char) (0 + a);
		return c;
	}

	public static int chartoindex(char a) {
		return a - 0;

	}

}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TrieMap tr = new TrieMap();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")){
                TrieMap.processwords(contact,tr);
            }
            else if(op.equals("find")){
                TrieMap.count=0;
               TrieMap.searchSuggestions(contact,tr);
            }
        }
    }
}
