package math;

/**
* The MyMath provides the arithmetic operation of
* the factorial.
*
* @author  Maria Gkoulta
*/
public class MyMath {

	/**
	 * Performs the operation of factorial
	 * @param number for which the factorial is calculated
	 * @return the result of the factorial
	 * @exception IllegalArgumentException when the number 
	 * is less than zero or greater than twelve  
	 */
	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("The number cannot be less than zero or greater than 12");
		} else {
			int fact = 1;
	        for (int i = 2; i <= n; i++) {
	        fact = fact * i;
	        }
	        return fact;
		}
	}
	
	//Step6_Part2
	/**
	 * Checks if a number is prime
	 * @param number which is checked
	 * @return true if number is prime, else false
	 * @exception IllegalArgumentException when the number 
	 * is less than two  
	 */
	public boolean isPrime(int number) {
		if (number < 2) {
			throw new IllegalArgumentException("The number cannot be less than two");
		} else {
			for (int i = 2; i < number; i++) 
			{
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
