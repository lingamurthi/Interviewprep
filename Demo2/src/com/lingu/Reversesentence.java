package com.lingu;

public class Reversesentence {

	
	
	
	public static void main(String[] args)
	{
		String s="MY NAME IS";
		
		//output        IS NAME MY 
		
		String s4[]=reverse(s);
		
		for(int i=0;i<s4.length;i++)
		{
			System.out.print(s4[i]+" ");
		}
		
	}
	public static String[] reverse(String s1)
	{
		String[] newstring=s1.split(" ");
		String temp="";
		int j=newstring.length-1;
		for(int i=0;i<newstring.length/2;i++)
		{
			temp=newstring[i];
			newstring[i]=newstring[j];
			newstring[j]=temp;
			--j;
		}
		return newstring;
	}
}
