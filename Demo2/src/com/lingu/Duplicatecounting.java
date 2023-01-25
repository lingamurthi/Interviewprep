package com.lingu;

public class Duplicatecounting {

	
	
	public static void main(String[] args)
	{
		String a="MY	NAME	IS";
		//String a2=a.replaceAll("\t", " ");
		//output    MY NAME IS
		removespace(a);
	}
	
	
	
	public static void removespace(String a1)
	{
		String[] b=a1.split("	");
		for(int i=0;i<b.length;i++)
		{
			
			
		
			
			if(b[i].equals("	"))
			{
				continue;
			}
			
			System.out.print(b[i]+" ");
		}

 	}
}
