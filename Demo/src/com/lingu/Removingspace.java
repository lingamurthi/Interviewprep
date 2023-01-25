package com.lingu;

import java.util.Arrays;


public class Removingspace {

	public static void main(String[] args) {
		String a = "My    name    is";
		String a3 = "My name is";
		Object[] result = Arrays.stream(a.split(" ")).filter(b -> b != "").toArray();
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		


	}

}
