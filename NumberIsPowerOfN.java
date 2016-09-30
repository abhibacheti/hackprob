package com.git;

public class NumberIsPowerOfN {
	public static void main(String []args){
		long t1 = System.currentTimeMillis(); 
		int num=16777216;
		int n =4;
		int result = (int)(Math.log(num)/ Math.log(n));
		if(Math.pow(n, result) == num){
			System.out.println(num+" is power of "+n+" with "+n+" ^ "+result);
		}else{
			System.out.println(num+" is not power of "+n);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Exceution time(millis) : "+(t2-t1));
	}
}
