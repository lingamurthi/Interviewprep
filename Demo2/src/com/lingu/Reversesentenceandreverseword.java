package com.lingu;

public class Reversesentenceandreverseword {

	
	
	public static void main(String[] args)
	{
		String s="MY NAME IS";
		//output        SI EMAN YM
		
		String[] newone=reverse(s);
		
		
		for(int i=0;i<newone.length;i++)
		{
			System.out.print(newone[i]);
		}
	}
	
	public static String[] reverse(String s1)
	{
		
		String[] s2=s1.split("");
		String temp="";
		int j=s2.length-1;
		for(int i=0;i<s2.length/2;i++)
		{
			temp=s2[i];
			s2[i]=s2[j];
			s2[j]=temp;
			--j;
		}
		
		return s2;
	}
}
