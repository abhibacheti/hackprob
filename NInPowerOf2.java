package com.git;

public class NInPowerOf2 {
	public static void main(String []args){
		int num=16;
		int result = (int)(Math.log(num & -num)/ Math.log(2));
		System.out.println(result);
	}
}
