package com.blueoptima.test;


import java.util.Scanner;

class TheStreetAffairProblem {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int j = 0; j < T; j++) {			
			int a = s.nextInt();
			System.out.println(getResult(a));
			
		}
				

	}

	// compute a*b mod K where a and b are square matrices of the same size
	static long[][] computeMatrixMultiplication(long a[][], long b[][], long K) {
		int n = a.length;
		long resultArr[][] = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long result = 0;
				for (int k = 0; k < n; k++) {
					result = result + (a[i][k] * b[k][j]);
				}
				result = result % K;
				resultArr[i][j] = result;
			}
		}
		return resultArr;
	}
	
	// compute a^n mod K where a is a square matrix
	static long[][] computeMatrixPower(long a[][], long n, long K) {
		int n1 = a.length;

		if (n == 0) {
			long resultArr[][] = new long[n1][n1];
			for (int j = 0; j < n1; j++) {
				for (int i = 0; i < n1; i++) {
					if (i == j) {
						resultArr[j][i] = 1;
					} else {
						resultArr[j][i] = 0;
					}
				}
			}
			return resultArr;
		}

		if (n % 2 != 0) {
			return computeMatrixMultiplication(computeMatrixPower(a, n - 1, K), a, K);
		}
		long a2[][] = computeMatrixPower(a, n / 2, K);
		return computeMatrixMultiplication(a2, a2, K);
	}
	static long[][] M = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
	
	static long getResult(long n){
		long K = 1000000007;
		long[][] resultArr = computeMatrixPower(M, n-1, K);
		long n1 = resultArr.length;
		long result = 0;
		for(int i=0;i<n1;i++){
			for(int j=0;j<n1;j++){
				result = result + resultArr[i][j]; 
			}
		}
		return result%K;
	}
}
