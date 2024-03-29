package com.lingu;



//Java program to segregate even and odd elements of array
import java.io.*;

class Segregratingoddandeven
{
	static void segregateEvenOdd(int arr[])
	{
		/* Initialize left and right indexes */
		int left = 0, right = arr.length - 1;
		int temp;
		while (left < right)
		{
			/* Increment left index while we see 0 at left */
			while (arr[left] == 0 && left < right)
				arr[left++]=0;

			/* Decrement right index while we see 1 at right */
			while (arr[right] == 1 && left < right)
				arr[right--]=1;

			if(left<right)
			{
				temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
			}
			left++;
			right--;
		}
	}

	/* Driver program to test above functions */
	public static void main (String[] args)
	{
		int arr[] = {1,1,1,1,0,1};

		segregateEvenOdd(arr);

		System.out.print("Array after segregation ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}
}
/*This code is contributed by Devesh Agrawal*/
