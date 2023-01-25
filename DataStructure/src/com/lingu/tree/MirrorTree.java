package com.lingu.tree;



class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data=data;
	}
}
public class MirrorTree {

	
	 Node mirrorimage(Node n)
	{
		 
		 if(n==null)
		 {
			 return n;
		 }
		Node left=mirrorimage(n.left);
		Node right=mirrorimage(n.right);
        left=n.right;
        right=n.left;
        return n;
		
	}
	 
	 
	 void inOrder(Node node)
	    {
	        if (node == null)
	            return;
	 
	        inOrder(node.left);
	        System.out.print(node.data + " ");
	 
	        inOrder(node.right);
	    }
	static Node root;
	public static void main(String[] args)
	{
		MirrorTree tree=new MirrorTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
		
		tree.mirrorimage(tree.root);
		
		tree.inOrder(root);
	}
}
