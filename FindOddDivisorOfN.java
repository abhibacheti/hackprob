public class OddDisvisorOfN{

  public static int primeFactors(int n)
	    {
	    	Map<Integer, Integer> count = new HashMap();
	    	int noOfOddFactors = 1;
	        // Print the number of 2s that divide n
	        while (n%2==0)
	        {
	            //System.out.print(2 + " ");
	            n /= 2;
	        }
	 
	        // n must be odd at this point.  So we can
	        // skip one element (Note i = i +2)
	        
	        for (int i = 3; i <= Math.sqrt(n); i+= 2)
	        {
	            // While i divides n, print i and divide n
	            while (n%i == 0)
	            {
	                //System.out.print(i + " ");
	                n /= i;
	                count.put(i, count.get(i) == null?1:count.get(i)+1);
	            }
	        }
	 
	        // This condition is to handle the case whien
	        // n is a prime number greater than 2
	        if (n > 2){
	            //System.out.print(n);
	            count.put(n, count.get(n) == null?1:count.get(n)+1);
	        }
	        //System.out.println(count);
	        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
	        	noOfOddFactors *= entry.getValue()+1;
	        }
	        return noOfOddFactors;
	    }
}
