package com.lingu.tree;



class Node{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data=data;
	}
}
public class SymmetricTree {

	
	
	
	boolean	isSymmetric(Node n1,Node n2)
	{
		if(n1==null && n2==null)
		{
			return true;
		}
		if(n1!=null && n2!=null && n1.data==n2.data)
		{
			return(isSymmetric(n1.left,n2.right)&&isSymmetric(n1.right,n2.left));
		}
		return false;
	}
	Node root;
	public static void main(String[] args)
	{
		SymmetricTree tree=new SymmetricTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        
       boolean output= tree.isSymmetric(tree.root,tree.root);
       
       if(output==true)
       {
    	   System.out.println("Symmetric");
       }
       else
       {
    	   System.out.println("Not Symmetric");
       }
	}
	
}
