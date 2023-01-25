
package com.lingu;

import java.util.Arrays;

public class Reversewordinthesentence {

	
	
	public static void main(String[] args)
	{
		String s="MY            NAME                 IS";
		//output is YM EMAN SI 
		String[] s1=s.split(" ");
		
		
		  Object[] newone = Arrays.stream(s.split(" ")).filter(a->a!="").toArray();
		String output;
		for(int i=0;i<newone.length;i++)
		{
			output=reverse(newone[i]);
	       System.out.print(output+" ");
		}
		
	}
	
	
	public static String reverse(Object newone)
	{
		
		String[] splitted= ((String) newone).split("");
		String temp="";
		
		
		for(int i=0;i<splitted.length;i++)
		{
		temp=splitted[i]+temp;
		}
		
		return temp;
	}
}
