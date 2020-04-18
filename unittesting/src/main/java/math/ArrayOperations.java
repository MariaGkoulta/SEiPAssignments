package math;

import java.util.List;
import java.util.ArrayList;

import io.FileIO;

/**
 * This class provides method to find
 * prime number in a file
 *
 * @author Maria Gkoulta
 *
 */
public class ArrayOperations {

	/**
	 * Performs the operation of factorial
	 * @param number for which the factorial is calculated
	 * @return the result of the factorial
	 * @exception IllegalArgumentException when the number
	 * is less than zero or greater than twelve
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		int[] numbers = fileIo.readFile(filepath);
		List<Integer> primes = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			if (myMath.isPrime(numbers[i])) {
			  primes.add(numbers[i]);
			}
		}
		return primes.stream().mapToInt(i -> i).toArray();
	}
}
