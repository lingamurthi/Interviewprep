package com.lingu;

public class Reverseusingfor {

	
	public static void main(String[] args)
	{
		
		String s="MY NAME IS GOOD";
		
		//output is DOOG SI EMAN YM
		String[] s1=s.split("");
		int j=s1.length-1;
	
		String temp="";
		for(int i=0;i<s1.length/2;i++)
		{
			temp=s1[i];
			s1[i]=s1[j];
			s1[j]=temp;
			j--;
			
			
		}
		
		
		for(int i=0;i<s1.length;i++)
		{
			System.out.print(s1[i]);
		}
	}
}
