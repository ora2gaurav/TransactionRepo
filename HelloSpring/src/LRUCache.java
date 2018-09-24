import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LRUCache {

	private Queue<Integer> q=new LinkedList<>();
	private int size;
	private HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	
	LRUCache(int a)
	{
		size=a;
		
	}
	public int get (int key)
	{
		if(hm.containsKey(key))
		{
		q.remove(key);
		q.add(key);
		return hm.get(key);
		}
		return -1;
	}
	public void set(int key,int value)
	{
		
		if(hm.containsKey(key))
		{q.remove(key);
         }
		else if(size==0)
		{
			int rem=q.poll();
			hm.remove(rem);
		}
		q.add(key);
		hm.put(key, value);
		if(size>0)
		size--;
	}
	public void print()
	{
		System.out.println(hm);
		
	}
	public static void main(String[] args) {
		LRUCache l=new LRUCache(5);
			l.set(1, 5);
			l.set(2, 7);
			l.print();
			l.set(3,8);
			l.set(4, 9);
			l.print();
			System.out.println("GET:->" +l.get(1));
			l.print();
			l.set(5,18);
			l.print();
			l.set(6, 19);
			l.print();
	
	
}
}