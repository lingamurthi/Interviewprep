package com.lingu;

import java.util.Arrays;



// class Reversesentence {
//
//	public static void main(String[] args)
//	{
//	 String s="I am good";
//	 
//	 //output is      good am I
//
//		String s3=reversea(s);
//		System.out.println(s3);
//		
//		
//		
//		
//	}
//		
//		
//		
//		
//		public static String reversea(String s1)
//		{
//			
//			int space=s1.indexOf(" ");
//			if(space == -1)
//			{
//				return s1;
//			}
//			
//			return reversea(s1.substring(space+1))+" "+s1.substring(0,space);
//			
//		}
//		
//	
//}






class Reversesentence {

	public static void main(String[] args)
	{
	 String s="MY NAME IS GOOD";
	 
	 //output is      GOOD IS NAME MY 

		String s3[]=reversea(s);
		for(int i=0;i<s3.length;i++)
		{
			System.out.print(s3[i]+" ");
		}
		
		
		
		
	}
		
		
		
		
		public static String[] reversea(String s1)
		{
			
			String[] s2=s1.split(" ");
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





//class Reversesentence {
//
//	public static void main(String[] args) {
//		String s = "MY NAME IS GOOD";
//		//output is YM EMAN SI DOOG 
//
//		Object[] s3 = Arrays.stream(s.split(" ")).filter(a -> a != "").toArray();
//String newa;
//		for (int i = 0; i < s3.length; i++) {
//			newa=reversestring(s3[i]);
//
//			System.out.print(newa);
//			
//
//		}
//
//	}
//
//	public static String reversestring(Object s3) {
//		String rev="";
//		   String[] s4= ((String) s3).split("");
//		   
//		   for(int i=0;i<s4.length;i++){
//	            rev = s4[i]+""+rev;
//	        }
//		   rev+=" ";
//		   
//		   return rev;
//	        
//		   
//		   
//	}
//	
//}
