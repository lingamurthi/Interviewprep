package com.lingu;

import java.util.Arrays;

public class Removespaces {

	
	public static void main(String[] args)
	{
		String s="MY	NAME    IS";
		//MY NAME IS 
		removespace(s);
		
	}
	
	
	public static void removespace(String s1)
	{
		Object[] newone = Arrays.stream(s1.split(" ")).filter(a->a!="").toArray();
		String temp="";
		for(int i=0;i<newone.length;i++)
		{
			temp=newone[i]+" ";
			System.out.print(temp);
		}
	
	}
}
