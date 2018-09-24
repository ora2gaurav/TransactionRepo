
public class NodeFromKLenght {
	Node root;
	
	public static void main(String[] args) {
		NodeFromKLenght tree=new NodeFromKLenght();
		tree.root=new Node(20);
		tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.printKDistance(tree.root,target, 2);
	}
	
	

	private void printkdistanceNode( Node target, int n) {
		
		
		if(n==0) {
			System.out.println(target.data);
			return;
		}
		if(target.left!=null)
		printkdistanceNode(target.left,n-1);
		if(target.right!=null)
		printkdistanceNode(target.right,n-1);
		
		
	}
	
	private int printKDistance(Node node,Node target,int k) {
		if(node ==null) return -1;
		if(node.equals(target)) {
			printkdistanceNode(target,k);
			return 0;
		}
		int dl=printKDistance(node.left,target,k);
		if(dl!=-1) {
			if(dl+1==k) {
				System.out.println(node.data);
				
			}
			else {
				printkdistanceNode(node.right,k-dl-2);
		}
		return 1+dl;	
	}
		int dr=printKDistance(node.right,target,k);
		if(dr!=-1) {
			if(dr+1==k) {
				System.out.println(node.data);
				
			}
			else {
				printkdistanceNode(node.left,k-dr-2);
		}
			return 1+dr;	
	}
return -1;
}
	
}
