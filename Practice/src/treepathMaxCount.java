import java.util.HashSet;
import java.util.Set;

public class treepathMaxCount {
	
	static int maxCount=0;
	public static void main(String[] args) {
		Node node=new Node(4);
		node.left=new Node(5);
		node.right=new Node(6);
		node.left.left=new Node(4);
		node.left.left.left=new Node(5);
		node.left.left.left.left=new Node(10);
		node.left.left.left.left.left=new Node(11);
		node.right.left=new Node(1);
		node.right.right=new Node(6);
		Set<Integer> nodeSet=new HashSet<>();
		nodeSet.add(node.data);
		maxCount=1;
		findMaxCount(node,nodeSet);
		System.out.println(maxCount);
		
	}
	
	public static void findMaxCount(Node root,Set<Integer> nodeSet) {
		if(root==null) {
			return;
		}
		
		if(root.left!=null){
			boolean a=nodeSet.add(root.left.data);
			
			findMaxCount(root.left, nodeSet);
			if(a)
			nodeSet.remove(root.left.data);
		}
		if(root.right!=null){
			boolean a=nodeSet.add(root.right.data);
			
			if(a)
			findMaxCount(root.right, nodeSet);
		}
		if(nodeSet.size()>maxCount) {
			maxCount=nodeSet.size();
		}
	}

}
