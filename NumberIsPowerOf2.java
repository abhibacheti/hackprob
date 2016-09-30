package com.git;

public class NumberIsPowerOf2 {
	public static void main(String []args){
		int n=127;		
		if((n & -n) == n){
			System.out.println(n+" number is in power of 2");
		}else{
			System.out.println(n+" number is not in power of 2");
		}
	}
}
