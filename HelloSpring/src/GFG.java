/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


 class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
// This function should convert a given Binary tree to Doubly
// Linked List
// root -. Root of Binary Tree
// head -. head of created doubly linked list
public class GFG
{
    Node head;
    Node curr;
    Node inorder(Node root)
    {   
    
    if(root==null) return null;
   // if(root.left==null && root.right==null) return root;
        inorder(root.left);
        curr.right=root;
        curr.right.left=curr;
        
        curr=curr.right;
        inorder(root.right);
        return curr;
    }
    Node BToDLL(Node root)
    {
 
head=new Node(100);
 curr=head;
inorder(root);
head.right.left=null;
return head.right;
    }
}