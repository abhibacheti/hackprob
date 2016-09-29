
public class NthBinaryPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		int nth =1;
		int noOfBits = 1;
		int higherRange = 1;
		int lowerRange =1;
		long nthBinaryPalindromeNum;
		if(nth < 2){
			higherRange = 1;
			nthBinaryPalindromeNum = 1;
		}else{
			higherRange = 2;
			for(noOfBits = 1; higherRange<nth; noOfBits++){
				lowerRange = higherRange;
				higherRange += 2<<((noOfBits-1)>>1);
			}
			noOfBits += 1;
			int numToBeAdd = nth - lowerRange - 1; 
			int originalHalfBinaryNum;
			boolean noOfBitsIsEven = (noOfBits & 1) == 0? true : false;
			
			if(noOfBitsIsEven){
				originalHalfBinaryNum = 1 << ((noOfBits/2) - 1);
				originalHalfBinaryNum |=  numToBeAdd;
				String firstHalfBinary = Integer.toBinaryString(originalHalfBinaryNum);
				String secondHalfBinary = new StringBuilder(firstHalfBinary).reverse().toString();
				nthBinaryPalindromeNum = Long.parseLong(firstHalfBinary + secondHalfBinary,2);
			}else{
				originalHalfBinaryNum = 1 << ((noOfBits/2));
				originalHalfBinaryNum |=  numToBeAdd;
				String temp = Integer.toBinaryString(originalHalfBinaryNum);
				String firstHalfBinary = temp.substring(0,temp.length()-1);
				String middleBinaryValue = temp.substring(temp.length()-1);
				String secondHalfBinary = new StringBuilder(firstHalfBinary).reverse().toString();
				nthBinaryPalindromeNum = Long.parseLong(firstHalfBinary + middleBinaryValue + secondHalfBinary,2);			
			}	
		}
		
		long t2 = System.currentTimeMillis();		
			
		
		System.out.println("Nth number to be find = "+nth);
		System.out.println("Lower Range = "+lowerRange);
		System.out.println("Higher Range = "+higherRange);
		System.out.println("No of bits = "+noOfBits);
		System.out.println("nthBinaryPalindromeNum in binary = "+Long.toBinaryString(nthBinaryPalindromeNum));
		System.out.println("nthBinaryPalindromeNum = "+nthBinaryPalindromeNum);
		System.out.println("Execution time(millis) = "+(t2-t1));
		
	}

}
