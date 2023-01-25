package com.lingu.tree;



class Node
{
	int data;
	Node left,right;
	
	Node(int data)
	{
		this.data=data;
	}
}
public class MaximumHeight {
	Node root;
	
	
	public static int findMaximumHeight(Node node)
	{
		
		if(node==null)
		{
			return 0;
		}
		int left=findMaximumHeight(node.left);
		int right=findMaximumHeight(node.right);
		
		if(left>right)
		{
			return left+1;
		}
		
		else
		{
			return right+1;
		}
		
	}

	public static void main(String[] args)
	{
		MaximumHeight tree= new MaximumHeight();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		
	int max=findMaximumHeight(tree.root);
	
	System.out.println(max);
		
	}
}
